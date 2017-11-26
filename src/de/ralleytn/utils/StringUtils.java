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

import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Provides some helpful methods regarding strings.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 */
public final class StringUtils {

	private StringUtils() {}

	/**
	 * @param string the {@linkplain String} to process
	 * @param min minimum length
	 * @param max maximum length
	 * @return {@code true} if the length is bigger or equal than the given minimum length and smaller or equal the given maximum length, else {@code false}
	 */
	public static final boolean hasALengthBetween(String string, int min, int max) {
		
		return string.length() >= min && string.length() <= max;
	}

	/**
	 * @param string the {@linkplain String} to process
	 * @return {@code true} if the given string is already in lower case, else {@code false}
	 */
	public static final boolean isLowerCase(String string) {
		
		return string.equals(string.toLowerCase());
	}

	/**
	 * @param string the {@linkplain String} to process
	 * @return {@code true} if the given string is already in upper case, else {@code false}
	 */
	public static final boolean isUpperCase(String string) {
		
		return string.equals(string.toUpperCase());
	}

	/**
	 * @param string the {@linkplain String} to process
	 * @return {@code true} if the given string can be parsed as a floating point number, else {@code false}
	 */
	public static final boolean isParsableNumber(String string) {
		
		return StringUtils.isParsableNumber(string, true);
	}
	
	/**
	 * @param string string the {@linkplain String} to process
	 * @param floatingPoint set this to {@code true} if you want to include floating point numbers
	 * @return {@code true} if the given string can be parsed as a number, else {@code false}
	 */
	public static final boolean isParsableNumber(String string, boolean floatingPoint) {
		
		if(string != null) {
			
			try {
				
				if(floatingPoint) {
					
					Double.parseDouble(string);
				
				} else {
					
					Long.parseLong(string);
				}
				
				return true;
				
			} catch(NumberFormatException exception) {}
		}
		
		return false;
	}

	/**
	 * Does the same as {@link String#endsWith(String)} but it ignores the case.
	 * @param string the {@linkplain String} to process
	 * @param suffix the suffix
	 * @return {@code true} if the given string ends with {@code prefix} (case doesn't matter), else {@code false}
	 */
	public static final boolean endsWithIgnoreCase(String string, String suffix) {
		
		return string.toUpperCase().endsWith(suffix.toUpperCase());
	}

	/**
	 * Does the same as {@link String#startsWith(String)} but it ignores the case.
	 * @param string the {@linkplain String} to process
	 * @param prefix the prefix
	 * @return {@code true} if the given string starts with {@code prefix} (case doesn't matter), else {@code false}
	 */
	public static final boolean startsWithIgnoreCase(String string, String prefix) {
		
		return string.toUpperCase().startsWith(prefix.toUpperCase());
	}

	/**
	 * Reverses a string.
	 * @param string the {@linkplain String} to process
	 * @return the reversed version of the given string
	 */
	public static final String reverse(String string) {
		
		return new StringBuffer(string).reverse().toString();
	}

	/**
	 * @param character the character you want to escape
	 * @return the escaped character
	 */
	public static final String getEscapedCharacter(char character) {
		
		return "\\u" + Integer.toHexString(character | 0x10000).substring(1);
	}

	/**
	 * @param text the text to search in
	 * @param character the character you search for
	 * @return the number of occurences of the given character in the given text
	 */
	public static final int getNumberOfOccurrences(String text, char character) {
		
		int occurences = 0;
		int lastIndex = 0;
		
		while(lastIndex != -1) {
			
			lastIndex = text.indexOf(character, lastIndex);
			if(lastIndex != -1) occurences++;
		}
		
		return occurences;
	}

	/**
	 * @param text the text to search in
	 * @param term the term you search for
	 * @return the number of occurences of the given term in the given text
	 */
	public static final int getNumberOfOccurrences(String text, String term) {
		
		int occurences = 0;
		int lastIndex = 0;
		
		while(lastIndex != -1) {
			
			lastIndex = text.indexOf(term, lastIndex);
			if(lastIndex != -1) occurences++;
		}
		
		return occurences;
	}

	/**
	 * Searches for a term in a text and returns the positions at which the term was found.
	 * If the term wasn't found, an array with the length {@code 0} is returned.
	 * @param text text in which the term should be searched for
	 * @param term the term that is searched for
	 * @return an array with all indexes at which the term was found
	 */
	public static final int[] search(String text, String term) {
		
		return StringUtils.search(term, text, false);
	}

