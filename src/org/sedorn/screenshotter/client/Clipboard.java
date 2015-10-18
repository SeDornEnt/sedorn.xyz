package org.sedorn.screenshotter.client;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class Clipboard {
	public static void addToClipboard(String url){
		java.awt.datatransfer.Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		c.setContents(new StringSelection(url), null);
	}

}
