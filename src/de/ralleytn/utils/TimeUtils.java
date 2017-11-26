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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Provides utility methods for the Java Date API (pre Java 8).
 * @author Ralph Niemitz(ralph.niemitz@gmx.de)
 */
public final class TimeUtils {

	public static final int MONTH_JANUARY = 1;
	public static final int MONTH_FEBRUARY = 2;
	public static final int MONTH_MARCH = 3;
	public static final int MONTH_APRIL = 4;
	public static final int MONTH_MAY = 5;
	public static final int MONTH_JUNE = 6;
	public static final int MONTH_JULY = 7;
	public static final int MONTH_AUGUST = 8;
	public static final int MONTH_SEPTEMBER = 9;
	public static final int MONTH_OCTOBER = 10;
	public static final int MONTH_NOVEMBER = 11;
	public static final int MONTH_DECEMBER = 12;
	
	public static final long DAY_IN_MILLISECONDS = (long)8.64e+7;
	public static final long HOUR_IN_MILLISECONDS = (long)3.6e+6;
	public static final long MINUTE_IN_MILLISECONDS = 60000L;
	public static final long SECOND_IN_MILLISECONDS = 1000L;

	public static final DateFormat FORMAT_ISO_DATE = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat FORMAT_ISO_TIME = new SimpleDateFormat("HH:mm:ss");
	public static final DateFormat FORMAT_ISO_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private TimeUtils() {}
	
	/**
	 * @return the {@linkplain Date} instance for tomorrow (time stays the same)
	 */
	public static final Date tomorrow() {
		
		return new Date(System.currentTimeMillis() + TimeUtils.DAY_IN_MILLISECONDS);
	}
	
	/**
	 * @return the {@linkplain Date} instance for the current moment
	 */
	public static final Date now() {
		
		return new Date();
	}
	
	/**
	 * @return the {@linkplain Date} instance for today (time is 00:00:00)
	 * @throws ParseException
	 */
	public static final Date today() throws ParseException {
		
		return TimeUtils.FORMAT_ISO_DATE.parse(TimeUtils.FORMAT_ISO_DATE.format(new Date()));
	}
	
	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static final Date substractDays(Date date, int days) {
		
		return new Date(date.getTime() - (days * TimeUtils.DAY_IN_MILLISECONDS));
	}
	
	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static final Date addDays(Date date, int days) {
		
		return new Date(date.getTime() + (days * TimeUtils.DAY_IN_MILLISECONDS));
	}
	
	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 * @throws ParseException
	 */
	public static final Date getDateTime(int day, int month, int year, int hour, int minute, int second) throws ParseException {
		
		String yearAsString = Integer.toString(year);
		String dayAsString = Integer.toString(day);
		String monthAsString = Integer.toString(month);
		String hourAsString = Integer.toString(hour);
		String minuteAsString = Integer.toString(minute);
		String secondAsString = Integer.toString(second);
		
		StringBuilder builder = new StringBuilder();
		builder.append(yearAsString);
		
		for(int index = 0; index < (4 - yearAsString.length()); index++) {
			
			builder.insert(0, '0');
		}
		
		builder.append('-');
		builder.append(monthAsString);
		
		for(int index = 0; index < (2 - monthAsString.length()); index++) {
			
			builder.insert(5, '0');
		}
		
		builder.append('-');
		builder.append(dayAsString);
		
		for(int index = 0; index < (2 - dayAsString.length()); index++) {
			
			builder.insert(8, '0');
		}
		
		builder.append(' ');
		builder.append(hourAsString);
		
		for(int index = 0; index < (2 - hourAsString.length()); index++) {
			
			builder.insert(11, '0');
		}
		
		builder.append(':');
		builder.append(minuteAsString);
		
		for(int index = 0; index < (2 - minuteAsString.length()); index++) {
			
			builder.insert(14, '0');
		}
		
		builder.append(':');
		builder.append(secondAsString);
		
		for(int index = 0; index < (2 - secondAsString.length()); index++) {
			
			builder.insert(17, '0');
		}
		
		return TimeUtils.FORMAT_ISO_DATE_TIME.parse(builder.toString());
	}
	
	/**
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 * @throws ParseException
	 */
	public static final Date getTime(int hour, int minute, int second) throws ParseException {
		
		String hourAsString = Integer.toString(hour);
		String minuteAsString = Integer.toString(minute);
		String secondAsString = Integer.toString(second);
		
		StringBuilder builder = new StringBuilder();
		builder.append(hourAsString);
		
		for(int index = 0; index < (2 - hourAsString.length()); index++) {
			
			builder.insert(0, '0');
		}
		
		builder.append(':');
		builder.append(minuteAsString);
		
		for(int index = 0; index < (2 - minuteAsString.length()); index++) {
			
			builder.insert(3, '0');
		}
		
		builder.append(':');
		builder.append(secondAsString);
		
		for(int index = 0; index < (2 - secondAsString.length()); index++) {
			
			builder.insert(6, '0');
		}
		
		builder.insert(0, ' ');
		builder.insert(0, TimeUtils.FORMAT_ISO_DATE.format(TimeUtils.now()));

		return TimeUtils.FORMAT_ISO_DATE_TIME.parse(builder.toString());
	}
	
	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 * @throws ParseException
	 */
	public static final Date getDate(int day, int month, int year) throws ParseException {
		
		String yearAsString = Integer.toString(year);
		String dayAsString = Integer.toString(day);
		String monthAsString = Integer.toString(month);
		
		StringBuilder builder = new StringBuilder();
		builder.append(yearAsString);
		
		for(int index = 0; index < (4 - yearAsString.length()); index++) {
			
			builder.insert(0, '0');
		}
		
		builder.append('-');
		builder.append(monthAsString);
		
		for(int index = 0; index < (2 - monthAsString.length()); index++) {
			
			builder.insert(5, '0');
		}
		
		builder.append('-');
		builder.append(dayAsString);
		
		for(int index = 0; index < (2 - dayAsString.length()); index++) {
			
			builder.insert(8, '0');
		}

		return TimeUtils.FORMAT_ISO_DATE.parse(builder.toString());
	}
}
