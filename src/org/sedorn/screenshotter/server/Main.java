package org.sedorn.screenshotter.server;

import java.util.Scanner;

public class Main {
	
	public static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadServer server = new ThreadServer(6666);
		new Thread(server).start();
		startTime = System.currentTimeMillis();
		
		System.out.println("SeDorns Screenshot Server - Version 1.02");
		System.out.println(">> Write 'help' to get a list of commands");
		
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();

		while(line != null){
			switch(line){
			case "?":
			case "help":
				printHelp();
				line = in.nextLine();
				break;
			case "stop":
			case "exit":
			case "quit":
				stopServer(server);
				line = in.nextLine();
				break;
			case "stats":
				Statistics.printStats();
				line = in.nextLine();
				break;
			default:
				System.out.println(">> This command is not avaiable. Write 'help' to get a list of commands");
				line = in.nextLine();
				break;
			}
		}
	}
	public static void stopServer(ThreadServer server){
		System.out.println(">> Stopping Server");
		server.stop();
		System.exit(0);
	}
	
	public static void printHelp(){
		System.out.println(">> help - Shows this help dialog");
		System.out.println(">> quit - Stops the server");
		System.out.println(">> stats - Prints out the stats");
	}
}
