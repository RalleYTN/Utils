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
import java.util.List;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 2017-07-26
 * @since 2017-07-26
 */
public final class ListUtils {

	private ListUtils() {}
	
	/**
	 * 
	 * @param list
	 * @param elements
	 * @since 2017-07-26
	 */
	public static final <T>void addAll(List<T> list, T[] elements) {
		
		for(T element : elements) {
			
			list.add(element);
		}
	}
	
	/**
	 * 
	 * @param list
	 * @param type
	 * @return
	 * @since 2017-07-26
	 */
	public static final <T>T[] toArray(List<T> list, Class<T> type) {
		
		@SuppressWarnings("unchecked")
		T[] array = (T[])Array.newInstance(type, list.size());
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final double[] toPrimitiveDoubleArray(List<Double> list) {
		
		double[] array = new double[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final float[] toPrimitiveFloatArray(List<Float> list) {
		
		float[] array = new float[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final long[] toPrimitiveLongArray(List<Long> list) {
		
		long[] array = new long[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final int[] toPrimitiveIntArray(List<Integer> list) {
		
		int[] array = new int[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final short[] toPrimitiveShortArray(List<Short> list) {
		
		short[] array = new short[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final byte[] toPrimitiveByteArray(List<Byte> list) {
		
		byte[] array = new byte[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final char[] toPrimitiveCharArray(List<Character> list) {
		
		char[] array = new char[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @since 2017-07-26
	 */
	public static final boolean[] toPrimitiveBooleanArray(List<Boolean> list) {
		
		boolean[] array = new boolean[list.size()];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = list.get(index);
		}
		
		return array;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @since 2017-07-26
	 */
	public static final <T>List<T> clone(List<T> list) throws InstantiationException, IllegalAccessException {
		
		@SuppressWarnings("unchecked")
		List<T> clonedList = list.getClass().newInstance();
		
		for(T element : list) {
			
			clonedList.add(element);
		}
		
		return clonedList;
	}
}
