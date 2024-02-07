package book.system.fillup;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.user.UserController;


public class FillUpController{
    public static void fillUpController(JFrame frame, JPanel loginPanel, String username){
        new FillUpView(frame, loginPanel, username);

    }

    public static void fillUpTeacher(JFrame frame, JPanel loginPanel, String username){
        new FillupTeacher(frame, loginPanel, username);

    }

}

