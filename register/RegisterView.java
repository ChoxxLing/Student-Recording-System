package book.system.register;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class RegisterView{

	public RegisterView(JFrame frame, JPanel adminPanel) {
                JPanel registerPanel = new JPanel();
                Color adminBackground = new Color(172,207,203);
                LineBorder adminLineBorder =new LineBorder(Color.white, 1, true);

                frame.getContentPane().removeAll();
		frame.getContentPane().add(registerPanel);
		frame.repaint();
		frame.revalidate();
                
                registerPanel.setBackground(adminBackground);
                registerPanel.setBounds(0,0,300,500);
                registerPanel.setLayout(null);

                JLabel adminPic = new JLabel();
                adminPic.setIcon(new ImageIcon("cite.jpg"));
                adminPic.setBounds(93,15,125,124);
                registerPanel.add(adminPic);

                JLabel registerAdminLabel = new JLabel("REGISTER");
                registerAdminLabel.setBounds(35,147,250,44);
                registerAdminLabel.setFont(new Font ("Calibre" , Font.BOLD , 45));
                registerPanel.add(registerAdminLabel);

                JLabel adminLabel = new JLabel("Admin");
                adminLabel.setBounds(105,187,150,44);
                adminLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
                registerPanel.add(adminLabel);

                JTextArea lineadminArea = new JTextArea();
                lineadminArea.setBounds(0,237,300,1);
                lineadminArea.setBackground(new Color(0,0,0));
                lineadminArea.setEditable(false);
                registerPanel.add(lineadminArea);

                JLabel nameadminLabel = new JLabel("Name:");
                nameadminLabel.setBounds(38,255,100,19);
                nameadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerPanel.add(nameadminLabel);

                JTextField nameField = new JTextField();
                nameField.setBounds(38, 274, 224, 18);
                nameField.setBorder(adminLineBorder);
                registerPanel.add(nameField);

                JLabel useradminLabel = new JLabel("Username:");
                useradminLabel.setBounds(38,300,100,19);
                useradminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerPanel.add(useradminLabel);

                JTextField userField = new JTextField();
                userField.setBounds(38, 319, 224, 18);
                userField.setBorder(adminLineBorder);
                registerPanel.add(userField);

                JLabel passadminLabel = new JLabel("Password:");
                passadminLabel.setBounds(38, 346, 224, 18);
                passadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerPanel.add(passadminLabel);

                JPasswordField passField = new JPasswordField();
                passField.setBounds(38, 365, 224, 18);
                passField.setBorder(adminLineBorder);
                registerPanel.add(passField);

                /*JLabel conpassadminLabel = new JLabel("Confirm Password:");
                conpassadminLabel.setBounds(38, 391, 224, 18);
                conpassadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerPanel.add(conpassadminLabel);

                JPasswordField conpassadminField = new JPasswordField();
                conpassadminField.setBounds(38, 411, 224, 18);
                conpassadminField.setBorder(adminLineBorder);
                registerPanel.add(conpassadminField);*/
                
                JButton registerButton = new JButton("REGISTER");
                registerButton.setBounds(166, 448, 96, 22);
                registerButton.setFont(new Font("Dialog", Font.BOLD , 12));
                registerButton.setBackground(Color.WHITE);
                registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				RegisterController.toCreateUser(frame, nameField, userField, passField, adminPanel, 1);
			}	
		});
                registerPanel.add(registerButton);

                JButton backadminBtn = new JButton("BACK");
                backadminBtn.setBounds(38, 448, 96, 22);
                backadminBtn.setFont(new Font("Dialog", Font.BOLD , 12));
                backadminBtn.setBackground(Color.WHITE);
                backadminBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.getContentPane().add(adminPanel);//make it go back to admin panel
				frame.repaint();
				frame.revalidate();
			}	
		});
                registerPanel.add(backadminBtn);

	}

	public static void showRegisterTeacher(JFrame frame, JPanel adminPanel) {
                JPanel registerTeacherPanel = new JPanel();
                Color adminBackground = new Color(172,207,203);
                LineBorder adminLineBorder =new LineBorder(Color.white, 1, true);

                frame.getContentPane().removeAll();
		frame.getContentPane().add(registerTeacherPanel);
		frame.repaint();
		frame.revalidate();
                
                registerTeacherPanel.setBackground(adminBackground);
                registerTeacherPanel.setBounds(0,0,300,500);
                registerTeacherPanel.setLayout(null);

                JLabel adminPic = new JLabel();
                adminPic.setIcon(new ImageIcon("cite.jpg"));
                adminPic.setBounds(93,15,125,124);
                registerTeacherPanel.add(adminPic);

                JLabel registerAdminLabel = new JLabel("REGISTER");
                registerAdminLabel.setBounds(35,147,250,44);
                registerAdminLabel.setFont(new Font ("Calibre" , Font.BOLD , 45));
                registerTeacherPanel.add(registerAdminLabel);

                JLabel adminLabel = new JLabel("Teacher");
                adminLabel.setBounds(105,187,150,44);
                adminLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
                registerTeacherPanel.add(adminLabel);

                JTextArea lineadminArea = new JTextArea();
                lineadminArea.setBounds(0,237,300,1);
                lineadminArea.setBackground(new Color(0,0,0));
                lineadminArea.setEditable(false);
                registerTeacherPanel.add(lineadminArea);

                JLabel nameadminLabel = new JLabel("Name:");
                nameadminLabel.setBounds(38,255,100,19);
                nameadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerTeacherPanel.add(nameadminLabel);

                JTextField nameField = new JTextField();
                nameField.setBounds(38, 274, 224, 18);
                nameField.setBorder(adminLineBorder);
                registerTeacherPanel.add(nameField);

                JLabel useradminLabel = new JLabel("Username:");
                useradminLabel.setBounds(38,300,100,19);
                useradminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerTeacherPanel.add(useradminLabel);

                JTextField userField = new JTextField();
                userField.setBounds(38, 319, 224, 18);
                userField.setBorder(adminLineBorder);
                registerTeacherPanel.add(userField);

                JLabel passadminLabel = new JLabel("Password:");
                passadminLabel.setBounds(38, 346, 224, 18);
                passadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerTeacherPanel.add(passadminLabel);

                JPasswordField passField = new JPasswordField();
                passField.setBounds(38, 365, 224, 18);
                passField.setBorder(adminLineBorder);
                registerTeacherPanel.add(passField);

                /*JLabel conpassadminLabel = new JLabel("Confirm Password:");
                conpassadminLabel.setBounds(38, 391, 224, 18);
                conpassadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerPanel.add(conpassadminLabel);

                JPasswordField conpassadminField = new JPasswordField();
                conpassadminField.setBounds(38, 411, 224, 18);
                conpassadminField.setBorder(adminLineBorder);
                registerPanel.add(conpassadminField);*/
                
                JButton registerButton = new JButton("REGISTER");
                registerButton.setBounds(166, 448, 96, 22);
                registerButton.setFont(new Font("Dialog", Font.BOLD , 12));
                registerButton.setBackground(Color.WHITE);
                registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				RegisterController.toCreateUser(frame, nameField, userField, passField, adminPanel, 2);
			}	
		});
                registerTeacherPanel.add(registerButton);

                JButton backadminBtn = new JButton("BACK");
                backadminBtn.setBounds(38, 448, 96, 22);
                backadminBtn.setFont(new Font("Dialog", Font.BOLD , 12));
                backadminBtn.setBackground(Color.WHITE);
                backadminBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.getContentPane().add(adminPanel);//make it go back to admin panel
				frame.repaint();
				frame.revalidate();
			}	
		});
                registerTeacherPanel.add(backadminBtn);

	}


	public static void showRegisterStudent(JFrame frame, JPanel adminPanel) {
                JPanel registerStudentPanel = new JPanel();
                Color adminBackground = new Color(172,207,203);
                LineBorder adminLineBorder =new LineBorder(Color.white, 1, true);

                frame.getContentPane().removeAll();
		frame.getContentPane().add(registerStudentPanel);
		frame.repaint();
		frame.revalidate();
                
                registerStudentPanel.setBackground(adminBackground);
                registerStudentPanel.setBounds(0,0,300,500);
                registerStudentPanel.setLayout(null);

                JLabel adminPic = new JLabel();
                adminPic.setIcon(new ImageIcon("cite.jpg"));
                adminPic.setBounds(93,15,125,124);
                registerStudentPanel.add(adminPic);

                JLabel registerAdminLabel = new JLabel("REGISTER");
                registerAdminLabel.setBounds(35,147,250,44);
                registerAdminLabel.setFont(new Font ("Calibre" , Font.BOLD , 45));
                registerStudentPanel.add(registerAdminLabel);

                JLabel adminLabel = new JLabel("Student");
                adminLabel.setBounds(105,187,150,44);
                adminLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
                registerStudentPanel.add(adminLabel);

                JTextArea lineadminArea = new JTextArea();
                lineadminArea.setBounds(0,237,300,1);
                lineadminArea.setBackground(new Color(0,0,0));
                lineadminArea.setEditable(false);
                registerStudentPanel.add(lineadminArea);

                JLabel nameadminLabel = new JLabel("Name:");
                nameadminLabel.setBounds(38,255,100,19);
                nameadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerStudentPanel.add(nameadminLabel);

                JTextField nameField = new JTextField();
                nameField.setBounds(38, 274, 224, 18);
                nameField.setBorder(adminLineBorder);
                registerStudentPanel.add(nameField);

                JLabel useradminLabel = new JLabel("Username:");
                useradminLabel.setBounds(38,300,100,19);
                useradminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerStudentPanel.add(useradminLabel);

                JTextField userField = new JTextField();
                userField.setBounds(38, 319, 224, 18);
                userField.setBorder(adminLineBorder);
                registerStudentPanel.add(userField);

                JLabel passadminLabel = new JLabel("Password:");
                passadminLabel.setBounds(38, 346, 224, 18);
                passadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerStudentPanel.add(passadminLabel);

                JPasswordField passField = new JPasswordField();
                passField.setBounds(38, 365, 224, 18);
                passField.setBorder(adminLineBorder);
                registerStudentPanel.add(passField);

                /*JLabel conpassadminLabel = new JLabel("Confirm Password:");
                conpassadminLabel.setBounds(38, 391, 224, 18);
                conpassadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
                registerPanel.add(conpassadminLabel);

                JPasswordField conpassadminField = new JPasswordField();
                conpassadminField.setBounds(38, 411, 224, 18);
                conpassadminField.setBorder(adminLineBorder);
                registerPanel.add(conpassadminField);*/
                
                JButton registerButton = new JButton("REGISTER");
                registerButton.setBounds(166, 448, 96, 22);
                registerButton.setFont(new Font("Dialog", Font.BOLD , 12));
                registerButton.setBackground(Color.WHITE);
                registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				RegisterController.toCreateUser(frame, nameField, userField, passField, adminPanel, 2);
			}	
		});
                registerStudentPanel.add(registerButton);

                JButton backadminBtn = new JButton("BACK");
                backadminBtn.setBounds(38, 448, 96, 22);
                backadminBtn.setFont(new Font("Dialog", Font.BOLD , 12));
                backadminBtn.setBackground(Color.WHITE);
                backadminBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.getContentPane().add(adminPanel);//make it go back to admin panel
				frame.repaint();
				frame.revalidate();
			}	
		});
                registerStudentPanel.add(backadminBtn);

	}

}

