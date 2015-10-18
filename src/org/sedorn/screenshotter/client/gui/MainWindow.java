package org.sedorn.screenshotter.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sedorn.screenshotter.client.ScreenCaptureRectangle;
import org.sedorn.screenshotter.client.Screenshot;
import org.sedorn.screenshotter.client.Uploader;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Desktop;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	JLabel lblNewLabel;
	
	private String username;
	
	
	/**
	 * 
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as:");
		lblLoggedInAs.setBounds(10, 11, 82, 15);
		lblLoggedInAs.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		contentPane.add(lblLoggedInAs);
		
		lblNewLabel = new JLabel(username);
		lblNewLabel.setBounds(89, 12, 146, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblServerStatus = new JLabel("Server Status:");
		lblServerStatus.setBounds(365, 11, 82, 14);
		lblServerStatus.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		contentPane.add(lblServerStatus);
		
		JLabel lblOnline = new JLabel("ONLINE");
		lblOnline.setForeground(new Color(0, 128, 0));
		lblOnline.setBounds(457, 12, 46, 14);
		contentPane.add(lblOnline);
		
		JButton btnNewButton = new JButton("User Managment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccountManager account = new AccountManager(username);
				account.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 32, 135, 23);
		contentPane.add(btnNewButton);
		
		
		//Server Status
		JButton btnNewButton_1 = new JButton("Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServerStatus status = new ServerStatus();
				status.create();
				
			}
		});
		btnNewButton_1.setBounds(358, 32, 145, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Version:");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 263, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBeta = new JLabel("0.5 Beta");
		lblBeta.setBounds(99, 264, 46, 14);
		contentPane.add(lblBeta);
		
		JLabel lblNewLabel_2 = new JLabel("\u00A9 Sebastian Dorn 2015");
		lblNewLabel_2.setBounds(358, 264, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Check for updates");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your are up-to-date!");
			}
		});
		btnNewButton_2.setBounds(10, 237, 135, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblSedornxyz = new JLabel("sedorn.xyz");
		lblSedornxyz.setHorizontalAlignment(SwingConstants.CENTER);
		lblSedornxyz.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblSedornxyz.setBounds(145, 11, 210, 14);
		contentPane.add(lblSedornxyz);
		
		JButton btnNewButton_3 = new JButton("Settings");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings settings = new Settings();
				settings.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(358, 237, 145, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Fullscreenshot");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screenshot.fullscreenShot();
				
				try {
					Uploader.uploadCurrentImage();
				} catch (IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(145, 78, 210, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Screenshot");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ScreenCaptureRectangle.capture();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_5.setBounds(145, 143, 210, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Visit Website");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://sedorn.xyz"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(145, 203, 210, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblDidYouKnow = new JLabel("Did you know?");
		lblDidYouKnow.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDidYouKnow.setHorizontalAlignment(SwingConstants.CENTER);
		lblDidYouKnow.setBounds(10, 82, 135, 14);
		contentPane.add(lblDidYouKnow);
		
		JLabel lblThatxyzIs = new JLabel("That .xyz is one of the");
		lblThatxyzIs.setBounds(10, 107, 135, 14);
		contentPane.add(lblThatxyzIs);
		
		JLabel lbltldOnThe = new JLabel("cheapest Top-Level-");
		lbltldOnThe.setBounds(10, 120, 135, 23);
		contentPane.add(lbltldOnThe);
		
		JLabel lblItCosts = new JLabel("It costs ~1 dollar/year");
		lblItCosts.setBounds(10, 162, 135, 14);
		contentPane.add(lblItCosts);
		
		JLabel lblDomains = new JLabel("Domains on the market");
		lblDomains.setBounds(10, 143, 125, 14);
		contentPane.add(lblDomains);
		
		JLabel label = new JLabel("Did you know?");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(368, 82, 135, 14);
		contentPane.add(label);
		
		JLabel lblThisSectionIs = new JLabel("This section is only used as ");
		lblThisSectionIs.setBounds(365, 107, 146, 14);
		contentPane.add(lblThisSectionIs);
		
		JLabel lblPlaceholder = new JLabel("placeholder? I didn't know");
		lblPlaceholder.setBounds(366, 124, 145, 14);
		contentPane.add(lblPlaceholder);
		
		JLabel lblWhatShouldI = new JLabel("what should I put here so");
		lblWhatShouldI.setBounds(366, 143, 145, 14);
		contentPane.add(lblWhatShouldI);
		
		JLabel lblHereWeAre = new JLabel("here we are.......");
		lblHereWeAre.setBounds(366, 162, 145, 14);
		contentPane.add(lblHereWeAre);
	}
	public void updateUsername(String username){
		lblNewLabel.setText(username);
		this.username = username;
	}
	
	
	
	
	
	
	
	
}