	/**
	 * Searches for a term in a text and returns the positions at which the term was found.
	 * If the term wasn't found, an array with the length {@code 0} is returned.
	 * @param text text in which the term should be searched for
	 * @param term the term that is searched for
	 * @param ignoreCase set this to true if lower and upper case don't matter
	 * @return an array with all indexes at which the term was found
	 */
	public static final int[] search(String text, String term, boolean ignoreCase) {
		
		String termBuffer = ignoreCase ? term.toUpperCase() : term;
		String textBuffer = ignoreCase ? text.toUpperCase() : text;
		ArrayList<Integer> result = new ArrayList<>();
		int lastIndex = 0;
		
		while(lastIndex != -1) {
			
			lastIndex = textBuffer.indexOf(termBuffer, lastIndex);
			
			if(lastIndex != -1) {
				
				result.add(lastIndex);
				lastIndex += term.length();
			}
		}
		
		return ArrayUtils.toPrimitiveArray(result.toArray(new Integer[result.size()]));
	}

	/**
	 * Truncates a string.
	 * @param string the {@linkplain String} to process
	 * @param maxLength maximum length of the string
	 * @return a string with a maximum of {@code maxLength} characters
	 */
	public static final String truncate(String string, int maxLength) {
		
		return string.substring(0, maxLength > string.length() ? string.length() : maxLength);
	}

	/**
	 * Truncates a string.
	 * @param string the {@linkplain String} to process
	 * @param maxLength maxmimum length of the string
	 * @param offset offset
	 * @return a string beginning at {@code offset} with a maximum length of {@code maxLength} characters
	 */
	public static final String tuncate(String string, int maxLength, int offset) {
		
		return StringUtils.truncate(string.substring(offset), maxLength);
	}

	/**
	 * Removes all accents from a string and replaces them with their latin counterpart.
	 * For example {@code "Äpfél"} is turned into {@code "Apfel"}.
	 * @param string the {@linkplain String} to process
	 * @return a string with only latin letters
	 */
    public static String removeAccents(String string) {

        StringBuilder decomposed = new StringBuilder(Normalizer.normalize(string, Normalizer.Form.NFD));

        for(int index = 0; index < decomposed.length(); index++) {
        	
            if(decomposed.charAt(index) == '\u0141') {
            	
                decomposed.deleteCharAt(index);
                decomposed.insert(index, 'L');
                
            } else if(decomposed.charAt(index) == '\u0142') {
            	
                decomposed.deleteCharAt(index);
                decomposed.insert(index, 'l');
            }
        }
        
        return decomposed.toString().replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    /**
     * Trims out all blank spaces at both ends of the string, removes all {@code NULL} characters, tabulaters, line breaks etc. and all double white spaces.
     * @param string the {@linkplain String} to process
     * @return a fully trimmed string
     */
    public static final String fullTrim(String string) {
		
		StringBuilder result = new StringBuilder();
		
		if(string != null) {
			
			string = string.replace("\0", "").replace("\t", " ").replace("\b", "").replace("\f", "").replace("\r", "").replace("\n", " ").trim();
			char lastCharacter = 0;
			
			for(char character : string.toCharArray()) {
				
				if(!(character == ' ' && lastCharacter == ' ')) {
					
					result.append(character);
				}
				
				lastCharacter = character;
			}
		}
		
		return result.toString();
	}

    /**
     * @param string the {@linkplain String} to process
     * @return {@code true} if the given string doesn't just contain empty spaces or tabs, else {@code false}
     */
	public static final boolean isBlank(String string) {
		
		return StringUtils.fullTrim(string).isEmpty();
	}

	/**
	 * @param string the {@linkplain String} to process
	 * @param characters array of characters
	 * @return {@code true} if the given string is only made of the given characters, else {@code false}
	 */
	public static final boolean containsOnly(String string, char... characters) {
		
		if(characters != null) {
			
			boolean valid = true;
			char[] sCharacters = string.toCharArray();
			
			for(char character : sCharacters) {
				
				boolean found = false;
				
				for(char validCharacter : characters) {
					
					if(validCharacter == character) {
						
						found = true;
						break;
					}
				}
				
				if(!found) {
					
					valid = false;
					break;
				}
			}
			
			return valid;
		}
		
		return false;
	}
}
