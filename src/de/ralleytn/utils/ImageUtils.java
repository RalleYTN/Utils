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

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

/**
 * Provides some helpful methods regarding images.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.2.0
 * @since 1.0.0
 */
public final class ImageUtils {

	private ImageUtils() {}
	
	/**
	 * 
	 * @param image
	 * @param output
	 * @param quality
	 * @throws IOException
	 * @since 1.2.0
	 */
	public static final void writeJPEG(BufferedImage image, OutputStream output, float quality) throws IOException {
		
		ImageWriter writer = ImageIO.getImageWritersByFormatName("JPEG").next();
		ImageWriteParam param = writer.getDefaultWriteParam();
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);
		
		try(ImageOutputStream stream = ImageIO.createImageOutputStream(output)) {
			
			writer.setOutput(stream);
			writer.write(null, new IIOImage(image, null, null), param);
			writer.setOutput(null);
		}
	}
	
	/**
	 * 
	 * @param image
	 * @param format
	 * @return
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final byte[] getBase64(BufferedImage image, String format) throws IOException {
		
		try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			
			ImageIO.write(image, format, outputStream);
			return Base64.getEncoder().encode(outputStream.toByteArray());
		}
	}
}
