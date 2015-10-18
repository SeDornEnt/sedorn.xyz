package org.sedorn.screenshotter.client;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Scanner;

import javax.imageio.ImageIO;
import org.sedorn.screenshotter.client.httpclient.HttpPost;
import org.sedorn.screenshotter.json.JSONObject;

public class Uploader implements Runnable {

	public static void uploadCurrentImage() throws IOException, InterruptedException{
		 Socket socket = new Socket("sedorn.xyz", 6666);
	     OutputStream outputStream = socket.getOutputStream();
	     InputStream inputStream = socket.getInputStream();

	     System.out.println("Reading file: " + System.currentTimeMillis());
	     BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "/screenshot.png"));
	     System.out.println("Finished reading file: " + System.currentTimeMillis());
	     
	     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	     ImageIO.write(image, "png", byteArrayOutputStream);

	     byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
	     outputStream.write(size);
	     outputStream.write(byteArrayOutputStream.toByteArray());
	     outputStream.flush();
	     
	     //Get Image url from server
	     Scanner in = new Scanner(inputStream);
	     
	     boolean hasArrived = false;
	     String url = null;
	     
	     while(!hasArrived){
	    	 url = in.nextLine();
	    	 if(url != null){
	    		 hasArrived = true;
	    	 }
	     }
	     //Connect to SeDornAPI
	     
	     StringBuffer response = HttpPost.send("image", "uploader=" + Main.getUser().username + "&uuid=" + Main.getUser().uuid + "&height=" + image.getHeight() + "&width=" + image.getWidth() + "&isPublic=" + false);
	     
	     JSONObject json = new JSONObject(response);
	     
	     System.out.println(response);
	     
	     
	     try {
			Desktop.getDesktop().browse(new URI("https://www.sedorn.xyz/shot/" + url + ".png"));
			Clipboard.addToClipboard("https://www.sedorn.xyz/shot/" + url + ".png");
		 } catch (URISyntaxException e) {
		 	e.printStackTrace();
		 }
	     
	     Thread.sleep(1000);

	     socket.close();
	     
	}

	@Override
	public void run() {
		//Wait till upload is finished
		try {
			uploadCurrentImage();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		//Call function from client with the Image URL
	}
}
