package de.ralleytn.utils;

import java.text.Normalizer;
import java.util.ArrayList;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class StringUtils {

	private StringUtils() {}

	/**
	 * 
	 * @param string
	 * @param min
	 * @param max
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean hasALengthBetween(String string, int min, int max) {
		
		return string.length() >= min && string.length() <= max;
	}

	/**
	 * 
	 * @param string
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean isLowerCase(String string) {
		
		return string.equals(string.toLowerCase());
	}

	/**
	 * 
	 * @param string
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean isUpperCase(String string) {
		
		return string.equals(string.toUpperCase());
	}

	/**
	 * 
	 * @param string
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean isParsableNumber(String string) {
		
		if(string != null) {
			
			try {
				
				Double.parseDouble(string);
				return true;
				
			} catch(NumberFormatException exception) {}
		}
		
		return false;
	}

	/**
	 * 
	 * @param string
	 * @param sequence
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean endsWithIgnoreCase(String string, String sequence) {
		
		return string.toUpperCase().endsWith(sequence.toUpperCase());
	}

	/**
	 * 
	 * @param string
	 * @param sequence
	 * @return
	 * @since 1.0.0
	 */
	public static final boolean startsWithIgnoreCase(String string, String sequence) {
		
		return string.toUpperCase().startsWith(sequence.toUpperCase());
	}

	/**
	 * 
	 * @param string
	 * @return
	 * @since 1.0.0
	 */
	public static final String reverse(String string) {
		
		return new StringBuffer(string).reverse().toString();
	}

	/**
	 * 
	 * @param character
	 * @return
	 * @since 1.0.0
	 */
	public static final String getEscapedCharacter(char character) {
		
		return "\\u" + Integer.toHexString(character | 0x10000).substring(1);
	}

	/**
	 * 
	 * @param text
	 * @param character
	 * @return
	 * @since 1.0.0
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
	 * 
	 * @param text
	 * @param term
	 * @return
	 * @since 1.0.0
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
	 * 
	 * @param text
	 * @param term
	 * @return
	 * @since 1.0.0
	 */
	public static final int[] search(String text, String term) {
		
		return StringUtils.search(term, text, false);
	}

	/**
	 * 
	 * @param text
	 * @param term
	 * @param ignoreCase
	 * @return
	 * @since 1.0.0
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
	 * 
	 * @param string
	 * @param maxLength
	 * @return
	 * @since 1.0.0
	 */
	public static final String truncate(String string, int maxLength) {
		
		return string.substring(0, maxLength > string.length() ? string.length() : maxLength);
	}

	/**
	 * 
	 * @param string
	 * @param maxLength
	 * @param offset
	 * @return
	 * @since 1.0.0
	 */
	public static final String tuncate(String string, int maxLength, int offset) {
		
		return StringUtils.truncate(string.substring(offset), maxLength);
	}

	/**
	 * 
	 * @param input
	 * @return
	 * @since 1.0.0
	 */
    public static String removeAccents(String input) {

        StringBuilder decomposed = new StringBuilder(Normalizer.normalize(input, Normalizer.Form.NFD));

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
     * 
     * @param string
     * @return
     * @since 1.0.0
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
     * 
     * @param string
     * @return
     * @since 1.0.0
     */
	public static final boolean isBlank(String string) {
		
		return StringUtils.fullTrim(string).isEmpty();
	}

	/**
	 * 
	 * @param string
	 * @param characters
	 * @return
	 * @since 1.0.0
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
