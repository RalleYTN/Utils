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
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class NetUtils {

	private NetUtils() {}
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 * @since 1.0.0
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
	 * 
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws UnsupportedEncodingException
	 * @since 1.0.0
	 */
	public static final Map<String, ?> getQueryParams(String url) throws MalformedURLException, UnsupportedEncodingException {
		
		return NetUtils.getQueryParams(new URL(url));
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 * @since 1.0.0
	 */
	public static final String getQueryString(Map<String, ?> map) throws ArrayIndexOutOfBoundsException, UnsupportedEncodingException, IllegalArgumentException {

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
	 * @since 1.0.0
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
	 * @since 1.0.0
	 */
	public static final boolean isHostAvailable(String host, int port) throws IOException {
		
		return NetUtils.isHostAvailable(host, port, 5);
	}
	
	/**
	 * 
	 * @param shortURL
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final URL getLongURL(String shortURL) throws IOException {
		
		return NetUtils.getLongURL(new URL(shortURL));
	}
	
	/**
	 * 
	 * @param shortURL
	 * @return
	 * @throws IOException
	 * @since 1.0.0
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
