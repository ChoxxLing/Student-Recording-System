package book.system.admin;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.user.UserController;
import book.system.register.RegisterController;
import book.system.dashboard.DashboardController;

public class AdminController {
    private JFrame frame;
    private JPanel loginPanel;
    
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

    public static void displayDashboard(JFrame frame, JPanel adminPanel, boolean setComponentsEnabled) {
        DashboardController.dashboardController(frame, adminPanel, setComponentsEnabled);
    }

    public static void displayDashboardStudent(JFrame frame, JPanel adminPanel, boolean setComponentsEnabled) {
        DashboardController.dashboardStudent(frame, adminPanel, setComponentsEnabled);
    }

}
