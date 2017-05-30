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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides useful methods for working with arrays.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.2.0
 * @since 1.0.0
 */
public final class ArrayUtils {

	private ArrayUtils() {}
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final <T>void fill(T[] array, T value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(boolean[] array, boolean value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(byte[] array, byte value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(short[] array, short value) {
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = value;
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(char[] array, char value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(int[] array, int value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(long[] array, long value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(float[] array, float value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @since 1.2.0
	 */
	public static final void fill(double[] array, double value) {
		
		if(array != null) {
			
			for(int index = 0; index < array.length; index++) {
				
				array[index] = value;
			}
		}
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>boolean equals(T[] first, T[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(!first[index].equals(second[index])) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(boolean[] first, boolean[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(byte[] first, byte[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(short[] first, short[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(char[] first, char[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(int[] first, int[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(long[] first, long[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(float[] first, float[] second) {

		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean equals(double[] first, double[] second) {
		
		if(first == null && second == null) {
			
			return true;
		}

		if(first != null && second != null) {
			
			if(first.length == second.length) {
				
				for(int index = 0; index < first.length; index++) {
					
					if(first[index] != second[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] remove(Class<T> type, T[] array, int... indecies) {

		int length = array.length;
		int currentIndex = 0;
				
		@SuppressWarnings("unchecked")
		T[] newArray = (T[])Array.newInstance(type, length - indecies.length);
				
		for(int i = 0; i < length; i++) {
					
			if(!ArrayUtils.contains(indecies, i)) {
						
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
				
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] remove(boolean[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		boolean[] newArray = new boolean[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] remove(byte[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		byte[] newArray = new byte[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] remove(short[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		short[] newArray = new short[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] remove(char[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		char[] newArray = new char[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] remove(int[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		int[] newArray = new int[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] remove(long[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		long[] newArray = new long[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] remove(float[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		float[] newArray = new float[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param indecies
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] remove(double[] array, int... indecies) {
		
		int length = array.length;
		int currentIndex = 0;
		double[] newArray = new double[length - indecies.length];
		
		for(int i = 0; i < length; i++) {
			
			if(!ArrayUtils.contains(indecies, i)) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] remove(Class<T> type, T[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		T[] newArray = (T[])Array.newInstance(type, length - 1);
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] remove(boolean[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		boolean[] newArray = new boolean[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] remove(byte[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		byte[] newArray = new byte[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] remove(short[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		short[] newArray = new short[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] remove(char[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		char[] newArray = new char[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] remove(int[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		int[] newArray = new int[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] remove(long[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		long[] newArray = new long[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] remove(float[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		float[] newArray = new float[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] remove(double[] array, int index) {
		
		int length = array.length;
		int currentIndex = 0;
		double[] newArray = new double[length - 1];
		
		for(int i = 0; i < length; i++) {
			
			if(i != index) {
				
				newArray[currentIndex] = array[i];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>int lastIndexOf(T[] array, T value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index].equals(value)) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(boolean[] array, boolean value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(byte[] array, byte value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(short[] array, short value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(char[] array, char value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(int[] array, int value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(long[] array, long value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(float[] array, float value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int lastIndexOf(double[] array, double value) {
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>int indexOf(T[] array, T value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(boolean[] array, boolean value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(byte[] array, byte value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(short[] array, short value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(char[] array, char value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(int[] array, int value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(long[] array, long value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(float[] array, float value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(double[] array, double value) {
		
		return ArrayUtils.indexOf(array, value, 0);
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>int indexOf(T[] array, T value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index].equals(value)) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(boolean[] array, boolean value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(byte[] array, byte value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(short[] array, short value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(char[] array, char value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(int[] array, int value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(long[] array, long value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(float[] array, float value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int indexOf(double[] array, double value, int offset) {
		
		for(int index = offset; offset < array.length; offset++) {
			
			if(array[index] == value) {
				
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>boolean contains(T[] array, T value) {
		
		for(T element : array) {
			
			if(element.equals(value)) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(boolean[] array, boolean value) {
		
		for(boolean element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(byte[] array, byte value) {
		
		for(byte element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(short[] array, short value) {
		
		for(short element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(char[] array, char value) {
		
		for(char element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(int[] array, int value) {
		
		for(int element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(long[] array, long value) {
		
		for(long element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(float[] array, float value) {
		
		for(float element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean contains(double[] array, double value) {
		
		for(double element : array) {
			
			if(element == value) {
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] add(Class<T> type, T[] array, T value) {
		
		T[] newArray = ArrayUtils.append(type, array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] add(boolean[] array, boolean value) {
		
		boolean[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] add(byte[] array, byte value) {
		
		byte[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] add(short[] array, short value) {
		
		short[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] add(char[] array, char value) {
		
		char[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] add(int[] array, int value) {
		
		int[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] add(float[] array, float value) {
		
		float[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] add(double[] array, double value) {
		
		double[] newArray = ArrayUtils.append(array, 1);
		newArray[newArray.length - 1] = value;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] copy(boolean[] array) {
		
		boolean[] newArray = new boolean[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] copy(byte[] array) {
		
		byte[] newArray = new byte[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] copy(short[] array) {
		
		short[] newArray = new short[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] copy(char[] array) {
		
		char[] newArray = new char[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] copy(int[] array) {
		
		int[] newArray = new int[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] copy(long[] array) {
		
		long[] newArray = new long[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] copy(float[] array) {
		
		float[] newArray = new float[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] copy(double[] array) {
		
		double[] newArray = new double[array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] copy(Class<T> type, T[] array) {
		
		int length = array.length;
		T[] newArray = (T[])Array.newInstance(type, length);
		
		for(int index = 0; index < length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param object
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean isArray(Object object) {

		return object != null ? object.getClass().isArray() : false;
	}
	
	/**
	 * 
	 * @param type
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] merge(Class<T> type, T[]... arrays) {
		
		ArrayList<T> newArray = new ArrayList<>();
		
		for(T[] array : arrays) {
			
			for(T element : array) {
				
				newArray.add(element);
			}
		}
		
		return newArray.toArray((T[])Array.newInstance(type, newArray.size()));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final boolean[] merge(boolean[]... arrays) {
		
		ArrayList<Boolean> newArray = new ArrayList<>();
		
		for(boolean[] array : arrays) {
			
			for(boolean element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Boolean[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final char[] merge(char[]... arrays) {
		
		ArrayList<Character> newArray = new ArrayList<>();
		
		for(char[] array : arrays) {
			
			for(char element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Character[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final byte[] merge(byte[]... arrays) {
		
		ArrayList<Byte> newArray = new ArrayList<>();
		
		for(byte[] array : arrays) {
			
			for(byte element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Byte[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final short[] merge(short[]... arrays) {
		
		ArrayList<Short> newArray = new ArrayList<>();
		
		for(short[] array : arrays) {
			
			for(short element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Short[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final int[] merge(int[]... arrays) {
		
		ArrayList<Integer> newArray = new ArrayList<>();
		
		for(int[] array : arrays) {
			
			for(int element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Integer[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final long[] merge(long[]... arrays) {
		
		ArrayList<Long> newArray = new ArrayList<>();
		
		for(long[] array : arrays) {
			
			for(long element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Long[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final float[] merge(float[]... arrays) {
		
		ArrayList<Float> newArray = new ArrayList<>();
		
		for(float[] array : arrays) {
			
			for(float element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Float[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final double[] merge(double[]... arrays) {
		
		ArrayList<Double> newArray = new ArrayList<>();
		
		for(double[] array : arrays) {
			
			for(double element : array) {
				
				newArray.add(element);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Double[newArray.size()]));
	}
	
	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] flatten(Class<T> type, T[][] array) {
		
		ArrayList<T> newArray = new ArrayList<>();
		
		for(T[] d2 : array) {
			
			for(T d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return newArray.toArray((T[])Array.newInstance(type, newArray.size()));
	}
	
	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] flatten(Class<T> type, T[][][] array) {
		
		ArrayList<T> newArray = new ArrayList<>();
		
		for(T[][] d3 : array) {
			
			for(T[] d2 : d3) {
				
				for(T d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return newArray.toArray((T[])Array.newInstance(type, newArray.size()));
	}
	
	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] flatten(Class<T> type, T[][][][] array) {
		
		ArrayList<T> newArray = new ArrayList<>();
		
		for(T[][][] d4 : array) {
			
			for(T[][] d3 : d4) {
				
				for(T[] d2 : d3) {
					
					for(T d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return newArray.toArray((T[])Array.newInstance(type, newArray.size()));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final boolean[] flatten(boolean[][] array) {
		
		ArrayList<Boolean> newArray = new ArrayList<>();
		
		for(boolean[] d2 : array) {
			
			for(boolean d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Boolean[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final boolean[] flatten(boolean[][][] array) {
		
		ArrayList<Boolean> newArray = new ArrayList<>();
		
		for(boolean[][] d3 : array) {
			
			for(boolean[] d2 : d3) {
				
				for(boolean d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Boolean[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final boolean[] flatten(boolean[][][][] array) {
		
		ArrayList<Boolean> newArray = new ArrayList<>();
		
		for(boolean[][][] d4 : array) {
			
			for(boolean[][] d3 : d4) {
				
				for(boolean[] d2 : d3) {
					
					for(boolean d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Boolean[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final char[] flatten(char[][] array) {
		
		ArrayList<Character> newArray = new ArrayList<>();
		
		for(char[] d2 : array) {
			
			for(char d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Character[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final char[] flatten(char[][][] array) {
		
		ArrayList<Character> newArray = new ArrayList<>();
		
		for(char[][] d3 : array) {
			
			for(char[] d2 : d3) {
				
				for(char d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Character[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final char[] flatten(char[][][][] array) {
		
		ArrayList<Character> newArray = new ArrayList<>();
		
		for(char[][][] d4 : array) {
			
			for(char[][] d3 : d4) {
				
				for(char[] d2 : d3) {
					
					for(char d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Character[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final byte[] flatten(byte[][] array) {
		
		ArrayList<Byte> newArray = new ArrayList<>();
		
		for(byte[] d2 : array) {
			
			for(byte d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Byte[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final byte[] flatten(byte[][][] array) {
		
		ArrayList<Byte> newArray = new ArrayList<>();
		
		for(byte[][] d3 : array) {
			
			for(byte[] d2 : d3) {
				
				for(byte d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Byte[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final byte[] flatten(byte[][][][] array) {
		
		ArrayList<Byte> newArray = new ArrayList<>();
		
		for(byte[][][] d4 : array) {
			
			for(byte[][] d3 : d4) {
				
				for(byte[] d2 : d3) {
					
					for(byte d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Byte[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final short[] flatten(short[][] array) {
		
		ArrayList<Short> newArray = new ArrayList<>();
		
		for(short[] d2 : array) {
			
			for(short d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Short[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final short[] flatten(short[][][] array) {
		
		ArrayList<Short> newArray = new ArrayList<>();
		
		for(short[][] d3 : array) {
			
			for(short[] d2 : d3) {
				
				for(short d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Short[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final short[] flatten(short[][][][] array) {
		
		ArrayList<Short> newArray = new ArrayList<>();
		
		for(short[][][] d4 : array) {
			
			for(short[][] d3 : d4) {
				
				for(short[] d2 : d3) {
					
					for(short d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Short[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final int[] flatten(int[][] array) {
		
		ArrayList<Integer> newArray = new ArrayList<>();
		
		for(int[] d2 : array) {
			
			for(int d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Integer[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final int[] flatten(int[][][] array) {
		
		ArrayList<Integer> newArray = new ArrayList<>();
		
		for(int[][] d3 : array) {
			
			for(int[] d2 : d3) {
				
				for(int d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Integer[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final int[] flatten(int[][][][] array) {
		
		ArrayList<Integer> newArray = new ArrayList<>();
		
		for(int[][][] d4 : array) {
			
			for(int[][] d3 : d4) {
				
				for(int[] d2 : d3) {
					
					for(int d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Integer[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final long[] flatten(long[][] array) {
		
		ArrayList<Long> newArray = new ArrayList<>();
		
		for(long[] d2 : array) {
			
			for(long d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Long[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final long[] flatten(long[][][] array) {
		
		ArrayList<Long> newArray = new ArrayList<>();
		
		for(long[][] d3 : array) {
			
			for(long[] d2 : d3) {
				
				for(long d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Long[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final long[] flatten(long[][][][] array) {
		
		ArrayList<Long> newArray = new ArrayList<>();
		
		for(long[][][] d4 : array) {
			
			for(long[][] d3 : d4) {
				
				for(long[] d2 : d3) {
					
					for(long d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Long[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final float[] flatten(float[][] array) {
		
		ArrayList<Float> newArray = new ArrayList<>();
		
		for(float[] d2 : array) {
			
			for(float d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Float[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final float[] flatten(float[][][] array) {
		
		ArrayList<Float> newArray = new ArrayList<>();
		
		for(float[][] d3 : array) {
			
			for(float[] d2 : d3) {
				
				for(float d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Float[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final float[] flatten(float[][][][] array) {
		
		ArrayList<Float> newArray = new ArrayList<>();
		
		for(float[][][] d4 : array) {
			
			for(float[][] d3 : d4) {
				
				for(float[] d2 : d3) {
					
					for(float d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Float[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final double[] flatten(double[][] array) {
		
		ArrayList<Double> newArray = new ArrayList<>();
		
		for(double[] d2 : array) {
			
			for(double d1 : d2) {
				
				newArray.add(d1);
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Double[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final double[] flatten(double[][][] array) {
		
		ArrayList<Double> newArray = new ArrayList<>();
		
		for(double[][] d3 : array) {
			
			for(double[] d2 : d3) {
				
				for(double d1 : d2) {
					
					newArray.add(d1);
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Double[newArray.size()]));
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.2.0
	 */
	public static final double[] flatten(double[][][][] array) {
		
		ArrayList<Double> newArray = new ArrayList<>();
		
		for(double[][][] d4 : array) {
			
			for(double[][] d3 : d4) {
				
				for(double[] d2 : d3) {
					
					for(double d1 : d2) {
						
						newArray.add(d1);
					}
				}
			}
		}
		
		return ArrayUtils.toPrimitiveArray(newArray.toArray(new Double[newArray.size()]));
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[][] combine(T[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final boolean[][] combine(boolean[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final char[][] combine(char[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final byte[][] combine(byte[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final short[][] combine(short[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final int[][] combine(int[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final long[][] combine(long[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final float[][] combine(float[]... arrays) {
		
		return arrays;
	}
	
	/**
	 * 
	 * @param arrays
	 * @return
	 * @since 1.2.0
	 */
	public static final double[][] conmbine(double[]... arrays) {
		
		return arrays;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] append(byte[] array, int numberOfElements) {
		
		byte[] newArray = new byte[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] append(boolean[] array, int numberOfElements) {
		
		boolean[] newArray = new boolean[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] append(short[] array, int numberOfElements) {
		
		short[] newArray = new short[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] append(char[] array, int numberOfElements) {
		
		char[] newArray = new char[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] append(double[] array, int numberOfElements) {
		
		double[] newArray = new double[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] append(float[] array, int numberOfElements) {
		
		float[] newArray = new float[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] append(long[] array, int numberOfElements) {
		
		long[] newArray = new long[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] append(int[] array, int numberOfElements) {
		
		int[] newArray = new int[array.length + numberOfElements];
		
		for(int index = 0; index < array.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param numberOfElements
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] append(Class<T> type, T[] array, int numberOfElements) {
		
		int sourceArrayLength = array.length;
		T[] newArray = (T[])Array.newInstance(type, sourceArrayLength + numberOfElements);
		
		for(int index = 0; index < sourceArrayLength; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] getSubArray(Class<T> type, T[] array, int start, int end) {

		int sourceArraylength = array.length;
		int currentIndex = 0;
		T[] newArray = (T[])Array.newInstance(type, sourceArraylength - (end - start) - 1);
	
		for(int index = 0; index < sourceArraylength; index++) {
			
			if(index >= start && index <= end) {

				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] getSubArray(boolean[] array, int start, int end) {
		
		int currentIndex = 0;
		boolean[] newArray = new boolean[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] getSubArray(byte[] array, int start, int end) {
		
		int currentIndex = 0;
		byte[] newArray = new byte[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] getSubArray(short[] array, int start, int end) {
		
		int currentIndex = 0;
		short[] newArray = new short[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] getSubArray(char[] array, int start, int end) {
		
		int currentIndex = 0;
		char[] newArray = new char[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] getSubArray(int[] array, int start, int end) {
		
		int currentIndex = 0;
		int[] newArray = new int[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] getSubArray(long[] array, int start, int end) {
		
		int currentIndex = 0;
		long[] newArray = new long[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] getSubArray(float[] array, int start, int end) {
		
		int currentIndex = 0;
		float[] newArray = new float[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] getSubArray(double[] array, int start, int end) {
		
		int currentIndex = 0;
		double[] newArray = new double[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index >= start && index <= end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] delete(Class<T> type, T[] array, int start, int end) {

		int sourceArraylength = array.length;
		int currentIndex = 0;
		T[] newArray = (T[])Array.newInstance(type, sourceArraylength - (end - start) - 1);
	
		for(int index = 0; index < sourceArraylength; index++) {

			if(index < start || index > end) {

				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] delete(boolean[] array, int start, int end) {
		
		int currentIndex = 0;
		boolean[] newArray = new boolean[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] delete(byte[] array, int start, int end) {
		
		int currentIndex = 0;
		byte[] newArray = new byte[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] delete(short[] array, int start, int end) {
		
		int currentIndex = 0;
		short[] newArray = new short[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] delete(char[] array, int start, int end) {
		
		int currentIndex = 0;
		char[] newArray = new char[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] delete(int[] array, int start, int end) {
		
		int currentIndex = 0;
		int[] newArray = new int[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] delete(long[] array, int start, int end) {
		
		int currentIndex = 0;
		long[] newArray = new long[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] delete(float[] array, int start, int end) {
		
		int currentIndex = 0;
		float[] newArray = new float[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] delete(double[] array, int start, int end) {
		
		int currentIndex = 0;
		double[] newArray = new double[array.length - (end - start) - 1];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index < start || index > end) {
				
				newArray[currentIndex] = array[index];
				currentIndex++;
			}
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] insert(Class<T> type, T[] insertArray, T[] array, int offset) {
		
		int insertArrayLength = insertArray.length;
		int sourceArrayLength = array.length;
		int currentIndex = 0;
		T[] newArray = (T[])Array.newInstance(type, insertArrayLength + sourceArrayLength);
		
		for(int index = 0; index < sourceArrayLength; index++) {
			
			if(index == offset) {
				
				for(int index2 = 0; index2 < insertArrayLength; index2++) {

					newArray[currentIndex] = insertArray[index2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] insert(boolean[] insertArray, boolean[] array, int offset) {
		
		int currentIndex = 0;
		boolean[] newArray = new boolean[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] insert(byte[] insertArray, byte[] array, int offset) {
		
		int currentIndex = 0;
		byte[] newArray = new byte[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] insert(short[] insertArray, short[] array, int offset) {
		
		int currentIndex = 0;
		short[] newArray = new short[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] insert(char[] insertArray, char[] array, int offset) {
		
		int currentIndex = 0;
		char[] newArray = new char[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] insert(int[] insertArray, int[] array, int offset) {
		
		int currentIndex = 0;
		int[] newArray = new int[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] insert(long[] insertArray, long[] array, int offset) {
		
		int currentIndex = 0;
		long[] newArray = new long[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] insert(float[] insertArray, float[] array, int offset) {
		
		int currentIndex = 0;
		float[] newArray = new float[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param insertArray
	 * @param array
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] insert(double[] insertArray, double[] array, int offset) {
		
		int currentIndex = 0;
		double[] newArray = new double[insertArray.length + array.length];
		
		for(int index = 0; index < array.length; index++) {
			
			if(index == offset) {
				
				for(int i2 = 0; i2 < insertArray.length; i2++) {
					
					newArray[currentIndex] = insertArray[i2];
					currentIndex++;
				}
			}
			
			newArray[currentIndex] = insertArray[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public static final <T>T[] chop(Class<T> type, T[] array, int left, int right) {

		int sourceArrayLength = array.length;
		T[] newArray = (T[])Array.newInstance(type, sourceArrayLength - left - right);
		
		for(int index = left; index < sourceArrayLength - right; index++) {

			newArray[index - left] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] chop(boolean[] array, int left, int right) {
		
		boolean[] newArray = new boolean[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] chop(byte[] array, int left, int right) {
		
		byte[] newArray = new byte[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] chop(short[] array, int left, int right) {
		
		short[] newArray = new short[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] chop(char[] array, int left, int right) {
		
		char[] newArray = new char[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] chop(int[] array, int left, int right) {
		
		int[] newArray = new int[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] chop(long[] array, int left, int right) {
		
		long[] newArray = new long[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] chop(float[] array, int left, int right) {
		
		float[] newArray = new float[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] chop(double[] array, int left, int right) {
		
		double[] newArray = new double[array.length];
		
		for(int index = left; index < array.length - right; index++) {
			
			newArray[index - left] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] chopLeft(Class<T> type, T[] array, int left) {
		
		return ArrayUtils.chop(type, array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] chopLeft(boolean[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] chopLeft(byte[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] chopLeft(short[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] chopLeft(char[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] chopLeft(int[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] chopLeft(long[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] chopLeft(float[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param array
	 * @param left
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] chopLeft(double[] array, int left) {
		
		return ArrayUtils.chop(array, left, 0);
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] chopLeft(Class<T> type, T[] array) {
		
		return ArrayUtils.chop(type, array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] chopLeft(boolean[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] chopLeft(byte[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] chopLeft(short[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] chopLeft(char[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] chopLeft(int[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] chopLeft(long[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] chopLeft(float[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] chopLeft(double[] array) {
		
		return ArrayUtils.chop(array, 1, 0);
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] chopRight(Class<T> type, T[] array, int right) {
		
		return ArrayUtils.chop(type, array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] chopRight(boolean[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] chopRight(byte[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] chopRight(char[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] chopRight(short[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] chopRight(int[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] chopRight(long[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] chopRight(float[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param array
	 * @param right
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] chopRight(double[] array, int right) {
		
		return ArrayUtils.chop(array, 0, right);
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] chopRight(Class<T> type, T[] array) {
		
		return ArrayUtils.chop(type, array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] chopRight(boolean[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] chopRight(byte[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] chopRight(short[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] chopRight(char[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] chopRight(int[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] chopRight(long[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] chopRight(float[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] chopRight(double[] array) {
		
		return ArrayUtils.chop(array, 0, 1);
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>List<T> toList(T[] array) {
		
		List<T> list = new ArrayList<>();
		
		for(T element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Boolean> toList(boolean[] array) {
		
		List<Boolean> list = new ArrayList<>();
		
		for(boolean element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Byte> toList(byte[] array) {
		
		List<Byte> list = new ArrayList<>();
		
		for(byte element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Short> toList(short[] array) {
		
		List<Short> list = new ArrayList<>();
		
		for(short element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Character> toList(char[] array) {
		
		List<Character> list = new ArrayList<>();
		
		for(char element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Integer> toList(int[] array) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Long> toList(long[] array) {
		
		List<Long> list = new ArrayList<>();
		
		for(long element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Float> toList(float[] array) {
		
		List<Float> list = new ArrayList<>();
		
		for(float element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final List<Double> toList(double[] array) {
		
		List<Double> list = new ArrayList<>();
		
		for(double element : array) {
			
			list.add(element);
		}
		
		return list;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Boolean[] toWrapperArray(boolean[] array) {
		
		Boolean[] resultArray = new Boolean[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Double[] toWrapperArray(double[] array) {
		
		Double[] resultArray = new Double[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Float[] toWrapperArray(float[] array) {
		
		Float[] resultArray = new Float[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Long[] toWrapperArray(long[] array) {
		
		Long[] resultArray = new Long[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Short[] toWrapperArray(short[] array) {
		
		Short[] resultArray = new Short[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Byte[] toWrapperArray(byte[] array) {
		
		Byte[] resultArray = new Byte[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Integer[] toWrapperArray(int[] array) {
		
		Integer[] resultArray = new Integer[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final Character[] toWrapperArray(char[] array) {
		
		Character[] newArray = new Character[array.length];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] toPrimitiveArray(Boolean[] array) {

		boolean[] resultArray = new boolean[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] toPrimitiveArray(Double[] array) {

		double[] resultArray = new double[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] toPrimitiveArray(Float[] array) {

		float[] resultArray = new float[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] toPrimitiveArray(Long[] array) {

		long[] resultArray = new long[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] toPrimitiveArray(Short[] array) {

		short[] resultArray = new short[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] toPrimitiveArray(Byte[] array) {

		byte[] resultArray = new byte[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] toPrimitiveArray(Integer[] array) {

		int[] resultArray = new int[array.length];
		
		for(int index = 0; index < resultArray.length; index++) {
			
			resultArray[index] = array[index];
		}
		
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] toPrimitiveArray(Character[] array) {
		
		char[] newArray = new char[array.length];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] reverse(boolean[] array) {
		
		boolean[] newArray = new boolean[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] reverse(byte[] array) {
		
		byte[] newArray = new byte[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] reverse(short[] array) {
		
		short[] newArray = new short[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] reverse(char[] array) {
		
		char[] newArray = new char[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] reverse(int[] array) {
		
		int[] newArray = new int[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] reverse(long[] array) {
		
		long[] newArray = new long[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] reverse(float[] array) {
		
		float[] newArray = new float[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] reverse(double[] array) {
		
		double[] newArray = new double[array.length];
		int currentIndex = 0;
		
		for(int index = array.length - 1; index >= 0; index--) {
			
			newArray[currentIndex] = array[index]; 
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] reverse(Class<T> type, T[] array) {
		
		int sourceArrayLength = array.length;
		int currentIndex = 0;
		
		@SuppressWarnings("unchecked")
		T[] newArray = (T[])Array.newInstance(type, sourceArrayLength);
		
		for(int index = sourceArrayLength - 1; index >= 0; index--) {

			newArray[currentIndex] = array[index];
			currentIndex++;
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final <T extends Comparable<T>>void sort(T[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index].compareTo(array[index + 1]) > 0) {
					
					T buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(boolean[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] && !array[index + 1]) {
					
					boolean buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(byte[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					byte buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(short[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					short buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(char[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					char buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(int[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					int buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(long[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					long buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(float[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					float buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public static final void sort(double[] array) {
		
		int n = array.length;
		
		do {
			
			int newN = 1;
			
			for(int index = 0; index < n - 1; index++) {
				
				if(array[index] > array[index + 1]) {
					
					double buffer = array[index];
					array[index] = array[index + 1];
					array[index + 1] = buffer;
					newN++;
				}
			}
			
			n = newN;
			
		} while(n > 1);
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final <T>void swap(T[] array, int i1, int i2) {
		
		T buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(boolean[] array, int i1, int i2) {
		
		boolean buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(byte[] array, int i1, int i2) {
		
		byte buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(short[] array, int i1, int i2) {

		short buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	public static final void swap(char[] array, int i1, int i2) {

		char buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(int[] array, int i1, int i2) {
		
		int buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(long[] array, int i1, int i2) {

		long buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(float[] array, int i1, int i2) {

		float buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param array
	 * @param i1
	 * @param i2
	 * @since 1.0.0
	 */
	public static final void swap(double[] array, int i1, int i2) {

		double buffer = array[i1];
		array[i1] = array[i2];
		array[i2] = buffer;
	}

	/**
	 * 
	 * @param type
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>T[] truncate(Class<T> type, T[] array, int maxLength) {
		
		@SuppressWarnings("unchecked")
		T[] newArray = (T[])Array.newInstance(type, maxLength >= array.length ? array.length : maxLength);
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean[] truncate(boolean[] array, int maxLength) {
		
		boolean[] newArray = new boolean[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final byte[] truncate(byte[] array, int maxLength) {
		
		byte[] newArray = new byte[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final short[] truncate(short[] array, int maxLength) {
		
		short[] newArray = new short[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}
	
	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final char[] truncate(char[] array, int maxLength) {
		
		char[] newArray = new char[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] truncate(int[] array, int maxLength) {
		
		int[] newArray = new int[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final long[] truncate(long[] array, int maxLength) {
		
		long[] newArray = new long[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final float[] truncate(float[] array, int maxLength) {
		
		float[] newArray = new float[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final double[] truncate(double[] array, int maxLength) {
		
		double[] newArray = new double[maxLength >= array.length ? array.length : maxLength];
		
		for(int index = 0; index < newArray.length; index++) {
			
			newArray[index] = array[index];
		}
		
		return newArray;
	}
}
