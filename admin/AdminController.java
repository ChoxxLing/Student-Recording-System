package book.system.admin;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.user.UserController;
import book.system.register.RegisterController;

public class AdminController {
    private JFrame frame;
    private JPanel loginPanel;
   // private RegisterController register;
    
    public static void adminController(JFrame frame, JPanel loginPanel) {
        new AdminView(frame, loginPanel);
    }

    public static void displayRegisterView(JFrame frame, JPanel adminPanel) {
        new RegisterController(frame, adminPanel);
    }

    public static void showRegisterTeacher(JFrame frame, JPanel adminPanel) {
        RegisterController.showRegisterTeacher(frame, adminPanel);
    }

    public static void showRegisterStudent(JFrame frame, JPanel adminPanel) {
        RegisterController.showRegisterStudent(frame, adminPanel);
    }

}
