package book.system.teacher;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.user.UserController;
import book.system.dashboard.DashboardController;

public class TeacherController{
        public static void teacherController(JFrame frame, JPanel loginPanel, String username){
            new TeacherView(frame, loginPanel, username);
        }

        public static void displayDashboard(JFrame frame, JPanel moreInfoPanel, boolean setComponentsEnabled){
            DashboardController.dashboardStudent(frame, moreInfoPanel, setComponentsEnabled);
        }
}