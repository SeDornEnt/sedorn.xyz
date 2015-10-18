package org.sedorn.screenshotter.client.gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.sedorn.screenshotter.client.Main;
import org.sedorn.screenshotter.client.ScreenCaptureRectangle;
import org.sedorn.screenshotter.client.Screenshot;
import org.sedorn.screenshotter.client.Uploader;

public class SystemTrayManager {
	
	static SystemTray systemTray;
	
	static TrayIcon trayIcon;
	
	
	public static boolean enable(){
		if(!SystemTray.isSupported()){
			return false;
		}
		systemTray = SystemTray.getSystemTray();

	    Image image = Toolkit.getDefaultToolkit().getImage("src/TrayIcon.png");

	    //popupmenu
	    PopupMenu trayPopupMenu = new PopupMenu();

	    
	    
	    //1t menuitem for popupmenu
	    MenuItem show = new MenuItem("Show");
	    show.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Main.showFrame(); 
	        }
	    });     
	    trayPopupMenu.add(show);
	    
	    
	    //1t menuitem for popupmenu
	    MenuItem action = new MenuItem("Fullscreenshot");
	    action.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Screenshot.fullscreenShot();
	    		new Thread(new Uploader()).start();     
	        }
	    });     
	    trayPopupMenu.add(action);
	  //1t menuitem for popupmenu
	    MenuItem action2 = new MenuItem("Screenshot");
	    action2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	try {
					ScreenCaptureRectangle.capture();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    });     
	    trayPopupMenu.add(action2);

	    //2nd menuitem of popupmenu
	    MenuItem close = new MenuItem("Close");
	    close.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);             
	        }
	    });
	    trayPopupMenu.add(close);

	    //setting tray icon
	    trayIcon = new TrayIcon(image, "sedorn.org", trayPopupMenu);
	    //adjust to default size as per system recommendation 
	    trayIcon.setImageAutoSize(true);

	    try{
	        systemTray.add(trayIcon);
	    }catch(AWTException awtException){
	        awtException.printStackTrace();
	    }
		
		return true;
	}
	public static void disable(){
		//systemTray.remove(trayIcon);
	}
	
	
	
	
}
