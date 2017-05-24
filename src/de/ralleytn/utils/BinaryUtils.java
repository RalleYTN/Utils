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
import java.io.IOException;
import java.util.List;

/**
 * Provides some helpful methods for binary operations.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.1.1
 * @since 1.1.0
 */
public final class BinaryUtils {

	private BinaryUtils() {}
	
	/**
	 * Reads an {@code int} octet for octet.
	 * @param integer {@code int} from which you want only one octet
	 * @param position position from the right side
	 * @return the octet on the given position
	 * @since 1.1.1
	 */
	public static final int getOctet(int integer, int position) {
		
		return (integer >> (position * 8)) & 0xFF;
	}
	
	/**
	 * Reads an {@code int} bit by bit.
	 * @param integer {@code int} from which you want only one bit
	 * @param position position from the right side
	 * @return the bit on the given position
	 * @since 1.1.1
	 */
	public static final boolean getBit(int integer, int position) {
		
		return ((integer >> position) & 1) == 1;
	}
	
	/**
	 * Builds an unsigned {@code int} with from four octets.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param o3 third octet
	 * @param o4 fourth octet
	 * @return the resulting unsigned {@code int}
	 * @since 1.1.0
	 */
	public static final long getUnsignedInteger(int o1, int o2, int o3, int o4) {
		
		return BinaryUtils.getSignedInteger(o1, o2, o3, o4) & 0xFFFFFFFFL;
	}
	
	/**
	 * Builds a signed {@code int} with from four octets.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param o3 third octet
	 * @param o4 fourth octet
	 * @return the resulting signed {@code int}
	 * @since 1.1.0
	 */
	public static final int getSignedInteger(int o1, int o2, int o3, int o4) {
		
		return ((o1 & 0xFF) << 24) | ((o2 & 0xFF) << 16) | ((o3 & 0xFF) << 8) | (o4 & 0xFF);
	}
	
	/**
	 * Converts an {@linkplain Integer} list to a {@code byte} array.
	 * @param integers list of {@linkplain Integer}s
	 * @return the resulting {@code byte} array
	 * @since 1.1.0
	 */
	public static final byte[] toByteArray(List<Integer> integers) {
		
		try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
			
			integers.forEach(buffer::write);
			return buffer.toByteArray();
			
		} catch(IOException exception) {
			
			exception.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Converts an {@code int} array to a {@code byte} array.
	 * @param integers array of {@code int}s.
	 * @return the resulting {@code byte} array
	 * @since 1.1.0
	 */
	public static final byte[] toByteArray(int[] integers) {
		
		try(ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
			
			for(int integer : integers) {
				
				buffer.write(integer);
			}
			
			return buffer.toByteArray();
			
		} catch(IOException exception) {
			
			exception.printStackTrace();
		}
		
		return null;
	}
}
