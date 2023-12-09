package book.system.login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LoginView {
	
	private JFrame frame;
	private JPanel loginPanel;
	public LoginView(JFrame frame, JPanel loginPanel){
	this.frame = frame;
	this.loginPanel = loginPanel;
	initView();
	}

    public static void initView() {
		
		LineBorder lineBorder =new LineBorder(Color.white, 8, true);
        JFrame frame = new JFrame("Login");
        JPanel loginPanel = new JPanel();
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
        loginLabel.setBounds(100, 147, 150, 44);
        loginLabel.setFont(new Font("Calibre", Font.BOLD, 35));
        loginPanel.add(loginLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(38, 222, 100, 19);
        userLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        loginPanel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(38, 244, 224, 28);
		userField.setBorder(lineBorder);
        loginPanel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(38, 294, 100, 19);
        passLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        loginPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(38, 316, 224, 28);
		passField.setBorder(lineBorder);
        loginPanel.add(passField);

        JButton logBtn = new JButton("LOGIN");
        logBtn.setBounds(100, 418, 96, 22);
		logBtn.setBackground(Color.WHITE);
        loginPanel.add(logBtn);

		frame.setSize(315,540);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
    
    }
	
}
