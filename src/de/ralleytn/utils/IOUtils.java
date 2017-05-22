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

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class IOUtils {

	private IOUtils() {}
	
	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final byte[] read(InputStream inputStream) throws IOException {
		
		try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
			
			IOUtils.write(inputStream, buffer);
			return buffer.toByteArray();
		}
	}
	
	/**
	 * 
	 * @param inputStream
	 * @param outputStream
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void write(InputStream inputStream, OutputStream outputStream) throws IOException {
		
		byte[] buffer = new byte[4096];
		int read = 0;
				
		while((read = inputStream.read(buffer)) > 0) {
			            
			outputStream.write(buffer, 0, read);
		}
				
		outputStream.flush();
	}
	
	/**
	 * 
	 * @param flushable
	 * @since 1.0.0
	 */
	public static final void flush(Flushable flushable) {
		
		try {
			
			if(flushable != null) {
				
				flushable.flush();
			}
			
		} catch(Exception exception) {}
	}

	/**
	 * 
	 * @param closeable
	 * @since 1.0.0
	 */
	public static final void close(Closeable closeable) {
		
		try {
			
			if(closeable != null) {
				
				closeable.close();
			}
			
		} catch(Exception exception) {}
	}
}
