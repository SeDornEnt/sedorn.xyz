package org.sedorn.screenshotter.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class ServerStatus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerStatus frame = new ServerStatus();
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
	public ServerStatus() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 233, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblServerStatus = new JLabel("Server Status");
		lblServerStatus.setBounds(5, 5, 202, 14);
		lblServerStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblServerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblServerStatus);
		
		JLabel lblScreenshot = new JLabel("Screenshot 1");
		lblScreenshot.setBounds(5, 24, 146, 14);
		contentPane.add(lblScreenshot);
		
		JLabel lblScreenshot_1 = new JLabel("Screenshot 2");
		lblScreenshot_1.setBounds(5, 61, 146, 14);
		contentPane.add(lblScreenshot_1);
		
		JLabel lblApi = new JLabel("API");
		lblApi.setBounds(5, 107, 146, 14);
		contentPane.add(lblApi);
		
		JLabel lblMongodb = new JLabel("Database");
		lblMongodb.setBounds(5, 152, 146, 14);
		contentPane.add(lblMongodb);
		
		JLabel lblNewLabel = new JLabel("Website");
		lblNewLabel.setBounds(5, 201, 146, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblOnline = new JLabel("Online");
		lblOnline.setForeground(new Color(0, 128, 0));
		lblOnline.setBounds(161, 24, 46, 14);
		contentPane.add(lblOnline);
		
		JLabel lblNan = new JLabel("Offline");
		lblNan.setForeground(new Color(128, 0, 0));
		lblNan.setBounds(161, 61, 46, 14);
		contentPane.add(lblNan);
		
		JLabel lblOnline_1 = new JLabel("Online");
		lblOnline_1.setForeground(new Color(0, 128, 0));
		lblOnline_1.setBounds(161, 107, 46, 14);
		contentPane.add(lblOnline_1);
		
		JLabel lblOnline_2 = new JLabel("Online");
		lblOnline_2.setForeground(new Color(0, 128, 0));
		lblOnline_2.setBounds(161, 152, 46, 14);
		contentPane.add(lblOnline_2);
		
		JLabel lblOnline_3 = new JLabel("Online");
		lblOnline_3.setForeground(new Color(0, 128, 0));
		lblOnline_3.setBounds(161, 201, 46, 14);
		contentPane.add(lblOnline_3);
		
		JLabel lblEverythingShouldWork = new JLabel("Everything should work just fine!");
		lblEverythingShouldWork.setBackground(Color.BLACK);
		lblEverythingShouldWork.setForeground(new Color(0, 128, 0));
		lblEverythingShouldWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblEverythingShouldWork.setBounds(5, 236, 202, 14);
		contentPane.add(lblEverythingShouldWork);
	}
}
