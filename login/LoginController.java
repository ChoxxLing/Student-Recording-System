package book.system.login;

import javax.swing.*;
import book.system.user.UserController;
import book.system.register.RegisterController;
import book.system.dashboard.DashboardController;

public class LoginController{
private JFrame frame;
private JPanel loginPanel;
public LoginController(JFrame frame, JPanel loginPanel){
this.frame = frame;
this.loginPanel = loginPanel;
new LoginView(this.frame, this.loginPanel);
}