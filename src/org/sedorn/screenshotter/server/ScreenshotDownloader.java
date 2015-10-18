package org.sedorn.screenshotter.server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.UUID;

import javax.imageio.ImageIO;

public class ScreenshotDownloader implements Runnable {
	protected Socket clientSocket = null;
	
    public ScreenshotDownloader(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static byte[] readExactly(InputStream input, int size) throws IOException
    {
        byte[] data = new byte[size];
        int index = 0;
        while (index < size)
        {
            int bytesRead = input.read(data, index, size - index);
            if (bytesRead < 0)
            {
                throw new IOException("Insufficient data in stream");
            }
            index += bytesRead;
        }
        return data;
    }
    
    public void run() {
        try {
        	InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            
            System.out.println("Reading: " + time);

            byte[] sizeAr = new byte[4];
            //Get Image size
            input.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
            
            String filename = UUID.randomUUID().toString();
            
            if (size > 0)
            {
                byte[] imgBytes = readExactly(input, size);

                FileOutputStream f = new FileOutputStream("//usr//share//nginx//shot//" + filename + ".png");
                f.write(imgBytes);
                f.close();
                
                BufferedImage image = ImageIO.read(new File("//usr//share//nginx//shot//" + filename + ".png"));
                System.out.println("Received " + image.getWidth() + "x" + image.getHeight() + ": " + System.currentTimeMillis());
            }
            Statistics.addFileStats(1, size);
            
            //Send Client the Filename, so he can open it at his webbrowser
            PrintWriter writer = new PrintWriter( output, true );
            
            writer.write(filename);
            writer.flush();
            writer.close();
            
            //Disconnect the client
            clientSocket.close();
            
            Statistics.onClientDisconnect();
            
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
