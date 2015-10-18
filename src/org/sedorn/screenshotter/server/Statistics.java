package org.sedorn.screenshotter.server;

public class Statistics {
	//How many files were uploaded
	public static int filesUploaded = 0;
	//How many bytes were transfered
	public static int fileSizeUploaded = 0;
	//How many clients are currently connected
	public static int currentConnections = 0;
	//How many connections have there been in the history?
	public static int completeConnections = 0;

	public static void addFileStats(int fileUpload, int filesize){
		if(fileUpload == 1){
			filesUploaded++;
		}
		if(filesize != 0){
			fileSizeUploaded += filesize;
		}
	}
	public static void onNewClientConnection(){
		currentConnections++;
		completeConnections++;
	}
	public static void onClientDisconnect(){
		currentConnections--;
	}
	public static void printStats(){
		System.out.println("SeDornStats - Version 0.23");
		System.out.println(">> Server running since " + (System.currentTimeMillis() - Main.startTime) / 1000 + " seconds");
		System.out.println(">> Files Uploaded: " + filesUploaded);
		System.out.println(">> Complete Filesize: " + fileSizeUploaded);
		System.out.println(">> Current Connections: " + currentConnections);
		System.out.println(">> All Connections: " + completeConnections);
		System.out.println("End of stats - Copyright 2015");
	}
	//TODO: Write and read values out of a file

}
