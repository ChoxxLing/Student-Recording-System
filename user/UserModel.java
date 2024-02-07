package book.system.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UserModel{
        private JFrame frame;
        private JPanel loginPanel;

        public UserModel(JFrame frame, JPanel loginPanel) {
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
            JOptionPane.showMessageDialog(frame, "User already exists");
            return;
        }

        // Check if the username is already in use
        if (usernameAlreadyInUse(username)) {
            JOptionPane.showMessageDialog(frame, "Username already in use. Please choose a different one.");
            return;
        }

         try (FileWriter fwrite = new FileWriter("database\\users.dat", true)) {
            fwrite.write(name + ":" + username + ":" + new String(password) + ":" + roleId + System.lineSeparator());
            JOptionPane.showMessageDialog(frame, "Register successfully");

            // Check roleId and save to respective files
            if (roleId == 2) {
                saveUserDetailsToFile("database\\teachers.dat", name + ":" + username + ":" + new String(password) + ":" + roleId + System.lineSeparator());
                System.out.println("saved also to teachers.dat");
            } else if (roleId == 3) {
                saveUserDetailsToFile("database\\students.dat", name + ":" + username + ":" + new String(password) + ":" + roleId + System.lineSeparator());
                System.out.println("saved also to students.dat");
            }

            frame.getContentPane().removeAll();
            frame.getContentPane().add(loginPanel);
            frame.repaint();
            frame.revalidate();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Failed to register");
            e.printStackTrace();
        }
    }


    private static boolean usernameAlreadyInUse(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\users.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");

                // Ensure that the line has at least two parts (username, password)
                if (parts.length >= 2) {
                    String savedUsername = parts[1].trim();

                    if (savedUsername.equals(username)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean userExists(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\users.dat"))) {
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


    private static void saveUserDetailsToFile(String filePath, String userDetails) {
        try (FileWriter fwrite = new FileWriter(filePath, true)) {
            fwrite.write(userDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

            if (userRole == -1) {
                JOptionPane.showMessageDialog(frame, "Invalid username or password");
            } else {
                // Check if the user exists
                if (userExists(username, password)) {
                    // Check if the user has details
                    if (hasUserDetails(username, userRole)) {
                        if (userRole == 2) {
                            // Open fillupformteacher
                            JOptionPane.showMessageDialog(frame, "Fill all the details first!");
                            System.out.println("Open fillupformteacher");
                            
                             UserController.tofillUpFormTeacher(frame, loginPanel, username);
                             
                            } else if (userRole == 3) {
                                // Open fillupformstudent
                                JOptionPane.showMessageDialog(frame, "Fill all the details first!");
                                System.out.println("Open fillupformstudent");
                                
                                UserController.tofillUpFormStudent(frame, loginPanel, username);
                                        
                            } else {
                                // Handle other roles or show a generic message
                                System.out.println("User role not supported for filling up details");
                                    }
                                } else {
                                    // If the user has details, proceed to the respective user view
                                    switch (userRole) {
                                        case 1:
                                            // Admin role
                                            JOptionPane.showMessageDialog(frame, "Welcome, Admin!");
                                            UserController.toAdminView(frame, loginPanel);
                                            break;
                                        case 2:
                                            // Teacher role
                                            //JOptionPane.showMessageDialog(frame, "Welcome, Teacher!");
                                            UserController.toTeacherView(frame, loginPanel, username);
                                            break;
                                        case 3:
                                            // Student role
                                            //JOptionPane.showMessageDialog(frame, "Welcome, Student!");
                                            UserController.toStudentView(frame, loginPanel, username);
                                            break;
                                        default:
                                            break;
                                    }
                                }

                                // Reset text fields
                                usernameField.setText("");
                                passwordField.setText("");
                            } else  {
                                JOptionPane.showMessageDialog(frame, "User does not exist");
                            }
                    }
                }
    }




    private static int getUserRole(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("database\\users.dat"))) {
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

    private static boolean hasUserDetails(String username, int userRole) {
        // Check roleId and corresponding file for details
        String filePath = (userRole == 2) ? "database\\teachers.dat" : (userRole == 3) ? "database\\students.dat" : "";

        if (!filePath.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 4 && parts[1].trim().equals(username)) {
                    System.out.println("User lacks details");  
                    return true;
                }
            }
                System.out.println("User found with details");
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error reading the file");
                return false;
            }
        } else {
            System.out.println("ADMIN user role");
            return false;
        }
    }



}




