package de.ralleytn.utils;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/**
 * Provides some helpful methods if you want to get some informations from the system.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class SystemUtils {

	private SystemUtils() {}
	
	/**
	 * @return {@code true} if this program runs in a 64Bit Java Virtual Mashine, else {@code false}
	 * @since 1.0.0
	 */
	public static final boolean is64Bit() {
		
		return System.getProperty("os.arch").contains("64");
	}
	
	/**
	 * @return {@code true} if num lock is activated, else {@code false}
	 * @since 1.0.0
	 */
	public static final boolean isNumLock() {
		
		return Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_NUM_LOCK);
	}
	
	/**
	 * @return {@code true} if caps lock is activated, else {@code false}
	 * @since 1.0.0
	 */
	public static final boolean isCapsLock() {
		
		return Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
	}
	
	/**
	 * Emits an audio beep depending on native system settings and hardware capabilities.
	 * @since 1.0.0
	 */
	public static final void beep() {
		
		Toolkit.getDefaultToolkit().beep();
	}
	
	/**
	 * Adds a directory to the library path. This can get you in trouble with the security manager if you do not
	 * have full administration rights. The purpose of this method is to load native libraries dynamically without
	 * having to worry about the platform.
	 * @param directory the directory name. Can be relative or absolute.
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @since 1.0.0
	 */
	public static final void addDirectoryToLibraryPath(String directory) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

		System.setProperty("java.library.path", directory.replace("/", File.separator).replace("\\", File.separator) + ";" + System.getProperty("java.library.path"));
		Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
		sysPathsField.setAccessible(true);
		sysPathsField.set(null, null);
	}
	
	/**
	 * Gets the value of the specified environment variable. An environment variable is a system-dependent external named value.
	 * @param name name of the variable
	 * @return the value of the environment variable
	 * @throws SecurityException If you do not have the permission to read the given variable
	 * @since 1.0.0
	 */
	public final String getEnvironmentVariable(String name) throws SecurityException {
		
		return System.getenv(name);
	}
	
	/**
	 * @return an unmodifiable string map view of the current system environment. The environment is a
	 * system-dependent mapping from names to values which is passed from parent to child processes. If the
	 * system does not support environment variables, an empty map is returned. The returned map will never
	 * contain null keys or values.
	 * @throws SecurityException If you do not have the permission to read environment variables
	 * @since 1.0.0
	 */
	public final Map<String, String> getEnvironmentVariables() throws SecurityException {
		
		return System.getenv();
	}
	
	/**
	 * Executes the given commands in a batch.
	 * @param cmd batch of commands
	 * @return the instance of {@linkplain Process} in which the commands are executed
	 * @throws IOException if an I/O error occurs
	 * @since 1.0.0
	 */
	public static final Process execute(String... cmd) throws IOException {
		
		return Runtime.getRuntime().exec(cmd);
	}
	
	/**
	 * Opens the native internet browser 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @since 1.0.0
	 */
	public final Process openNativeBrowser(String url) throws IOException, URISyntaxException {

		Process process = null;
		
		switch(SystemUtils.getOperatingSystem()) {
		
			case LINUX:
				String[] browsers = {
					"epiphany",
					"firefox",
					"mozilla",
					"konqueror",
					"netscape",
					"opera",
					"links",
					"lynx",
					"vivaldi"
				};
					
				StringBuffer cmd = new StringBuffer();
					
				for(int index = 0; index < browsers.length; index++) {
						
					cmd.append((index == 0  ? "" : " || " ) + browsers[index] +" \"" + url + "\" ");
				}
					
				process = Runtime.getRuntime().exec(new String[] {"sh", "-c", cmd.toString()});
				break;
				
			case MAC:
				process = Runtime.getRuntime().exec("open " + url);
				break;
				
			case WINDOWS:
				process = Runtime.getRuntime().exec("cmd /c start " + url);
				break;
				
			default:
				if(Desktop.isDesktopSupported()) {
					
					if(Desktop.getDesktop().isSupported(Action.BROWSE)) {
						
						Desktop.getDesktop().browse(new URL(url).toURI());
					}
				}
				
				break;
		}
		
		return process;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final long getMaximumMemory() {
		
		return Runtime.getRuntime().maxMemory();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final long getTotalMemory() {
		
		return Runtime.getRuntime().totalMemory();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final long getFreeMemory() {
		
		return Runtime.getRuntime().freeMemory();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final int getNumberOfProcessors() {
		
		return Runtime.getRuntime().availableProcessors();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final GraphicsDevice getDefaultScreen() {
		
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final GraphicsDevice[] getScreens() {
		
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final Dimension getScreenSize() {
		
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	/**
	 * 
	 * @return
	 * @throws AWTException
	 * @since 1.0.0
	 */
	public static final BufferedImage screenshot() throws AWTException {
		
		Robot robot = new Robot();
		Dimension screenSize = SystemUtils.getScreenSize();
		return robot.createScreenCapture(new Rectangle(0, 0, screenSize.width, screenSize.height));
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final int getNumberOfMouseButtons() {
		
		return MouseInfo.getNumberOfButtons();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final GraphicsDevice getScreenWithMouseCursorInIt() {

		return MouseInfo.getPointerInfo().getDevice();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final OperatingSystem getOperatingSystem() {
		
		String osName = System.getProperty("os.name");
		return System.getProperty("java.vendor").toLowerCase().contains("android") ? OperatingSystem.ANDROID : (osName.toLowerCase().contains("win") ? OperatingSystem.WINDOWS : (osName.toLowerCase().contains("mac") ? OperatingSystem.MAC : (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nux") ? OperatingSystem.LINUX : (osName.toLowerCase().contains("sunos") ? OperatingSystem.SOLARIS : OperatingSystem.UNKNOWN))));
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final String getLanguage() {
		
		return System.getProperty("user.language").toUpperCase();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final String getCountry() {
		
		return System.getProperty("user.country");
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final File getTempDirectory() {
		
		return new File(System.getProperty("java.io.tmpdir"));
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final File getUserHomeDirectory() {
		
		return new File(System.getProperty("user.home"));
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final String getUsername() {
		
		return System.getProperty("user.name");
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static final String getJavaVersion() {
		
		return System.getProperty("java.version");
	}
	
	/**
	 * 
	 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	public static enum OperatingSystem {
		
		/**
		 * 
		 * @since 1.0.0
		 */
		WINDOWS,
		
		/**
		 * 
		 * @since 1.0.0
		 */
		LINUX,
		
		/**
		 * 
		 * @since 1.0.0
		 */
		MAC,
		
		/**
		 * 
		 * @since 1.0.0
		 */
		ANDROID,
		
		/**
		 * 
		 * @since 1.0.0
		 */
		SOLARIS,
		
		/**
		 * 
		 * @since 1.0.0
		 */
		UNKNOWN;
	}
}
