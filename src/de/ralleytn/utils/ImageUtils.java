package de.ralleytn.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class ImageUtils {

	private ImageUtils() {}
	
	/**
	 * 
	 * @param image
	 * @param format
	 * @param type
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final byte[] getBase64(BufferedImage image, String format, int type) throws IOException {
		
		try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			
			ImageIO.write(image, format, outputStream);
			return Base64.getEncoder().encode(outputStream.toByteArray());
		}
	}
}
