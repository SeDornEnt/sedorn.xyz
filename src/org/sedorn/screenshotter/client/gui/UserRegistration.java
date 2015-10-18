package org.sedorn.screenshotter.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sedorn.screenshotter.client.UserManager;
import org.sedorn.screenshotter.client.httpclient.HttpPost;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class UserRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtRepeatPassword;
	
	
	
	boolean isTicked = false;

	/**
	 * Launch the application.
	 */
	public void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserRegistration = new JLabel("User Registration");
		lblUserRegistration.setBounds(10, 11, 228, 14);
		contentPane.add(lblUserRegistration);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 40, 222, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JCheckBox chckbxSecureAccount = new JCheckBox("Secure account with password");
		
		chckbxSecureAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isTicked){
					txtPassword.setEnabled(false);
					txtPassword.setEditable(false);
					txtRepeatPassword.setEnabled(false);
					txtRepeatPassword.setEditable(true);
					
					isTicked = false;
				} else {
					JOptionPane.showMessageDialog(null, "Warning: The password will be safed only hashed on your disk and our database\nIt is only used to auth your computer on a second layer.\nDont use any password you use in the internet!", "Warning", JOptionPane.WARNING_MESSAGE);
					txtPassword.setEnabled(true);
					txtPassword.setEditable(true);
					txtRepeatPassword.setEnabled(true);
					txtRepeatPassword.setEditable(true);
					
					isTicked = true;
				}
			}
		});
		
		chckbxSecureAccount.setBounds(10, 67, 222, 23);
		contentPane.add(chckbxSecureAccount);
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setEnabled(false);
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 97, 222, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtRepeatPassword = new JTextField();
		txtRepeatPassword.setText("Repeat Password");
		txtRepeatPassword.setEnabled(false);
		txtRepeatPassword.setEditable(false);
		txtRepeatPassword.setColumns(10);
		txtRepeatPassword.setBounds(10, 128, 222, 20);
		contentPane.add(txtRepeatPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText() != null || txtUsername.getText() != "Username"){
					if(isTicked){
						if(txtPassword.getText() != null || txtPassword.getText() != "Password"){
							if(txtRepeatPassword.getText() != null || txtRepeatPassword.getText() != "Repeat Password"){
								UUID uuid = UUID.randomUUID();
								
								InetAddress ip;
								try {
									ip = InetAddress.getLocalHost();
									HttpPost.send("user", "user=" + txtUsername.getText() + "&uuid=" + uuid.toString() + "&password=" + txtPassword.getText() + "&ip=" + ip.getHostAddress());
									UserManager.onRegister(txtUsername.getText(), txtPassword.getText(), uuid.toString());
									setVisible(false);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
						
					} else {
						UUID uuid = UUID.randomUUID();
						
						InetAddress ip;
						try {
							ip = InetAddress.getLocalHost();
							HttpPost.send("user", "user=" + txtUsername.getText() + "&uuid=" + uuid.toString() + "&password=" + null + "&ip=" + ip.getHostAddress());
							UserManager.onRegister(txtUsername.getText(), null, uuid.toString());
							setVisible(false);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnRegister.setBounds(52, 205, 146, 23);
		contentPane.add(btnRegister);
	}
}
