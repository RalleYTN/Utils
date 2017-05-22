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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class ZipUtils {

	private ZipUtils() {}
	
	/**
	 * 
	 * @param zip
	 * @param callback
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void forEach(File zip, Consumer<ZipEntry> callback) throws IOException {

		try(ZipFile zipFile = new ZipFile(zip)) {

			Enumeration<? extends ZipEntry> enumeration = zipFile.entries();

			while(enumeration.hasMoreElements()) {

				callback.accept(enumeration.nextElement());
			}
		}
	}
	
	/**
	 * 
	 * @param zip
	 * @param entry
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final InputStream getInputStream(File zip, String entry) throws IOException {

		try(ZipFile zipFile = new ZipFile(zip)) {

			return zipFile.getInputStream(zipFile.getEntry(entry));
		}
	}
	
	/**
	 * 
	 * @param zip
	 * @param files
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final File pack(File zip, Map<String, File> files) throws IOException {

		if(zip.exists() && zip.getName().toUpperCase().endsWith(".ZIP") && zip.isFile()) {
			
			ZipUtils.unpack(zip, FileUtils.createTempFile(zip.getName()));

			ZipUtils.forEach(zip, entry -> {
					
				if(!entry.toString().endsWith("/")) {
						
					String path = (System.getProperty("java.io.tmpdir") + '/' + zip.getName() + '/' + entry.toString());
					files.put(entry.toString(), new File(path));
				}
			});
		}
		
		try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zip))) {

			for(Map.Entry<String, File> entry : files.entrySet()) {

				try(FileInputStream fileInputStream = new FileInputStream(entry.getValue())) {

					zipOutputStream.putNextEntry(new ZipEntry(entry.getKey().replace('\\', '/')));
					IOUtils.write(fileInputStream, zipOutputStream);
					zipOutputStream.closeEntry();
				}
			}
		}
		
		return zip;
	}
	
	/**
	 * 
	 * @param zip
	 * @param targetDirectory
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void unpack(File zip, File targetDirectory) throws IOException {

		ZipUtils.forEach(zip, entry -> {
			
			if(!entry.isDirectory()) {

				String entryName = entry.getName().replace("/", File.separator).replace("\\", File.separator);
				File targetFile = new File(targetDirectory.getAbsolutePath() + File.separator + entryName);
				File targetFilesParentDirectory = targetFile.getParentFile();

				if(!targetFilesParentDirectory.exists()) {

					targetFilesParentDirectory.mkdirs();
				}

				try {
					
					Files.copy(FileSystems.newFileSystem(zip.toPath(), null).getPath(entryName), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				
				} catch(IOException exception) {
					
					exception.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * @param zip
	 * @param entry
	 * @param target
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void extract(File zip, String entry, File target) throws IOException {

		Files.copy(FileSystems.newFileSystem(zip.toPath(), null).getPath(entry), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
}