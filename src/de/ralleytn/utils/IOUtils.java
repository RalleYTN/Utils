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
