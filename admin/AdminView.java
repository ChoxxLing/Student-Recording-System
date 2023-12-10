package book.system.admin;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdminView{
    AdminView(JFrame frame, JPanel loginPanel){
        JPanel adminPanel = new JPanel();
        Color adminBackground = new Color(172, 207, 203);
        //LineBorder adminLineBorder = new LineBorder(Color.white, 1, true);
        //fix the line border


        adminPanel.setBackground(adminBackground);
        adminPanel.setBounds(0, 0, 300, 500);
        adminPanel.setLayout(null);
        frame.add(adminPanel);

        frame.getContentPane().removeAll();
		frame.getContentPane().add(adminPanel);
		frame.repaint();
		frame.revalidate();

        JLabel adminPic = new JLabel();
        adminPic.setIcon(new ImageIcon("cite.jpg"));
        adminPic.setBounds(93, 15, 125, 124);
        adminPanel.add(adminPic);

        JLabel registerAdminLabel = new JLabel("MANAGER");
        registerAdminLabel.setBounds(35, 147, 250, 44);
        registerAdminLabel.setFont(new Font("Calibre", Font.BOLD, 45));
        adminPanel.add(registerAdminLabel);

        JLabel adminLabel = new JLabel("(Admin)");
        adminLabel.setBounds(90, 187, 150, 44);
        adminLabel.setFont(new Font("Calibre", Font.BOLD, 35));
        adminPanel.add(adminLabel);

        JTextArea lineadminArea = new JTextArea();
        lineadminArea.setBounds(0, 237, 300, 1);
        lineadminArea.setBackground(new Color(0, 0, 0));
        lineadminArea.setEditable(false);
        adminPanel.add(lineadminArea);

        JLabel manageRoles = new JLabel("Manage Roles:");
        manageRoles.setBounds(38, 250, 100, 18);
        manageRoles.setFont(new Font("Dialog", Font.BOLD, 13));
        adminPanel.add(manageRoles);

        // Replace JTextField with AWT Choice
        Choice roleChoice = new Choice();
        roleChoice.add("Admin");
        roleChoice.add("Teacher");
        roleChoice.add("Student");
        roleChoice.setBounds(38, 274, 224, 18);
        roleChoice.setFont(new Font("Dialog", Font.PLAIN, 12));
        adminPanel.add(roleChoice);

        // Button to confirm the choice
        JButton confirmChoiceBtn = new JButton("Confirm Choice");
        confirmChoiceBtn.setBounds(38, 300, 150, 22);
        confirmChoiceBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        confirmChoiceBtn.setBackground(Color.WHITE);
        adminPanel.add(confirmChoiceBtn);

        JTextArea lineadminArea2 = new JTextArea();
        lineadminArea2.setBounds(0, 350, 300, 1);
        lineadminArea2.setBackground(new Color(0, 0, 0));
        lineadminArea2.setEditable(false);
        adminPanel.add(lineadminArea2);

        JLabel createAccount = new JLabel("Create Account:");
        createAccount.setBounds(38, 365, 150, 18);
        createAccount.setFont(new Font("Dialog", Font.BOLD, 13));
        adminPanel.add(createAccount);


        // Another AWT Choice beneath lineadminArea2
        Choice createaccRoleChoice = new Choice();
        createaccRoleChoice.add("Create (Teacher) Account");
        createaccRoleChoice.add("Create (Student) Account");
        createaccRoleChoice.add("Create (Admin) Account");
        createaccRoleChoice.setBounds(38, 389, 224, 18);
        createaccRoleChoice.setFont(new Font("Dialog", Font.PLAIN, 12));
        adminPanel.add(createaccRoleChoice);

        // Buttons beneath lineadminArea2
        JButton anotherConfirmChoiceBtn = new JButton("Confirm Choice");
        anotherConfirmChoiceBtn.setBounds(38, 415, 150, 22);
        anotherConfirmChoiceBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        anotherConfirmChoiceBtn.setBackground(Color.WHITE);
        adminPanel.add(anotherConfirmChoiceBtn);

        JButton backadminBtn = new JButton("LOGOUT");
        backadminBtn.setBounds(100, 460, 96, 22);
        backadminBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        backadminBtn.setBackground(Color.WHITE);
        backadminBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.getContentPane().removeAll();
				frame.getContentPane().add(loginPanel);
				frame.repaint();
				frame.revalidate(); 
				
			}	
		});
        adminPanel.add(backadminBtn);


        // ActionListener for the confirm button
        confirmChoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the selected item in the Choice component
                String selectedRole = roleChoice.getSelectedItem();
                switch (selectedRole) {
                    case "Admin":
                        //adminPanel.setBackground(Color.YELLOW);
                        break;
                    case "Teacher":
                        //adminPanel.setBackground(Color.RED);
                        break;
                    case "Student":
                        //adminPanel.setBackground(Color.BLUE);
                        break;
                }
            }
        });

        // ActionListener for another confirm button
        anotherConfirmChoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the selected item in the Choice component
                String selectedRole = createaccRoleChoice.getSelectedItem();
                // Add your logic for handling the role choice here
                   switch (selectedRole) {
                    case "Create (Teacher) Account":
                        AdminController.showRegisterTeacher(frame, adminPanel);
                        break;
                    case "Create (Student) Account":
                        AdminController.showRegisterStudent(frame, adminPanel);
                        break;
                    case "Create (Admin) Account":
                        AdminController.displayRegisterView(frame, adminPanel);
                        break;
                }
            }
        });

        
    }

}