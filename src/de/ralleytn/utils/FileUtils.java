/*
 * MIT License
 * 
 * Copyright (c) 2017 Ralph Niemitz
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.ralleytn.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Provides useful methods for working with files.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class FileUtils {

	private FileUtils() {}
	
	/**
	 * 
	 * @param file
	 * @param targetDirectory
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final File move(File file, File targetDirectory) throws IOException {
		
		Path source = file.toPath();
		File targetFile = new File(targetDirectory, file.getName());
		Path target = targetFile.toPath();
		
		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		return targetFile;
	}
	
	/**
	 * 
	 * @param file
	 * @param targetDirectory
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final File copy(File file, File targetDirectory) throws IOException {
		
		Path source = file.toPath();
		File targetFile = new File(targetDirectory, file.getName());
		Path target = targetFile.toPath();
		
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		return targetFile;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final File createTempFile(String name) throws IOException {

		File tempFile = new File(SystemUtils.getTempDirectory(), name.replace("/", File.separator).replace("\\", File.separator));
		File parent = tempFile.getParentFile();
		
		if(!parent.exists()) {
			
			parent.mkdirs();
		}
		
		tempFile.createNewFile();
		tempFile.deleteOnExit();
		
		return tempFile;
	}
	
	/**
	 * 
	 * @param directory
	 * @since 1.0.0
	 */
	public static final void deleteDirectory(File directory) {
		
		List<File> directories = new ArrayList<>();
		FileUtils.crawl(directory, file -> {
			
			if(file.isFile()) {
				
				file.delete();
				
			} else {
				
				directories.add(file);
			}
		});
		directories.forEach(File::delete);
		directory.delete();
	}
	
	/**
	 * 
	 * @param root
	 * @param callback
	 * @since 1.0.0
	 */
	public static final void crawl(File root, Consumer<File> callback) {
		
		File[] subFiles = root.listFiles();
		
		if(subFiles != null) {
			
			for(File subFile : subFiles) {
				
				if(subFile.isDirectory()) {
					
					FileUtils.crawl(subFile, callback);
					
				}
				
				callback.accept(subFile);
			}
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param filter
	 * @return
	 * @since 1.0.0
	 */
	public static final List<File> search(File root, FileFilter filter) {
		
		List<File> results = new ArrayList<File>();
		FileUtils.crawl(root, file -> {
			
			if(filter.accept(file)) {
				
				results.add(file);
			}
		});

		return results;
	}
}
