package book.system.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdminView{
    AdminView(JFrame frame, JPanel loginPanel){
        JPanel adminPanel = new JPanel();
		adminPanel.setBounds(0, 0, 380, 400);
		adminPanel.setBackground(Color.CYAN);
		adminPanel.setLayout(null);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(adminPanel);
		frame.repaint();
		frame.revalidate();

        JLabel adminLabel = new JLabel("ADMIN");
		adminLabel.setBounds(10, 10, 500, 40);
		adminLabel.setFont(new Font("Arial", Font.BOLD, 25));
		adminPanel.add(adminLabel);

		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(265, 330, 100, 30);
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.getContentPane().add(loginPanel);
				frame.repaint();
				frame.revalidate(); 
				
			}	
		});
		adminPanel.add(logoutButton);

        JButton registerButton = new JButton("Register Account");
		registerButton.setBounds(10, 255, 350, 30);
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JPanel adminRegistrationPanel = new JPanel();
				adminRegistrationPanel.setBounds(0, 0, 380, 400);
				adminRegistrationPanel.setBackground(Color.YELLOW);
				adminRegistrationPanel.setLayout(null);
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(adminRegistrationPanel);
				frame.repaint();
				frame.revalidate();

				JLabel adminLabel = new JLabel("REGISTER");
				adminLabel.setBounds(10, 10, 500, 40);
				adminLabel.setFont(new Font("Arial", Font.BOLD, 25));
				adminRegistrationPanel.add(adminLabel);

						JButton registerAdminButton = new JButton("Register Admin");
						registerAdminButton.setBounds(10, 115, 350, 30);
						registerAdminButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
								AdminController.displayRegisterView(frame, adminRegistrationPanel);
							}	
						});
						adminRegistrationPanel.add(registerAdminButton);

						JButton registerTeacherButton = new JButton("Register Teacher");
						registerTeacherButton.setBounds(10, 200, 350, 30);
						registerTeacherButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
								AdminController.showRegisterTeacher(frame, adminRegistrationPanel);
							}	
						});
						adminRegistrationPanel.add(registerTeacherButton);

						JButton registerStudentButton = new JButton("Register Student");
						registerStudentButton.setBounds(10, 290, 350, 30);
						registerStudentButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
								AdminController.showRegisterStudent(frame, adminRegistrationPanel);
							}	
						});
						adminRegistrationPanel.add(registerStudentButton);

						JButton cancelButton = new JButton("Cancel");
						cancelButton.setBounds(160, 320, 100, 30);
						cancelButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
						frame.getContentPane().removeAll();
						frame.getContentPane().add(adminPanel);//make it go back to admin panel
						frame.repaint();
						frame.revalidate();
			}	
		});
		adminRegistrationPanel.add(cancelButton);

			}	
		});
		adminPanel.add(registerButton);


    }

}