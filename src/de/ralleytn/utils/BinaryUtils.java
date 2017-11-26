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
 */
public final class BinaryUtils {

	private BinaryUtils() {}
	
	/**
	 * Reads an {@code int} octet for octet.
	 * @param integer {@code int} from which you want only one octet
	 * @param position position from the right side
	 * @return the octet on the given position
	 */
	public static final int getOctet(long integer, int position) {
		
		return (int)((integer >> (position * 8)) & 0xFF);
	}
	
	/**
	 * Sets the value of a single bit in a bit chain.
	 * @param original the data that should be modified
	 * @param position the position of the bit (right to left)
	 * @param value the new value of the bit at the given position
	 * @return the modified data
	 */
	public static final int setBit(int original, int position, boolean value) {
		
		return value ? original | (1 << position) : original & ~(1 << position);
	}
	
	/**
	 * Reads an {@code int} bit by bit.
	 * @param integer {@code int} from which you want only one bit
	 * @param position position from the right side
	 * @return the bit on the given position
	 */
	public static final boolean getBit(int integer, int position) {
		
		return ((integer >> position) & 1) == 1;
	}
	
	/**
	 * Builds an unsigned {@code int} from four octets. big endian.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param o3 third octet
	 * @param o4 fourth octet
	 * @return the resulting unsigned {@code int}
	 */
	public static final long getUnsignedInteger(int o1, int o2, int o3, int o4) {
		
		return BinaryUtils.getSignedInteger(o1, o2, o3, o4, true) & 0xFFFFFFFFL;
	}
	
	/**
	 * 
	 * @param o1
	 * @param o2
	 * @param o3
	 * @param o4
	 * @param bigEndian
	 * @return
	 */
	public static final long getUnsignedInteger(int o1, int o2, int o3, int o4, boolean bigEndian) {
		
		return BinaryUtils.getSignedInteger(o1, o2, o3, o4, bigEndian) & 0xFFFFFFFFL;
	}
	
	/**
	 * Builds a signed {@code int} from four octets. big endian.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param o3 third octet
	 * @param o4 fourth octet
	 * @return the resulting signed {@code int}
	 */
	public static final int getSignedInteger(int o1, int o2, int o3, int o4) {
		
		return BinaryUtils.getSignedInteger(o1, o2, o3, o4, true);
	}
	
	/**
	 * 
	 * @param o1
	 * @param o2
	 * @param o3
	 * @param o4
	 * @param bigEndian
	 * @return
	 */
	public static final int getSignedInteger(int o1, int o2, int o3, int o4, boolean bigEndian) {
		
		return bigEndian ? ((o1 & 0xFF) << 24) | ((o2 & 0xFF) << 16) | ((o3 & 0xFF) << 8) | (o4 & 0xFF) : ((o4 & 0xFF) << 24) | ((o3 & 0xFF) << 16) | ((o2 & 0xFF) << 8) | (o1 & 0xFF);
	}
	
	/**
	 * Builds a signed small endian 64 bit integer.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param o3 third octet
	 * @param o4 fourth octet
	 * @param o5 fifth octet
	 * @param o6 sixth octet
	 * @param o7 seventh octet
	 * @param o8 eighth octet
	 * @return the built integer
	 */
	public static final long getSignedLong(int o1, int o2, int o3, int o4, int o5, int o6, int o7, int o8) {
		
		return BinaryUtils.getSignedLong(o1, o2, o3, o4, o5, o6, o7, o8, false);
	}
	
	/**
	 * Builds a signed 64 bit integer.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param o3 third octet
	 * @param o4 fourth octet
	 * @param o5 fifth octet
	 * @param o6 sixth octet
	 * @param o7 seventh octet
	 * @param o8 eighth octet
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the built integer
	 */
	public static final long getSignedLong(int o1, int o2, int o3, int o4, int o5, int o6, int o7, int o8, boolean bigEndian) {
		
		return bigEndian ? ((o1 & 0xFFL) << 56L) | ((o2 & 0xFFL) << 48L) | ((o3 & 0xFFL) << 40L) | ((o4 & 0xFFL) << 32L) | ((o5 & 0xFFL) << 24L) | ((o6 & 0xFFL) << 16L) | ((o7 & 0xFFL) << 8L) | (o8 | 0xFFL) : ((o8 & 0xFFL) << 56L) | ((o7 & 0xFFL) << 48L) | ((o6 & 0xFFL) << 40L) | ((o5 & 0xFFL) << 32L) | ((o4 & 0xFFL) << 24L) | ((o3 & 0xFFL) << 16L) | ((o2 & 0xFFL) << 8L) | (o1 | 0xFFL);
	}
	
	/**
	 * Builds a small endian unsigned 16 bit integer.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @return the built integer
	 */
	public static final int getUnsignedShort(int o1, int o2) {
		
		return BinaryUtils.getUnsignedShort(o1, o2, false);
	}
	
	/**
	 * Builds an unsigned 16 bit integer.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the built integer
	 */
	public static final int getUnsignedShort(int o1, int o2, boolean bigEndian) {
		
		return BinaryUtils.getSignedShort(o1, o2, bigEndian) & 0xFFFF;
	}
	
	/**
	 * Builds a small endian signed 16 bit integer.
	 * @param o1 first octet
	 * @param o2 second octet
	 * @return the built integer
	 */
	public static final short getSignedShort(int o1, int o2) {
		
		return BinaryUtils.getSignedShort(o1, o2, false);
	}
	
	/**
	 * Builds a signed 16 bit integer
	 * @param o1 first octet
	 * @param o2 second octet
	 * @param bigEndian {@code true} to use big endian, {@code false} for small endian
	 * @return the built integer
	 */
	public static final short getSignedShort(int o1, int o2, boolean bigEndian) {
		
		return (short)(bigEndian ? ((o1 & 0xFF) << 8) | (o2 & 0xFF) : ((o2 & 0xFF) << 8) | (o1 & 0xFF));
	}
	
	/**
	 * Converts an {@linkplain Integer} list to a {@code byte} array.
	 * @param integers list of {@linkplain Integer}s
	 * @return the resulting {@code byte} array
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
