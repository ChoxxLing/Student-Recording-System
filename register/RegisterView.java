package book.system.login;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class RegisterView{

	public static void AdminView() {
		     JFrame adminFrame = new JFrame("Register");
        JPanel adminPanel = new JPanel();
        Color adminBackground = new Color(172,207,203);
        LineBorder adminLineBorder =new LineBorder(Color.white, 1, true);
        
        adminPanel.setBackground(adminBackground);
        adminPanel.setBounds(0,0,300,500);
        adminPanel.setLayout(null);
        adminFrame.add(adminPanel);

        JLabel adminPic = new JLabel();
        adminPic.setIcon(new ImageIcon("cite.jpg"));
        adminPic.setBounds(93,15,125,124);
        adminPanel.add(adminPic);

        JLabel registerAdminLabel = new JLabel("REGISTER");
        registerAdminLabel.setBounds(35,147,250,44);
        registerAdminLabel.setFont(new Font ("Calibre" , Font.BOLD , 45));
        adminPanel.add(registerAdminLabel);

        JLabel adminLabel = new JLabel("Admin");
        adminLabel.setBounds(105,187,150,44);
        adminLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
        adminPanel.add(adminLabel);

        JTextArea lineadminArea = new JTextArea();
        lineadminArea.setBounds(0,237,300,1);
        lineadminArea.setBackground(new Color(0,0,0));
        lineadminArea.setEditable(false);
        adminPanel.add(lineadminArea);

        JLabel nameadminLabel = new JLabel("Name:");
        nameadminLabel.setBounds(38,255,100,19);
        nameadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        adminPanel.add(nameadminLabel);

        JTextField nameadminField = new JTextField();
        nameadminField.setBounds(38, 274, 224, 18);
        nameadminField.setBorder(adminLineBorder);
        adminPanel.add(nameadminField);

        JLabel useradminLabel = new JLabel("Username:");
        useradminLabel.setBounds(38,300,100,19);
        useradminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        adminPanel.add(useradminLabel);

        JTextField useradminField = new JTextField();
        useradminField.setBounds(38, 319, 224, 18);
        useradminField.setBorder(adminLineBorder);
        adminPanel.add(useradminField);

        JLabel passadminLabel = new JLabel("Password:");
        passadminLabel.setBounds(38, 346, 224, 18);
        passadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        adminPanel.add(passadminLabel);

        JPasswordField passadminField = new JPasswordField();
        passadminField.setBounds(38, 365, 224, 18);
        passadminField.setBorder(adminLineBorder);
        adminPanel.add(passadminField);

        JLabel conpassadminLabel = new JLabel("Confirm Password:");
        conpassadminLabel.setBounds(38, 391, 224, 18);
        conpassadminLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        adminPanel.add(conpassadminLabel);

        JPasswordField conpassadminField = new JPasswordField();
        conpassadminField.setBounds(38, 411, 224, 18);
        conpassadminField.setBorder(adminLineBorder);
        adminPanel.add(conpassadminField);
        
        JButton regadminBtn = new JButton("REGISTER");
        regadminBtn.setBounds(166, 448, 96, 22);
        regadminBtn.setFont(new Font("Dialog", Font.BOLD , 12));
        regadminBtn.setBackground(Color.WHITE);
        adminPanel.add(regadminBtn);

        JButton backadminBtn = new JButton("BACK");
        backadminBtn.setBounds(38, 448, 96, 22);
        backadminBtn.setFont(new Font("Dialog", Font.BOLD , 12));
        backadminBtn.setBackground(Color.WHITE);
        adminPanel.add(backadminBtn);

        adminFrame.setSize(315,540);
        adminFrame.setResizable(false);
        adminFrame.setLayout(null);
        adminFrame.setVisible(true);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLocationRelativeTo(null);
	}

	public static void StudentView() {

		 JFrame studentFrame = new JFrame("Register");
        JPanel studentPanel = new JPanel();
        Color studentBackground = new Color(172,207,203);
        LineBorder studentLineBorder =new LineBorder(Color.white, 1, true);
        
        studentPanel.setBackground(studentBackground);
        studentPanel.setBounds(0,0,300,500);
        studentPanel.setLayout(null);
        studentFrame.add(studentPanel);

        JLabel studentPic = new JLabel();
        studentPic.setIcon(new ImageIcon("cite.jpg"));
        studentPic.setBounds(93,15,125,124);
        studentPanel.add(studentPic);

        JLabel registerstudentLabel = new JLabel("REGISTER");
        registerstudentLabel.setBounds(35,147,250,44);
        registerstudentLabel.setFont(new Font ("Calibre" , Font.BOLD , 45));
        studentPanel.add(registerstudentLabel);

        JLabel adminstudentLabel = new JLabel("Student");
        adminstudentLabel.setBounds(90,187,150,44);
        adminstudentLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
        studentPanel.add(adminstudentLabel);

        JTextArea linestudentArea = new JTextArea();
        linestudentArea.setBounds(0,237,300,1);
        linestudentArea.setBackground(new Color(0,0,0));
        linestudentArea.setEditable(false);
        studentPanel.add(linestudentArea);

        JLabel namestudentLabel = new JLabel("Name:");
        namestudentLabel.setBounds(38,255,100,19);
        namestudentLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        studentPanel.add(namestudentLabel);

        JTextField namestudentField = new JTextField();
        namestudentField.setBounds(38, 274, 224, 18);
        namestudentField.setBorder(studentLineBorder);
        studentPanel.add(namestudentField);

        JLabel userstudentLabel = new JLabel("Username:");
        userstudentLabel.setBounds(38,300,100,19);
        userstudentLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        studentPanel.add(userstudentLabel);

        JTextField userstudentField = new JTextField();
        userstudentField.setBounds(38, 319, 224, 18);
        userstudentField.setBorder(studentLineBorder);
        studentPanel.add(userstudentField);

        JLabel passstudentLabel = new JLabel("Password:");
        passstudentLabel.setBounds(38, 346, 224, 18);
        passstudentLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        studentPanel.add(passstudentLabel);

        JPasswordField passstudentField = new JPasswordField();
        passstudentField.setBounds(38, 365, 224, 18);
        passstudentField.setBorder(studentLineBorder);
        studentPanel.add(passstudentField);

        JLabel conpassstudentLabel = new JLabel("Confirm Password:");
        conpassstudentLabel.setBounds(38, 391, 224, 18);
        conpassstudentLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        studentPanel.add(conpassstudentLabel);

        JPasswordField conpassstudentField = new JPasswordField();
        conpassstudentField.setBounds(38, 411, 224, 18);
        conpassstudentField.setBorder(studentLineBorder);
        studentPanel.add(conpassstudentField);
        
        JButton regstudentBtn = new JButton("REGISTER");
        regstudentBtn.setBounds(166, 448, 96, 22);
        regstudentBtn.setFont(new Font("Dialog", Font.BOLD , 12));
        regstudentBtn.setBackground(Color.WHITE);
        studentPanel.add(regstudentBtn);

        JButton backstudentBtn = new JButton("BACK");
        backstudentBtn.setBounds(38, 448, 96, 22);
        backstudentBtn.setFont(new Font("Dialog", Font.BOLD , 12));
        backstudentBtn.setBackground(Color.WHITE);
        studentPanel.add(backstudentBtn);

        studentFrame.setSize(315,540);
        studentFrame.setResizable(false);
        studentFrame.setLayout(null);
        studentFrame.setVisible(true);
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setLocationRelativeTo(null);

	}

	public static void TeacherView() {

		JFrame teacherFrame = new JFrame("Register");
        JPanel teacherPanel = new JPanel();
        Color teacherBackground = new Color(172,207,203);
        LineBorder teacherLineBorder =new LineBorder(Color.white, 1, true);
        
        teacherPanel.setBackground(teacherBackground);
        teacherPanel.setBounds(0,0,300,500);
        teacherPanel.setLayout(null);
        teacherFrame.add(teacherPanel);

        JLabel teacherPic = new JLabel();
        teacherPic.setIcon(new ImageIcon("cite.jpg"));
        teacherPic.setBounds(93,15,125,124);
        teacherPanel.add(teacherPic);

        JLabel registerteacherLabel = new JLabel("REGISTER");
        registerteacherLabel.setBounds(35,147,250,44);
        registerteacherLabel.setFont(new Font ("Calibre" , Font.BOLD , 45));
        teacherPanel.add(registerteacherLabel);

        JLabel adminteacherLabel = new JLabel("Teacher");
        adminteacherLabel.setBounds(90,187,150,44);
        adminteacherLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
        teacherPanel.add(adminteacherLabel);

        JTextArea lineteacherArea = new JTextArea();
        lineteacherArea.setBounds(0,237,300,1);
        lineteacherArea.setBackground(new Color(0,0,0));
        lineteacherArea.setEditable(false);
        teacherPanel.add(lineteacherArea);

        JLabel nameteacherLabel = new JLabel("Name:");
        nameteacherLabel.setBounds(38,255,100,19);
        nameteacherLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        teacherPanel.add(nameteacherLabel);

        JTextField nameteacherField = new JTextField();
        nameteacherField.setBounds(38, 274, 224, 18);
        nameteacherField.setBorder(teacherLineBorder);
        teacherPanel.add(nameteacherField);

        JLabel userteacherLabel = new JLabel("Username:");
        userteacherLabel.setBounds(38,300,100,19);
        userteacherLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        teacherPanel.add(userteacherLabel);

        JTextField userteacherField = new JTextField();
        userteacherField.setBounds(38, 319, 224, 18);
        userteacherField.setBorder(teacherLineBorder);
        teacherPanel.add(userteacherField);

        JLabel passteacherLabel = new JLabel("Password:");
        passteacherLabel.setBounds(38, 346, 224, 18);
        passteacherLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        teacherPanel.add(passteacherLabel);

        JPasswordField passteacherField = new JPasswordField();
        passteacherField.setBounds(38, 365, 224, 18);
        passteacherField.setBorder(teacherLineBorder);
        teacherPanel.add(passteacherField);

        JLabel conpassteacherLabel = new JLabel("Confirm Password:");
        conpassteacherLabel.setBounds(38, 391, 224, 18);
        conpassteacherLabel.setFont(new Font("Dialog", Font.BOLD , 15));
        teacherPanel.add(conpassteacherLabel);

        JPasswordField conpassteacherField = new JPasswordField();
        conpassteacherField.setBounds(38, 411, 224, 18);
        conpassteacherField.setBorder(teacherLineBorder);
        teacherPanel.add(conpassteacherField);
        
        JButton regteacherBtn = new JButton("REGISTER");
        regteacherBtn.setBounds(166, 448, 96, 22);
        regteacherBtn.setFont(new Font("Dialog", Font.BOLD , 12));
        regteacherBtn.setBackground(Color.WHITE);
        teacherPanel.add(regteacherBtn);

        JButton backteacherBtn = new JButton("BACK");
        backteacherBtn.setBounds(38, 448, 96, 22);
        backteacherBtn.setFont(new Font("Dialog", Font.BOLD , 12));
        backteacherBtn.setBackground(Color.WHITE);
        teacherPanel.add(backteacherBtn);

        teacherFrame.setSize(315,540);
        teacherFrame.setResizable(false);
        teacherFrame.setLayout(null);
        teacherFrame.setVisible(true);
        teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teacherFrame.setLocationRelativeTo(null);

	}
}