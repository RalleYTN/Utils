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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides some helpful methods regarding the world wide web.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 */
public final class NetUtils {

	private NetUtils() {}
	
	/**
	 * Extracts all query parameters from an URL.
	 * @param url the URL you want to extract the query parameters from
	 * @return A map with all the query parameters of the given URL
	 * @throws UnsupportedEncodingException if UTF-8 is not supported... that should really not happen
	 */
	public static final Map<String, ?> getQueryParams(URL url) throws UnsupportedEncodingException {

		String externalForm = URLDecoder.decode(url.toExternalForm(), "UTF-8");
		int queryStartIndex = externalForm.indexOf('?');
		       
		if(queryStartIndex > -1) {
			   
			String query = externalForm.substring(queryStartIndex + 1);
			String[] params = query.contains("&") ? query.split("&") : new String[] {query};
			Map<String, Object> returnValue = new HashMap<>();
			   
			for(String param : params) {
			 
				int indexOfSeperator = param.indexOf('=');
				String key = null;
				Object value = null;
			 
				if(indexOfSeperator > -1) {
			 	
					key = param.substring(0, indexOfSeperator);
					value = param.substring(indexOfSeperator + 1);
			 	
					if(value.toString().contains(",")) {
			 		
						String[] elements = value.toString().split(",");
						ArrayList<String> valueAsArray = new ArrayList<>();
							
						for(String element : elements) {
			 			
							valueAsArray.add(element);
						}
			 		
						value = valueAsArray;
					}
			 	
				} else {
			 	
					key = param;
				}
			 
				returnValue.put(key, value);
			}  
			   
			return returnValue;
		}      
		
		return null;
	}
	
	/**
	 * Extracts all query parameters from an URL.
	 * @param url the URL you want to extract the query parameters from
	 * @return A map with all the query parameters of the given URL
	 * @throws MalformedURLException if no protocol is specified, or an unknown protocol is found, or spec is {@code null}.
	 * @throws UnsupportedEncodingException if UTF-8 is not supported... that should really not happen
	 */
	public static final Map<String, ?> getQueryParams(String url) throws MalformedURLException, UnsupportedEncodingException {
		
		return NetUtils.getQueryParams(new URL(url));
	}
	
	/**
	 * Builds a query string from a map.
	 * @param map the map from which the query string should be built
	 * @return the resulting query string
	 * @throws UnsupportedEncodingException if UTF-8 is not supported... that should really not happen
	 */
	public static final String getQueryString(Map<String, ?> map) throws UnsupportedEncodingException {

		StringBuilder result = new StringBuilder().append('?');
		boolean first = true;
			
		for(Map.Entry<String, ?> entry : map.entrySet()) {
				
			if(first) first = false; else result.append('&');
			result.append(URLEncoder.encode(entry.getKey().toString(), "UTF-8")).append('=');
			boolean firstElement = true;
				
			if(entry.getValue() instanceof List) {
					
				for(Object element : (List<?>)entry.getValue()) {
						
					if(firstElement) firstElement = false; else result.append(',');
					result.append(URLEncoder.encode(element.toString(), "UTF-8"));
				}
					
			} else if(ArrayUtils.isArray(entry.getValue())) {
					
				for(int index = 0; index < Array.getLength(entry.getValue()); index++) {
						
					if(firstElement) firstElement = false; else result.append(',');
					result.append(URLEncoder.encode(Array.get(entry.getValue(), index).toString(), "UTF-8"));
				}
					
			} else {

				result.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
			}
		}
			
		return result.toString();
	}
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @param timeout
	 * @return
	 * @throws IOException
	 */
	public static final boolean isHostAvailable(String host, int port, int timeout) throws IOException {

		try(Socket socket = new Socket()) {
			
			socket.connect(new InetSocketAddress(host, port), timeout * 1000);
			return socket.isConnected();
		}
	}
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @return
	 * @throws IOException
	 */
	public static final boolean isHostAvailable(String host, int port) throws IOException {
		
		return NetUtils.isHostAvailable(host, port, 5);
	}
	
	/**
	 * 
	 * @param shortURL
	 * @return
	 * @throws IOException
	 */
	public static final URL getLongURL(String shortURL) throws IOException {
		
		return NetUtils.getLongURL(new URL(shortURL));
	}
	
	/**
	 * 
	 * @param shortURL
	 * @return
	 * @throws IOException
	 */
	public static final URL getLongURL(URL shortURL) throws IOException {
		
		HttpURLConnection connection = (HttpURLConnection)shortURL.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setUseCaches(false);
		connection.setAllowUserInteraction(false);
		connection.setDoOutput(false);
		connection.connect();
		
		int status = connection.getResponseCode();
		
		if(status >= 300 && status < 400) {
			
			String location = connection.getHeaderField("Location");
			
			if(location != null) {

				return new URL(connection.getHeaderField("Location"));
			}
		}
		
		return shortURL;
	}
}
