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
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * Provides some helpful method regarding input and output.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 */
public final class IOUtils {

	private IOUtils() {}
	
	/**
	 * Reads until it finds the given sequence in the {@linkplain InputStream}.
	 * If the end of the stream is reached and the sequence wasn't found an {@linkplain IOException} is thrown.
	 * @param inputStream the {@linkplain InputStream} in which you want to find a given sequence
	 * @param sequencethe sequence you search for
	 * @throws IOException if an I/O error occurs or the end of the stream was reached while the sequence wasn't found
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
	 */
	public static final String readString(InputStream inputStream, int length, Charset charset) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, length);
		return new String(BinaryUtils.toByteArray(octets), charset.name());
	}
	
	/**
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static final long readUnsignedInt(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 4);
		return BinaryUtils.getUnsignedInteger(octets[3], octets[2], octets[1], octets[0], bigEndian);
	}
	
	/**
	 * Reads the next four bytes of the stream and returns them as an unsigned integer.
	 * @param inputStream the {@linkplain InputStream} to read the data from
	 * @return an unsigned ineteger
	 * @throws IOException if an I/O error occurs
	 */
	public static final long readUnsignedInt(InputStream inputStream) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 4);
		return BinaryUtils.getUnsignedInteger(octets[3], octets[2], octets[1], octets[0]);
	}
	
	/**
	 * Reads the next 8 byte as a signed small endian {@code double}.
	 * @param inputStream the input stream
	 * @return the read {@code double}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final double readDouble(InputStream inputStream) throws IOException {
		
		return IOUtils.readDouble(inputStream, false);
	}
	
	/**
	 * Reads the next 8 byte as a signed {@code double}.
	 * @param inputStream the input stream
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the read {@code double}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final double readDouble(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 8);
		return Double.longBitsToDouble(BinaryUtils.getSignedLong(octets[7], octets[6], octets[5], octets[4], octets[3], octets[2], octets[1], octets[0], bigEndian));
	}
	
	/**
	 * Reads a small endian 64 bit signed integer.
	 * @param inputStream the input stream
	 * @return the read {@code long}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final long readSignedLong(InputStream inputStream) throws IOException {
		
		return IOUtils.readSignedLong(inputStream, false);
	}
	
	/**
	 * Reads a 64 bit signed integer.
	 * @param inputStream the input stream
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the read {@code long}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final long readSignedLong(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 8);
		return BinaryUtils.getSignedLong(octets[7], octets[6], octets[5], octets[4], octets[3], octets[2], octets[1], octets[0], bigEndian);
	}
	
	/**
	 * Reads a small endian 16 bit unsigned integer.
	 * @param inputStream the input stream
	 * @return the read {@code int}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final int readUnsignedShort(InputStream inputStream) throws IOException {
		
		return IOUtils.readUnsignedShort(inputStream, false);
	}
	
	/**
	 * Reads a 16 bit unsigned integer.
	 * @param inputStream the input stream
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the read {@code int}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final int readUnsignedShort(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 2);
		return BinaryUtils.getUnsignedShort(octets[1], octets[0], bigEndian);
	}
	
	/**
	 * Reads a small endian 16 bit signed integer.
	 * @param inputStream the input stream
	 * @return the read {@code short}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final short readSignedShort(InputStream inputStream) throws IOException {
		
		return IOUtils.readSignedShort(inputStream, false);
	}
	
	/**
	 * Reads a 16 bit signed integer.
	 * @param inputStream the input stream
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the read {@code short}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final short readSignedShort(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 2);
		return BinaryUtils.getSignedShort(octets[1], octets[0], bigEndian);
	}
	
	/**
	 * 
	 * @param inputStream
	 * @param bigEndian
	 * @return
	 * @throws IOException
	 */
	public static final int readSignedInt(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 4);
		return BinaryUtils.getSignedInteger(octets[3], octets[2], octets[1], octets[0], bigEndian);
	}
	
	/**
	 * Reads the next four bytes of the stream and returns them as a signed integer.
	 * @param inputStream the {@linkplain InputStream} to read the data from
	 * @return an unsigned ineteger
	 * @throws IOException if an I/O error occurs
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
	 */
	public static final byte[] read(InputStream inputStream) throws IOException {
		
		try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
			
			IOUtils.write(inputStream, buffer);
			return buffer.toByteArray();
		}
	}
	
	/**
	 * Reads the given input stream line by line.
	 * @param inputStream the input stream
	 * @param callback the callback function that is called for every line
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final void read(InputStream inputStream, Consumer<String> callback) throws IOException {
		
		try(BufferedReader reader = IOUtils.createReader(inputStream)) {
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				callback.accept(line);
			}
		}
	}
	
	
	/**
	 * Reads a small endian 4 byte signed {@code float} from an input stream.
	 * @param inputStream the input stream
	 * @return the read {@code float}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final float readFloat(InputStream inputStream) throws IOException {
		
		return IOUtils.readFloat(inputStream, false);
	}
	
	/**
	 * Reads a 4 byte signed {@code float} from the given input stream.
	 * @param inputStream the input stream
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the read {@code float}
	 * @throws IOException if something went wrong while reading from the input stream
	 */
	public static final float readFloat(InputStream inputStream, boolean bigEndian) throws IOException {
		
		int[] octets = IOUtils.read(inputStream, 4);
		return Float.intBitsToFloat(BinaryUtils.getSignedInteger(octets[3], octets[2], octets[1], octets[0], bigEndian));
	}
	
	public static final void write(Collection<String> lines, OutputStream outputStream) throws IOException {
		
		try(BufferedWriter writer = IOUtils.createWriter(outputStream)) {
			
			for(String line : lines) {
				
				writer.write(line);
				writer.write('\n');
			}
		}
	}
	
	/**
	 * Writes the contents from the given {@linkplain InputStream} on the {@linkplain OutputStream}.
	 * @param inputStream the {@linkplain InputStream}
	 * @param outputStream the {@linkplain OutputStream}
	 * @throws IOException if an I/O error occurs
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
	 */
	public static final void close(Closeable closeable) {
		
		try {
			
			if(closeable != null) {
				
				closeable.close();
			}
			
		} catch(Exception exception) {}
	}
	
	public static final BufferedWriter createWriter(File file) throws IOException {
		
		return IOUtils.createWriter(new FileOutputStream(file));
	}
	
	public static final BufferedWriter createWriter(File file, Charset charset) throws IOException {
		
		return IOUtils.createWriter(new FileOutputStream(file), charset);
	}
	
	public static final BufferedWriter createWriter(OutputStream outputStream) throws IOException {
		
		return new BufferedWriter(new OutputStreamWriter(outputStream));
	}
	
	public static final BufferedWriter createWriter(OutputStream outputStream, Charset charset) throws IOException {
		
		return new BufferedWriter(new OutputStreamWriter(outputStream, charset));
	}
	
	public static final BufferedReader createReader(File file) throws IOException {
		
		return IOUtils.createReader(new FileInputStream(file));
	}
	
	public static final BufferedReader createReader(File file, Charset charset) throws IOException {
		
		return IOUtils.createReader(new FileInputStream(file), charset);
	}
	
	public static final BufferedReader createReader(InputStream inputStream) throws IOException {
		
		return new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public static final BufferedReader createReader(InputStream inputStream, Charset charset) throws IOException {
		
		return new BufferedReader(new InputStreamReader(inputStream, charset));
	}
}
