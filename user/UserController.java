package book.system.user;

import javax.swing.*;
import book.system.login.LoginController;
import book.system.admin.AdminController;
import book.system.student.StudentController;
import book.system.teacher.TeacherController;
import book.system.fillup.FillUpController;

public class UserController{
	private JFrame frame;
	private JPanel loginPanel;

	public UserController(JFrame frame, JPanel loginPanel){
		this.frame = frame;
		this.loginPanel = loginPanel;
		new UserModel(this.frame, this.loginPanel);
	}
	
	public static void ifUserExist(JFrame frame, JPanel loginPanel, JTextField usernameField, JPasswordField passwordField){
		UserModel.ifUserExist(frame, loginPanel,usernameField, passwordField);
	}
	
	public static void toCreateUser(JFrame frame, JTextField nameField, JTextField userField, JPasswordField passField, JPanel loginPanel, int roleId){
		UserModel.toCreateUser(frame, nameField, userField, passField, loginPanel, roleId);
	}

	public static void toAdminView(JFrame frame, JPanel loginPanel){
		AdminController.adminController(frame, loginPanel);
	}

	public static void toStudentView(JFrame frame, JPanel loginPanel, String username){
		StudentController.studentController(frame, loginPanel, username);
	}

	public static void toTeacherView(JFrame frame, JPanel loginPanel, String username){
		TeacherController.teacherController(frame, loginPanel, username);
	}

	public static void tofillUpFormStudent(JFrame frame, JPanel loginPanel, String username){
		FillUpController.fillUpController(frame, loginPanel, username);
	}

	public static void tofillUpFormTeacher(JFrame frame, JPanel loginPanel, String username){
		FillUpController.fillUpTeacher(frame, loginPanel, username);
	}
}

