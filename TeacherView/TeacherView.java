package book.system.teacher;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TeacherView{
    TeacherView(JFrame frame, JPanel loginPanel){
        JPanel teacherPanel = new JPanel();
        Color teacherBackground = new Color(112, 9, 203);
        
        teacherPanel.setBackground(teacherBackground);
        teacherPanel.setBounds(0, 0, 315, 540);
        teacherPanel.setLayout(null);
        frame.add(teacherPanel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(teacherPanel);
        frame.repaint();
        frame.revalidate();

        JLabel teacherLabel = new JLabel("Teacher");
        teacherLabel.setBounds(105,187,150,44);
        teacherLabel.setFont(new Font ("Calibre" , Font.BOLD , 35));
        teacherPanel.add(teacherLabel);


        JButton logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBounds(100, 460, 96, 22);
        logoutBtn.setFont(new Font("Dialog", Font.BOLD, 12));
        logoutBtn.setBackground(Color.WHITE);
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(loginPanel);
                    frame.repaint();
                    frame.revalidate();
                }
            }
        });
        teacherPanel.add(logoutBtn);
    }

}