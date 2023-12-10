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

    try (FileWriter fwrite = new FileWriter("C:\\Users\\Admin\\Desktop\\github\\Student-Recording-System\\database\\users.dat", true)) {
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
	
	public static boolean readUser(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\github\\Student-Recording-System\\database\\users.dat"))) {
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
        } else if (readUser(username, password)) {
            // Check if the user exists (excluding admin)
            UserController.displayWelcomeView(frame, loginPanel);
            usernameField.setText("");
            passwordField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password");
        }
    }
}