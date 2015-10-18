package org.sedorn.screenshotter.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.sedorn.screenshotter.client.gui.Settings;
import org.sedorn.screenshotter.client.gui.UserRegistration;
import org.sedorn.screenshotter.json.JSONObject;

public class UserManager {
	
	private String jsonData;
	private boolean finishedReading;
	
	
	private String readLine;
	
	//Check if he already registered and "login"
	public UserData check() throws IOException{
		File data = new File("data.json");
		
		//We are registered
		if(data.exists()){
			//Read the file
			BufferedReader reader = new BufferedReader(new FileReader(data));
			
			jsonData = reader.readLine();
			
			System.out.println(jsonData);
			reader.close();
			
			JSONObject json = new JSONObject(jsonData);
			
			
			return new UserData(json.getString("uuid"), json.getString("username"), json.getString("password"), json.getBoolean("isPaying"));
		} else {
			//data.createNewFile();
			
			JOptionPane.showMessageDialog(null, "Willkommen zum sedorn.xyz Screenshot Tool! \n Richten wir zuerst dein Profil ein, damit du starten kannst \n Keine Angst, du brauchst keine Email anzugeben oder ein Password zu merken");
			
			UserRegistration register = new UserRegistration();
			register.create();

			return null;
		}
		
	}
	
	public static void onRegister(String username, String password, String uuid) throws IOException{
		File data = new File("data.json");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(data));
		
		JSONObject json = new JSONObject();
		json.put("uuid", uuid);
		json.put("username", username);
		json.put("password", password);
		json.put("isPaying", false);
		
		writer.write(json.toString());
		writer.close();
		
		Main.getWindow().updateUsername(username);
		
		JOptionPane.showMessageDialog(null, "Erfolgreich registriert! Nun schauen wir uns kurz die Einstellungen an!");
		
		Settings settings = new Settings();
		settings.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Setze alle Einstellungen und klicke danach auf 'Save' um zu starten!");
		
		
	}
}
