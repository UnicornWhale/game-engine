package engine.util;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageLoader {
	static Map<String, Image> images = new HashMap<String, Image>();
	
	/**
	 * ImageLoader.loadImage: Takes a string that is the path of the file including
	 * the extension and loads the image (must be .jpg) and returns the image as
	 * a BufferedImage. This can be directly drawn to the screen with Screen.draw
	 * 
	 * This method has a built in redundancy detector, so there is no harm in
	 * loading the same image every time you need it, the image will be stored
	 * the first time it is loaded and loaded from memory every time after that.
	 * @param path
	 * @return
	 */
	static public Image loadImage(String path) {
		if(images.containsKey(path)) {
			return images.get(path);
		}
		
		Image image = null;
		
		try {
			image = ImageIO.read(new File(path));
		} catch(Exception e) {
			System.out.println("Failed to load image: " + path);
		}
		
		images.put(path, image);
		
		return image;
	}
}
