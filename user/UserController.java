package book.system.user;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.admin.AdminController;

public class UserController{
	private JFrame frame;
	private JPanel loginPanel;
	//private AdminController admin;

	public UserController(JFrame frame, JPanel loginPanel){
		this.frame = frame;
		this.loginPanel = loginPanel;
		new UserModel(this.frame, this.loginPanel);
	}
	
	public static void ifUserExist(JFrame frame, JPanel loginPanel, JTextField usernameField, JPasswordField passwordField){
		UserModel.ifUserExist(frame, loginPanel,usernameField, passwordField);
	}
	
	public static void displayWelcomeView(JFrame frame, JPanel loginPanel){
		LoginController.displayWelcomeView(frame, loginPanel);
	}
	
	public static void toCreateUser(JFrame frame, JTextField nameField, JTextField userField, JPasswordField passField, JPanel loginPanel, int roleId){
		UserModel.toCreateUser(frame, nameField, userField, passField, loginPanel, roleId);
	}

	public static void toAdminView(JFrame frame, JPanel loginPanel){
		AdminController.adminController(frame, loginPanel);
	}
}