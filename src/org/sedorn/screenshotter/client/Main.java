package org.sedorn.screenshotter.client;

import java.awt.event.WindowAdapter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.sedorn.screenshotter.client.gui.MainWindow;
import org.sedorn.screenshotter.client.gui.SystemTrayManager;

public class Main {

	static MainWindow window;
	static Config config;
	static UserData user = null;

	public static void main(String[] args) {
		config = new Config();
		try {
			config.init();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Hotkey key;

		// Hotkey
		if (!config.isNew) {
			if (config.getBoolean("hotkey")) {
				key = new Hotkey(config.getBoolean("hotkey_shift"), config.getBoolean("hotkey_shift"), (int) config.getString("hotkey_key").charAt(0), (int) config.getString("hotkey_key_rect").charAt(0));
				key.enable();
			}
			if(config.getBoolean("tray")){
				SystemTrayManager.enable();
			}
			
			
		}

		window = new MainWindow();
		window.setVisible(true);
		
		window.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if(!config.getBoolean("message_close")){
		        	if (JOptionPane.showConfirmDialog(window, 
				            "sedorn.xyz will run in the backround in your System Tray \n Never show message again?", "Information", 
				            JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				            config.set("message_close", true);
				        }
		        }
		    }
		});
		

		UserManager manager = new UserManager();
		try {
			user = manager.check();

			config.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		window.updateUsername(user.username);
	}

	public static MainWindow getWindow() {
		return window;
	}

	public static Config getConfig() {
		return config;
	}

	public static UserData getUser() {
		return user;
	}
	public static void showFrame(){
			window.setVisible(false);
		
			window = new MainWindow();
			window.setVisible(true);
	}
	
	
	
}
