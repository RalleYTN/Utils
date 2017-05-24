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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides some helpful method regarding input and output.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.1.1
 * @since 1.0.0
 */
public final class IOUtils {

	private IOUtils() {}
	
	/**
	 * Reads until it finds the given sequence in the {@linkplain InputStream}.
	 * If the end of the stream is reached and the sequence wasn't found an {@linkplain IOException} is thrown.
	 * @param inputStream the {@linkplain InputStream} in which you want to find a given sequence
	 * @param sequencethe sequence you search for
	 * @throws IOException if an I/O error occurs or the end of the stream was reached while the sequence wasn't found
	 * @since 1.1.1
	 */
	public static final void readUntil(InputStream inputStream, int[] sequence) throws IOException {
		
		List<Integer> readBytes = new ArrayList<>();
		int readByte = -1;
		
		while((readByte = inputStream.read()) != -1) {
			
			if(readBytes.size() >= sequence.length - 1) {
				
				boolean correct = true;
				int current = 1;
				
				for(int index = sequence.length - 2; index >= 0; index--) {
					
					if(readBytes.get(readBytes.size() - current) != sequence[index]) {
						
						correct = false;
						break;
					}
					
					current++;
				}
				
				if(correct && readByte == sequence[sequence.length - 1]) {
					
					return;
				}
			}
			
			readBytes.add(readByte);
		}
		
		throw new IOException("Could not find the given sequence!");
	}
	
	/**
	 * Reads a {@linkplain String} with the given length from the {@linkplain InputStream}.
	 * @param inputStream the {@linkplain InputStream} from which the data is read
	 * @param length the length of the data
	 * @param charset the {@linkplain Charset} with which the data will be encoded
	 * @return the resulting {@linkplain String}
	 * @throws IOException if an I/O error occurs
	 * @since 1.1.1
	 */
	public static final String readString(InputStream inputStream, int length, Charset charset) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, length);
		return new String(BinaryUtils.toByteArray(octets), charset.name());
	}
	
	/**
	 * Reads the next four bytes of the stream and returns them as an unsigned integer.
	 * @param inputStream the {@linkplain InputStream} to read the data from
	 * @return an unsigned ineteger
	 * @throws IOException if an I/O error occurs
	 * @since 1.1.1
	 */
	public static final long readUnsignedInt(InputStream inputStream) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 4);
		return BinaryUtils.getUnsignedInteger(octets[3], octets[2], octets[1], octets[0]);
	}
	
	/**
	 * Reads the next four bytes of the stream and returns them as a signed integer.
	 * @param inputStream the {@linkplain InputStream} to read the data from
	 * @return an unsigned ineteger
	 * @throws IOException if an I/O error occurs
	 * @since 1.1.1
	 */
	public static final int readSignedInt(InputStream inputStream) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 4);
		return BinaryUtils.getSignedInteger(octets[3], octets[2], octets[1], octets[0]);
	}
	
	/**
	 * Reads a fixed amount of unsigned {@code byte}s from an {@linkplain InputStream}.
	 * @param inputStream the {@linkplain InputStream} from which you want to read the data
	 * @param length the length of data to be read
	 * @return the read data
	 * @throws IOException if an I/O error occurs
	 * @since 1.1.1
	 */
	public static final int[] read(InputStream inputStream, int length) throws IOException {
		
		int[] data = new int[length];
		
		for(int index = 0; index < data.length; index++) {
			
			data[index] = inputStream.read();
		}
		
		return data;
	}
	
	/**
	 * Reads an entire {@linkplain InputStream}.
	 * @param inputStream the {@linkplain InputStream} to read
	 * @return the read data
	 * @throws IOException if an I/O error occurs
	 * @since 1.0.0
	 */
	public static final byte[] read(InputStream inputStream) throws IOException {
		
		try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
			
			IOUtils.write(inputStream, buffer);
			return buffer.toByteArray();
		}
	}
	
	/**
	 * Writes the contents from the given {@linkplain InputStream} on the {@linkplain OutputStream}.
	 * @param inputStream the {@linkplain InputStream}
	 * @param outputStream the {@linkplain OutputStream}
	 * @throws IOException if an I/O error occurs
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
	 * Calls {@link Flushable#flush()} without throwing an exception and only if the given {@linkplain Flushable}
	 * is not {@code null}.
	 * @param flushable the {@linkplain Flushable} you want to flush
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
	 * Calls {@link Closable#close()} without throwing an exception and only if the given {@linkplain Closable}
	 * is not {@code null}.
	 * @param closeable the {@linkplain Closable} you want to close
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
