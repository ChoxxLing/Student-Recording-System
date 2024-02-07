package book.system.register;

import javax.swing.*;
import book.system.user.UserController;

public class RegisterController {
    //private RegisterView view;

    public RegisterController(JFrame frame, JPanel adminPanel) {
        new RegisterView(frame, adminPanel);
    }

    public static void showRegisterTeacher(JFrame frame, JPanel adminPanel) {
        RegisterView.showRegisterTeacher(frame, adminPanel);
    }

    public static void showRegisterStudent(JFrame frame, JPanel adminPanel) {
        RegisterView.showRegisterStudent(frame, adminPanel);
    }

    public static void toCreateUser(JFrame frame, JTextField nameField, JTextField userField, JPasswordField passField, JPanel adminPanel, int roleId) {
        UserController.toCreateUser(frame, nameField, userField, passField, adminPanel, roleId);
    }
}
