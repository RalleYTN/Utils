package de.ralleytn.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Ralph Niemitz(ralph.niemitz@gmx.de)
 * @version 17.06.2017
 * @since 17.06.2017
 */
public final class Java7TimeUtils {

	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_JANUARY = 1;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_FEBRUARY = 2;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_MARCH = 3;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_APRIL = 4;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_MAY = 5;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_JUNE = 6;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_JULY = 7;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_AUGUST = 8;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_SEPTEMBER = 9;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_OCTOBER = 10;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_NOVEMBER = 11;
	
	/**
	 * @since 17.06.2017
	 */
	public static final int MONTH_DECEMBER = 12;
	
	/**
	 * @since 17.06.2017
	 */
	public static final long DAY_IN_MILLISECONDS = (long)8.64e+7;
	
	/**
	 * @since 17.06.2017
	 */
	public static final long HOUR_IN_MILLISECONDS = (long)3.6e+6;
	
	/**
	 * @since 17.06.2017
	 */
	public static final long MINUTE_IN_MILLISECONDS = 60000L;
	
	/**
	 * @since 17.06.2017
	 */
	public static final long SECOND_IN_MILLISECONDS = 1000L;
	
	/**
	 * @since 17.06.2017
	 */
	public static final DateFormat FORMAT_ISO_DATE = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * @since 17.06.2017
	 */
	public static final DateFormat FORMAT_ISO_TIME = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * @since 17.06.2017
	 */
	public static final DateFormat FORMAT_ISO_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private Java7TimeUtils() {}
	
	/**
	 * 
	 * @return
	 * @since 17.06.2017
	 */
	public static final Date tomorrow() {
		
		return new Date(System.currentTimeMillis() + Java7TimeUtils.DAY_IN_MILLISECONDS);
	}
	
	/**
	 * 
	 * @return
	 * @since 17.06.2017
	 */
	public static final Date now() {
		
		return new Date();
	}
	
	/**
	 * 
	 * @return
	 * @throws ParseException
	 * @since 17.06.2017
	 */
	public static final Date today() throws ParseException {
		
		return Java7TimeUtils.FORMAT_ISO_DATE.parse(Java7TimeUtils.FORMAT_ISO_DATE.format(new Date()));
	}
	
	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @since 17.06.2017
	 */
	public static final Date substractDays(Date date, int days) {
		
		return new Date(date.getTime() - (days * Java7TimeUtils.DAY_IN_MILLISECONDS));
	}
	
	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @since 17.06.2017
	 */
	public static final Date addDays(Date date, int days) {
		
		return new Date(date.getTime() + (days * Java7TimeUtils.DAY_IN_MILLISECONDS));
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
	 * @since 17.06.2017
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
		
		return Java7TimeUtils.FORMAT_ISO_DATE_TIME.parse(builder.toString());
	}
	
	/**
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 * @throws ParseException
	 * @since 17.06.2017
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
		builder.insert(0, Java7TimeUtils.FORMAT_ISO_DATE.format(Java7TimeUtils.now()));

		return Java7TimeUtils.FORMAT_ISO_DATE_TIME.parse(builder.toString());
	}
	
	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 * @throws ParseException
	 * @since 17.06.2017
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

		return Java7TimeUtils.FORMAT_ISO_DATE.parse(builder.toString());
	}
}
