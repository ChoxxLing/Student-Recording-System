package book.system.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UserModel{
    private JFrame frame;
    private JPanel loginPanel;
    
    public UserModel(JFrame frame, JPanel loginPanel){
        this.frame = frame;
        this.loginPanel = loginPanel;
    }
    
    public static void toCreateUser(JFrame frame, JTextField nameField, JTextField userField, JPasswordField passField, JPanel loginPanel, int roleId) {
    String name = nameField.getText();
    String username = userField.getText();
    char[] password = passField.getPassword();

    if (name.isEmpty() || username.isEmpty() || password.length == 0) {
        JOptionPane.showMessageDialog(frame, "Please fill in all the fields");
        return;
    }

    // Check if the user already exists
    if (userExists(username, new String(password))) {
        //int existingRoleId = getUserRole(username, new String(password));
        JOptionPane.showMessageDialog(frame, "User already exists");
        return;
    }

    try (FileWriter fwrite = new FileWriter("C:\\Users\\Administrator\\Documents\\project\\database\\users.dat", true)) {
        fwrite.write(name + ":" + username + ":" + new String(password) + ":" + roleId + System.lineSeparator());
        JOptionPane.showMessageDialog(frame, "Register successfully");

        frame.getContentPane().removeAll();
        frame.getContentPane().add(loginPanel);
        frame.repaint();
        frame.revalidate();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(frame, "Failed to register");
        e.printStackTrace();
    }
}

// Add this method to check if the user already exists
private static boolean userExists(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Documents\\project\\database\\users.dat"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            
            // Ensure that the line has at least three parts (name, username, password)
            if (parts.length >= 3) {
                String savedUsername = parts[1].trim();
                String savedPassword = parts[2].trim();

                if (savedUsername.equals(username) && savedPassword.equals(password)) {
                    return true;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}


    
    public static void ifUserExist(JFrame frame, JPanel loginPanel, JTextField usernameField, JPasswordField passwordField) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    // Check for the admin account
    if (username.equals("admin") && password.equals("admin")) {
        JOptionPane.showMessageDialog(frame, "Welcome, Admin!");
        UserController.toAdminView(frame, loginPanel);
        // Additional actions for the admin, if needed
    } else {
        int userRole = getUserRole(username, password);

        if (userRole == 1) {
            // Admin role
            JOptionPane.showMessageDialog(frame, "Welcome, Admin!");
            UserController.toAdminView(frame, loginPanel);

            
           
        } else if (userRole == 2) {
            // Teacher role
            JOptionPane.showMessageDialog(frame, "Welcome, Teacher!");
            UserController.toTeacherView(frame, loginPanel);


            // Add logic to go to TeacherView
        } else if (userRole == 3) {
            // Student role
            JOptionPane.showMessageDialog(frame, "Welcome, Student!");
            UserController.toStudentView(frame, loginPanel);
            

        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password");
        }

    usernameField.setText("");
    passwordField.setText("");
    
    }
}

private static int getUserRole(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Documents\\project\\database\\users.dat"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            
            // Ensure that the line has at least four parts (name, username, password, roleId)
            if (parts.length >= 4) {
                String savedUsername = parts[1].trim();
                String savedPassword = parts[2].trim();

                if (savedUsername.equals(username) && savedPassword.equals(password)) {
                    return Integer.parseInt(parts[3].trim());
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return -1; // User not found
}

}


