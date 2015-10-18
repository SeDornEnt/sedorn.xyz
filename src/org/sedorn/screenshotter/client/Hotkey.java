package org.sedorn.screenshotter.client;

import java.io.IOException;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class Hotkey implements HotkeyListener {
	
	private boolean ctrl;
	private boolean shift;
	private int buchstabe;
	private int buchstabe1;
	
	
	private float lastClicked;


	public Hotkey(boolean shift, boolean ctrl, int buchstabe, int buchstabe1){
		this.shift = shift;
		this.ctrl = ctrl;
		
		this.buchstabe = buchstabe;
		this.buchstabe1 = buchstabe1;
	}
	
	
	
	
	public boolean enable(){
		JIntellitype.getInstance();
		
		if(shift && ctrl){
			JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, buchstabe);
			JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_SHIFT + JIntellitype.MOD_CONTROL, buchstabe1);
		} else if (shift && !ctrl){
			JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_SHIFT, buchstabe);
		} else if(!shift && ctrl) {
			JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_CONTROL, buchstabe);
		}

		JIntellitype.getInstance().addHotKeyListener(this);
		
		return true;
	}
	
	public void onHotKey(int aIdentifier) {
	    if (aIdentifier == 1 && lastClicked < System.currentTimeMillis() + 3000){
	  
	    	Screenshot.fullscreenShot();
	    	try {
				Uploader.uploadCurrentImage();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    if (aIdentifier == 2 && lastClicked < System.currentTimeMillis() + 3000){
	  	  
	    	try {
		    	ScreenCaptureRectangle.capture();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}
	
	public void disable(){
		JIntellitype.getInstance().cleanUp();
	}
}
