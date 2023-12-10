package book.system.login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView {
	private JFrame frame;
	private JPanel loginPanel;
	public LoginView(JFrame frame, JPanel loginPanel){
		this.frame = frame;
		this.loginPanel = loginPanel;
		initView();
	}
	
    public void initView() {
        frame.setSize(315,540);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		LineBorder lineBorder =new LineBorder(Color.white, 1, true);
        Color background = new Color(172, 207, 203);

        loginPanel.setBackground(background);
        loginPanel.setBounds(0, 0, 300, 500);
        loginPanel.setLayout(null);
        frame.add(loginPanel);
		
        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("cite.jpg"));
        pic.setBounds(93, 26, 125, 124);
        loginPanel.add(pic);

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(97, 147, 150, 44);
        loginLabel.setFont(new Font("Calibre", Font.BOLD, 35));
        loginPanel.add(loginLabel);

        JTextArea lineArea = new JTextArea();
        lineArea.setBounds(0,195,300,1);
        lineArea.setBackground(new Color(0,0,0));
        lineArea.setEditable(false);
        loginPanel.add(lineArea);

        JTextArea lineArea2 = new JTextArea();
        lineArea2.setBounds(0,468,300,1);
        lineArea2.setBackground(new Color(0,0,0));
        lineArea2.setEditable(false);
        loginPanel.add(lineArea2);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(38, 222, 100, 19);
        userLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        loginPanel.add(userLabel);

        JTextField usernameField = new JTextField("");
        usernameField.setBounds(38, 244, 224, 28);
		usernameField.setBorder(lineBorder);
        loginPanel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(38, 294, 100, 19);
        passLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        loginPanel.add(passLabel);

        JPasswordField passwordField = new JPasswordField("");
        passwordField.setBounds(38, 316, 224, 28);
		passwordField.setBorder(lineBorder);
        loginPanel.add(passwordField);

        JLabel contactLabel = new JLabel("Contact us: Tel. Number +63 32 346-1611   ||   cite-no-reply@gmail.com");
        contactLabel.setBounds(5, 475, 300, 20);
        contactLabel.setFont(new Font("Dialog", Font.ITALIC + Font.BOLD , 8));
        loginPanel.add(contactLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 418, 96, 22);
		loginButton.setBackground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				LoginController.ifUserExist(frame, loginPanel, usernameField, passwordField);
				usernameField.setText("");
				passwordField.setText("");
			}
		});
        loginPanel.add(loginButton);

		
        frame.setVisible(true);
    }

}

