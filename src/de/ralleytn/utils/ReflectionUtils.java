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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides helpful methods regarding the Reflection API.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 27.06.2017
 * @since 1.1.2
 */
public final class ReflectionUtils {

	private ReflectionUtils() {}
	
	/**
	 * 
	 * @return
	 * @since 27.06.2017
	 */
	public static final String getCallerClassName() {
		
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		
		for(int index = 1; index < stackTrace.length; index++) {
			
			if(!stackTrace[index].getClassName().equals(ReflectionUtils.class.getName()) && stackTrace[index].getClassName().indexOf(Thread.class.getName()) != 0) {
                
				return stackTrace[index].getClassName();
            }
		}
		
		return null;
	}
	
	/**
	 * @param packageName name of the package
	 * @return a list with all {@linkplain Class} instances in the given package
	 * @throws IOException if an I/O error occurs
	 * @throws ClassNotFoundException if a class cannot be located (should never happen)
	 * @since 1.1.2
	 */
	public static final List<Class<?>> getPackage(String packageName) throws IOException, ClassNotFoundException {
		
		ClassLoader cl = ReflectionUtils.class.getClassLoader();
		List<Class<?>> classes = new ArrayList<>();
		URL pkg = cl.getResource(packageName.replace('.', '/'));
		DataInputStream dis = new DataInputStream((InputStream)pkg.getContent());
		String line = null;
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(dis))) {
			
			while((line = reader.readLine()) != null) {
				
				if(line.toUpperCase().endsWith(".CLASS")) {
					
					Class<?> clazz = Class.forName(packageName + "." + line.substring(0, line.indexOf('.')));
					classes.add(clazz);
				}
			}
		}
		
		return classes;
	}
}
