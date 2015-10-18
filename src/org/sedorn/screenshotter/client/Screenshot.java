package org.sedorn.screenshotter.client;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshot {
		
	public static boolean fullscreenShot(){
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException | AWTException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			System.out.println("Writing file: " + System.currentTimeMillis());
			ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "/screenshot.png"));
			System.out.println("Finished writing file: " + System.currentTimeMillis());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean screenShot(Rectangle rect){
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(rect);
		} catch (HeadlessException | AWTException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			System.out.println("Writing file: " + System.currentTimeMillis());
			ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "/screenshot.png"));
			System.out.println("Finished writing file: " + System.currentTimeMillis());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
