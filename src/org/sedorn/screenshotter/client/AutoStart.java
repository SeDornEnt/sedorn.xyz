package org.sedorn.screenshotter.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AutoStart {

	public static boolean enable(){
		
		File batch = new File("C://ProgramData//Microsoft//Windows//Start Menu//Programs//Startup//sedorn.bat");
		
		try {
			batch.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter(batch));
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
		
		try {
			writer.write("@javaw -jar sedorn.jar");
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
		//TODO: Download jar file and put it into the dir
		
		
		return true;
	}
	public static boolean disable(){
		
		File batch = new File("C://ProgramData//Microsoft//Windows//Start Menu//Programs//Startup//sedorn.bat");
		
		batch.delete();
		
		//TODO: Delete jar file
		
		return true;
	}
}
