package org.sedorn.screenshotter.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class AccountManager extends JFrame {

	private JPanel contentPane;
	
	private String username = "NaN";

	public AccountManager(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountManager = new JLabel("Account Manager");
		lblAccountManager.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
		lblAccountManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountManager.setBounds(10, 11, 214, 20);
		contentPane.add(lblAccountManager);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 42, 124, 14);
		contentPane.add(lblUsername);
		
		this.username = username;
		JLabel lblusername = new JLabel(username);
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);
		lblusername.setBounds(124, 42, 100, 14);
		contentPane.add(lblusername);
		
		JLabel lblPicuturesUploaded = new JLabel("Picutures Uploaded:");
		lblPicuturesUploaded.setBounds(10, 70, 124, 14);
		contentPane.add(lblPicuturesUploaded);
		
		JLabel lblNanUpdate = new JLabel("NaN - Update");
		lblNanUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblNanUpdate.setBounds(124, 70, 100, 14);
		contentPane.add(lblNanUpdate);
		
		JLabel lblMemberSince = new JLabel("Member since:");
		lblMemberSince.setBounds(10, 102, 124, 14);
		contentPane.add(lblMemberSince);
		
		JLabel label_1 = new JLabel("NaN - Update");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(124, 102, 100, 14);
		contentPane.add(label_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(10, 227, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnProfile = new JButton("Show Profile");
		btnProfile.setBounds(57, 193, 124, 23);
		contentPane.add(btnProfile);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(135, 227, 89, 23);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("9affb8f7-6dd9-4191-8a02-3cf68ac196a4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 153, 214, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUuid = new JLabel("UUID:");
		lblUuid.setHorizontalAlignment(SwingConstants.CENTER);
		lblUuid.setBounds(88, 127, 46, 14);
		contentPane.add(lblUuid);
	}

}
