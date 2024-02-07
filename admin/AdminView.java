package book.system.admin;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdminView{
    AdminView(JFrame frame, JPanel loginPanel){
        JPanel adminPanel = new JPanel();
        Color adminBackground = new Color(172, 207, 203);
        LineBorder adminLineBorder = new LineBorder(Color.white, 1, true);



        adminPanel.setBackground(adminBackground);
        adminPanel.setBounds(0, 0, 315, 540);
        adminPanel.setLayout(null);
        frame.add(adminPanel);

        frame.getContentPane().removeAll();
		frame.getContentPane().add(adminPanel);
		frame.repaint();
		frame.revalidate();

        JLabel adminPic = new JLabel();
        adminPic.setIcon(new ImageIcon("pictures\\cite.jpg"));
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

        
        Choice roleChoice = new Choice();
        //roleChoice.add("Admin"); //nindot unta 1 sa ato adminaccount kay para iya ma manage teacher ra ug student
        roleChoice.add("Teacher");
        roleChoice.add("Student");
        roleChoice.setBounds(38, 274, 224, 18);
        roleChoice.setFont(new Font("Dialog", Font.PLAIN, 12));
        adminPanel.add(roleChoice);

        // Button to confirm the choice
        JButton confirmChoiceBtn = new JButton("Confirm Choice");
        confirmChoiceBtn.setBounds(38, 300, 150, 22);
        confirmChoiceBtn.setBorder(adminLineBorder);
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



        Choice createaccRoleChoice = new Choice();
        createaccRoleChoice.add("Create (Teacher) Account");
        createaccRoleChoice.add("Create (Student) Account");
        createaccRoleChoice.add("Create (Admin) Account"); // mo craete siya ug admin acount //pero dli pa kay siya complete
        createaccRoleChoice.setBounds(38, 389, 224, 18);
        createaccRoleChoice.setFont(new Font("Dialog", Font.PLAIN, 12));
        adminPanel.add(createaccRoleChoice);

        
        JButton anotherConfirmChoiceBtn = new JButton("Confirm Choice");
        anotherConfirmChoiceBtn.setBounds(38, 415, 150, 22);
        anotherConfirmChoiceBtn.setBorder(adminLineBorder);
        anotherConfirmChoiceBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        anotherConfirmChoiceBtn.setBackground(Color.WHITE);
        adminPanel.add(anotherConfirmChoiceBtn);

        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(100, 460, 96, 22);
        logoutBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        logoutBtn.setBackground(Color.WHITE);
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(loginPanel);
                    frame.repaint();
                    frame.revalidate();
                }
            }
        });
        adminPanel.add(logoutBtn);


        // ActionListener for the confirm button
        confirmChoiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check the selected item in the Choice component
                String selectedRole = roleChoice.getSelectedItem();
                switch (selectedRole) {
                    case "Admin":
                        //adminPanel.setBackground(Color.YELLOW);
                       // break;
                    case "Teacher":
                        System.out.println("opening the dashboard");
                        setComponentsEnabled(frame, false);
                        AdminController.displayDashboard(frame, adminPanel, false);
                        break;
                    case "Student":
                        //adminPanel.setBackground(Color.BLUE);
                        System.out.println("opening the dashboard studnet");
                        setComponentsEnabled(frame, false);
                        AdminController.displayDashboardStudent(frame, adminPanel, false);
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

    private static void setComponentsEnabled(Container container, boolean enabled) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                setComponentsEnabled((Container) component, enabled);
            }
            component.setEnabled(enabled);
        }
    }


}