package book.system.register;

import javax.swing.*;
import book.system.user.UserController;

public class RegisterController {
    //private RegisterView view;

    public RegisterController(JFrame frame, JPanel adminRegistrationPanel) {
        new RegisterView(frame, adminRegistrationPanel);
    }

    public static void showRegisterTeacher(JFrame frame, JPanel adminRegistrationPanel) {
        RegisterView.showRegisterTeacher(frame, adminRegistrationPanel);
    }

    public static void showRegisterStudent(JFrame frame, JPanel adminRegistrationPanel) {
        RegisterView.showRegisterStudent(frame, adminRegistrationPanel);
    }

    public static void toCreateUser(JFrame frame, JTextField nameField, JTextField userField, JPasswordField passField, JPanel adminRegistrationPanel, int roleId) {
        UserController.toCreateUser(frame, nameField, userField, passField, adminRegistrationPanel, roleId);
    }
}
