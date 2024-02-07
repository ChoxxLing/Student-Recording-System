package book.system.student;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.user.UserController;


public class StudentController{
        public static void studentController(JFrame frame, JPanel loginPanel, String username){
            new StudentView(frame, loginPanel, username);
        }

}