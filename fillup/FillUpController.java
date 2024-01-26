package book.system.fillup;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.user.UserController;


public class FillUpController{
        public static void fillUpController(JFrame frame, JPanel loginPanel, String username){
            new FillupForm(frame, loginPanel, username);

        }

}