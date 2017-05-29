package de.ralleytn.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides helpful methods regarding the Reflection API.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.1.2
 * @since 1.1.2
 */
public final class ReflectionUtils {

	private ReflectionUtils() {}
	
	/**
	 * @param packageName name of the package
	 * @return a list with all {@linkplain Class} instances in the given package
	 * @throws IOException if an I/O error occurs
	 * @throws ClassNotFoundException if a class cannot be located (should never happen)
	 * @since 1.1.2
	 */
	public static final List<Class<?>> getPackage(String packageName) throws IOException, ClassNotFoundException {
		
		ClassLoader cl = ReflectionUtils.class.getClassLoader();
		List<Class<?>> classes = new ArrayList<>();
		URL pkg = cl.getResource(packageName.replace('.', '/'));
		DataInputStream dis = new DataInputStream((InputStream)pkg.getContent());
		String line = null;
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(dis))) {
			
			while((line = reader.readLine()) != null) {
				
				if(line.toUpperCase().endsWith(".CLASS")) {
					
					Class<?> clazz = Class.forName(packageName + "." + line.substring(0, line.indexOf('.')));
					classes.add(clazz);
				}
			}
		}
		
		return classes;
	}
}
