package org.sedorn.screenshotter.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sedorn.screenshotter.client.AutoStart;
import org.sedorn.screenshotter.client.Hotkey;
import org.sedorn.screenshotter.client.Main;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JCheckBox;

public class Settings extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	/**
	 * Create the frame.
	 */
	public Settings() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Settings");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 327, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblAutostart = new JLabel("Autostart");
		lblAutostart.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutostart.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutostart.setBounds(10, 97, 164, 14);
		contentPane.add(lblAutostart);
		
		final JRadioButton rdbtnEnable = new JRadioButton("Enable");
		rdbtnEnable.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnEnable);
		rdbtnEnable.setBounds(10, 118, 73, 23);
		contentPane.add(rdbtnEnable);
		
		final JRadioButton rdbtnDisable = new JRadioButton("Disable");
		rdbtnDisable.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnDisable);
		rdbtnDisable.setBounds(101, 118, 73, 23);
		contentPane.add(rdbtnDisable);
		
		JLabel lblTrayIcon = new JLabel("Tray Icon");
		lblTrayIcon.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrayIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrayIcon.setBounds(10, 160, 164, 14);
		contentPane.add(lblTrayIcon);
		
		final JRadioButton radioButton = new JRadioButton("Enable");
		buttonGroup_1.add(radioButton);
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton.setBounds(10, 181, 73, 23);
		contentPane.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("Disable");
		radioButton_1.setEnabled(false);
		buttonGroup_1.add(radioButton_1);
		radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_1.setBounds(101, 181, 73, 23);
		contentPane.add(radioButton_1);
		
		JLabel lblAutoUpdate = new JLabel("Auto Update");
		lblAutoUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutoUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutoUpdate.setBounds(10, 40, 164, 14);
		contentPane.add(lblAutoUpdate);
		
		JRadioButton radioButton_2 = new JRadioButton("Enable");
		radioButton_2.setEnabled(false);
		buttonGroup_2.add(radioButton_2);
		radioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_2.setBounds(10, 61, 73, 23);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Disable");
		radioButton_3.setEnabled(false);
		buttonGroup_2.add(radioButton_3);
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_3.setBounds(101, 61, 73, 23);
		contentPane.add(radioButton_3);
		
		
		JLabel lblHotkey = new JLabel("Hotkey");
		lblHotkey.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHotkey.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotkey.setBounds(215, 33, 89, 28);
		contentPane.add(lblHotkey);
		
		JRadioButton radioButton_4 = new JRadioButton("Enable");
		buttonGroup_3.add(radioButton_4);
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_4.setBounds(189, 61, 73, 23);
		contentPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("Disable");
		buttonGroup_3.add(radioButton_5);
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton_5.setBounds(264, 61, 73, 23);
		contentPane.add(radioButton_5);
		
		final JCheckBox chckbxCtrl = new JCheckBox("Ctrl");
		chckbxCtrl.setSelected(true);
		chckbxCtrl.setEnabled(false);
		chckbxCtrl.setBounds(196, 93, 51, 23);
		contentPane.add(chckbxCtrl);
		
		final JCheckBox chckbxStrg = new JCheckBox("Shift");
		chckbxStrg.setSelected(true);
		chckbxStrg.setEnabled(false);
		chckbxStrg.setBounds(264, 93, 51, 23);
		contentPane.add(chckbxStrg);
		
		
		final Choice choice = new Choice();
		choice.setBounds(196, 142, 124, 32);
		
		choice.add("A");
		choice.add("B");
		choice.add("C");
		choice.add("D");
		choice.add("E");
		choice.add("F");
		choice.add("G");
		choice.add("H");
		choice.add("I");
		choice.add("J");
		choice.add("K");
		choice.add("L");
		choice.add("M");
		choice.add("N");
		choice.add("O");
		choice.add("P");
		choice.add("Q");
		choice.add("R");
		choice.add("S");
		choice.add("T");
		choice.add("U");
		choice.add("V");
		choice.add("W");
		choice.add("X");
		choice.add("Y");
		choice.add("Z");

		
		choice.add("1");
		choice.add("2");
		choice.add("3");
		choice.add("4");
		choice.add("5");
		choice.add("6");
		choice.add("7");
		choice.add("8");
		choice.add("9");
		choice.add("0");
		
		
		contentPane.add(choice);

		
		final Choice choice_1 = new Choice();
		choice_1.setBounds(196, 184, 124, 20);
		
		choice_1.add("A");
		choice_1.add("B");
		choice_1.add("C");
		choice_1.add("D");
		choice_1.add("E");
		choice_1.add("F");
		choice_1.add("G");
		choice_1.add("H");
		choice_1.add("I");
		choice_1.add("J");
		choice_1.add("K");
		choice_1.add("L");
		choice_1.add("M");
		choice_1.add("N");
		choice_1.add("O");
		choice_1.add("P");
		choice_1.add("Q");
		choice_1.add("R");
		choice_1.add("S");
		choice_1.add("T");
		choice_1.add("U");
		choice_1.add("V");
		choice_1.add("W");
		choice_1.add("X");
		choice_1.add("Y");
		choice_1.add("Z");

		
		choice_1.add("1");
		choice_1.add("2");
		choice_1.add("3");
		choice_1.add("4");
		choice_1.add("5");
		choice_1.add("6");
		choice_1.add("7");
		choice_1.add("8");
		choice_1.add("9");
		choice_1.add("0");
		
		contentPane.add(choice_1);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTraySet = false;
				boolean isStartSet = false;
				boolean isHotkeySet = false;
				
				
				//TrayIcon	
				if(radioButton.isSelected()){
					SystemTrayManager.enable();	
					Main.getConfig().set("tray", true);
					
					isTraySet = true;
				} else if(radioButton_1.isSelected()){
					SystemTrayManager.disable();
					Main.getConfig().set("tray", false);
					
					isTraySet = true;
				} else {
					JOptionPane.showMessageDialog(null, "Bitte w‰hle etwas bei: Tray Icon" , "Warnung", JOptionPane.WARNING_MESSAGE);
				}
				//Autostart
				if(rdbtnEnable.isSelected()){
					//AutoStart.enable();
					Main.getConfig().set("autostart", true);
					
					isStartSet = true;
				} else if(rdbtnDisable.isSelected()){
					//AutoStart.disable();
					Main.getConfig().set("autostart", false);
					isStartSet = true;
				} else {
					JOptionPane.showMessageDialog(null, "Bitte w‰hle etwas bei: Autostart" , "Warnung", JOptionPane.WARNING_MESSAGE);
				}
				
				if(isStartSet && isTraySet){
					if(radioButton.isSelected()){
						SystemTrayManager.enable();	
						Main.getConfig().set("hotkey", true);
						
						if(chckbxCtrl.isSelected() && chckbxStrg.isSelected()){
							Hotkey key = new Hotkey(true, true, (int) choice.getSelectedItem().charAt(0), choice_1.getSelectedItem().charAt(0));
							key.enable();
							
							Main.getConfig().set("hotkey_shift", true);
							Main.getConfig().set("hotkey_ctrl", true);
							isHotkeySet = true;
						} else if(chckbxCtrl.isSelected() && !chckbxStrg.isSelected()){
							Hotkey key = new Hotkey(true, false, (int) choice.getSelectedItem().charAt(0), choice_1.getSelectedItem().charAt(0));
							key.enable();
							
							Main.getConfig().set("hotkey_shift", false);
							Main.getConfig().set("hotkey_ctrl", true);
							
							isHotkeySet = true;
						} else if(!chckbxCtrl.isSelected() && chckbxStrg.isSelected()){
							Hotkey key = new Hotkey(false, true, (int) choice.getSelectedItem().charAt(0), choice_1.getSelectedItem().charAt(0));
							key.enable();
							Main.getConfig().set("hotkey_shift", true);
							Main.getConfig().set("hotkey_ctrl", false);
							
							isHotkeySet = true;
						}
						Main.getConfig().set("hotkey_key", choice.getSelectedItem());
						Main.getConfig().set("hotkey_key_rect", choice_1.getSelectedItem());
					} else if(radioButton_1.isSelected()){
						SystemTrayManager.disable();
						Main.getConfig().set("hotkey", false);
						
						isHotkeySet = true;
					} else {
						JOptionPane.showMessageDialog(null, "Bitte w‰hle etwas bei: Hotkey" , "Warnung", JOptionPane.WARNING_MESSAGE);
					}
					
					
					
					
					
					
					setVisible(false);
					if(!Main.getConfig().getBoolean("tutorial")){
						JOptionPane.showMessageDialog(null, "Sehr gut! Nun mache deine Screenshots, entweder Fullscrenn oder nur ein Bereich \n Viel Spaﬂ mit dem Dienst \n -SeDorn");
						Main.getConfig().set("tutorial", true);
					} else {
						JOptionPane.showMessageDialog(null, "Settings saved! \n Please restart the App to update the Shortcuts!");
					}
					
				}
				
				
				//AutoUpdate
				//TODO:

			}
		});
		btnSave.setBounds(10, 227, 326, 23);
		contentPane.add(btnSave);
		
		JLabel lblFullscreenshot = new JLabel("Fullscreenshot");
		lblFullscreenshot.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullscreenshot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFullscreenshot.setBounds(173, 122, 164, 14);
		contentPane.add(lblFullscreenshot);
		
		JLabel lblScreenRectangle = new JLabel("Screen rectangle");
		lblScreenRectangle.setHorizontalAlignment(SwingConstants.CENTER);
		lblScreenRectangle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblScreenRectangle.setBounds(173, 164, 164, 14);
		contentPane.add(lblScreenRectangle);


	}
}
