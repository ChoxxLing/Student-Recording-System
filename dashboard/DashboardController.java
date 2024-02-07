package book.system.dashboard;

import javax.swing.*;
import book.system.admin.AdminController;
import book.system.teacher.TeacherController;

public class DashboardController{
	public static void dashboardController(JFrame frame, JPanel adminPanel, Boolean setComponentsEnabled){
		new DashboardView(frame, adminPanel, setComponentsEnabled);
	}

	public static void dashboardStudent(JFrame frame, JPanel adminPanel, Boolean setComponentsEnabled){
		new DashboardStudent(frame, adminPanel, setComponentsEnabled);
	}
}