package book.system.login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterView{
	public static void main(String args[]){

		JFrame frame = new JFrame("Register");
		JPanel panel = new JPanel();
		Color background = new Color(172,207,203);
		LineBorder lineBorder =new LineBorder(Color.white, 1, true);
		
		
		panel.setBackground(background);
		panel.setBounds(0,0,300,500);
		panel.setLayout(null);
		frame.add(panel);

		JLabel pic = new JLabel();
		pic.setIcon(new ImageIcon("cite.jpg"));
		pic.setBounds(93,26,125,124);
		panel.add(pic);

		JLabel registerLabel = new JLabel("REGISTER");
		registerLabel.setBounds(71,147,200,44);
		registerLabel.setFont(new Font ("Calibre" , Font.BOLD ,35));
		panel.add(registerLabel);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(38,225,100,19);
		nameLabel.setFont(new Font("Dialog", Font.BOLD , 15));
		panel.add(nameLabel);

		JTextField nameField = new JTextField();
		nameField.setBounds(38, 244, 224, 18);
		nameField.setBorder(lineBorder);
		panel.add(nameField);

		JLabel userLabel = new JLabel("Username:");
		userLabel.setBounds(38,270,100,19);
		userLabel.setFont(new Font("Dialog", Font.BOLD , 15));
		panel.add(userLabel);

		JTextField userField = new JTextField();
		userField.setBounds(38, 289, 224, 18);
		userField.setBorder(lineBorder);
		panel.add(userField);

		JLabel passLabel = new JLabel("Password:");
		passLabel.setBounds(38, 316, 224, 18);
		passLabel.setFont(new Font("Dialog", Font.BOLD , 15));
		panel.add(passLabel);

		JPasswordField passField = new JPasswordField();
		passField.setBounds(38, 335, 224, 18);
		passField.setBorder(lineBorder);
		panel.add(passField);

		JLabel conpassLabel = new JLabel("Confirm Password:");
		conpassLabel.setBounds(38, 361, 224, 18);
		conpassLabel.setFont(new Font("Dialog", Font.BOLD , 15));
		panel.add(conpassLabel);

		JPasswordField conpassField = new JPasswordField();
		conpassField.setBounds(38, 381, 224, 18);
		conpassField.setBorder(lineBorder);
		panel.add(conpassField);
		
		JButton regBtn = new JButton("REGISTER");
        regBtn.setBounds(100, 418, 96, 22);
		regBtn.setFont(new Font("Dialog", Font.BOLD , 12));
		regBtn.setBackground(Color.WHITE);
        panel.add(regBtn);

		frame.setSize(315,540);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

}