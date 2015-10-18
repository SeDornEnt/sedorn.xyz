package org.sedorn.screenshotter.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer implements Runnable {
	
	private int serverPort = 6666;
	private ServerSocket serverSocket = null;
	private boolean isRunning = true;
	private Thread thisThread = null;
	
	 public ThreadServer(int port){
	        this.serverPort = port;
	    }

	    public void run(){
	        synchronized(this){
	            this.thisThread = Thread.currentThread();
	        }
	        openServerSocket();
	        while(isRunning()){
	            Socket clientSocket = null;
	            try {
	                clientSocket = this.serverSocket.accept();
	            } catch (IOException e) {
	                if(!isRunning()) {
	                    System.out.println("Server Stopped.") ;
	                    return;
	                }
	                throw new RuntimeException(
	                    "Error accepting client connection", e);
	            }
	            Statistics.onNewClientConnection();
	            //Run a new thread which handles the Screenshot Upload
	            new Thread(
	                new ScreenshotDownloader(
	                    clientSocket)
	            ).start();
	        }
	        System.out.println("Server Stopped.") ;
	    }


	    private synchronized boolean isRunning() {
	        return this.isRunning;
	    }

	    public synchronized void stop(){
	        this.isRunning = false;
	        try {
	            this.serverSocket.close();
	        } catch (IOException e) {
	            throw new RuntimeException("Error closing server", e);
	        }
	    }

	    private void openServerSocket() {
	        try {
	            this.serverSocket = new ServerSocket(this.serverPort);
	            System.out.println("Server started");
	        } catch (IOException e) {
	            throw new RuntimeException("Cannot open port " + this.serverPort, e);
	        }
	 }
}
	