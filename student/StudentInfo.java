import javax.swing.*;
import java.awt.*;

public class StudentInfo {
    public static void main(String args[]) {

        JFrame infoFrame = new JFrame("Student Information");
        JPanel mainPanel = createMainPanel(infoFrame);

        infoFrame.setSize(315, 540);
        infoFrame.setResizable(false);
        infoFrame.setLayout(null);
        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        infoFrame.setLocationRelativeTo(null);

        infoFrame.add(mainPanel);

        infoFrame.setVisible(true);
    }

    private static JPanel createMainPanel(JFrame infoFrame) {
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawLine(g, 10, 260, 290, 260);
                drawLine(g, 10, 290, 290, 290);
                drawLine(g, 10, 320, 290, 320);
                drawLine(g, 10, 350, 290, 350);
                drawLine(g, 10, 380, 290, 380);
            }
        };

        mainPanel.setBackground(new Color(172, 207, 203));
        mainPanel.setBounds(0, 0, 315, 500);
        mainPanel.setLayout(null);

        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("cite.jpg"));
        pic.setBounds(100, 30, 150, 150);
        mainPanel.add(pic);

        JLabel infoLabel = new JLabel("STUDENT's INFORMATION");
        infoLabel.setBounds(45, 200, 250, 30);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(infoLabel);

        JTextArea lineArea = new JTextArea();
        lineArea.setBounds(0, 240, 315, 1);
        lineArea.setBackground(new Color(0, 0, 0));
        lineArea.setEditable(false);
        mainPanel.add(lineArea);

        JLabel studentNameLabel = new JLabel("Student's Name:");
        studentNameLabel.setBounds(10, 260, 120, 20);
        studentNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(studentNameLabel);

        JLabel studentNameValue = new JLabel("John Doe");
        studentNameValue.setBounds(120, 260, 150, 20);
        mainPanel.add(studentNameValue);

        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(10, 290, 100, 20);
        sectionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(sectionLabel);

        JLabel sectionValue = new JLabel("A1");
        sectionValue.setBounds(120, 290, 150, 20);
        mainPanel.add(sectionValue);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(10, 320, 100, 20);
        departmentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(departmentLabel);

        JLabel departmentValue = new JLabel("Science");
        departmentValue.setBounds(120, 320, 150, 20);
        mainPanel.add(departmentValue);

        JLabel batchLabel = new JLabel("Batch:");
        batchLabel.setBounds(10, 350, 100, 20);
        batchLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(batchLabel);

        JLabel batchValue = new JLabel("2023");
        batchValue.setBounds(120, 350, 150, 20);
        mainPanel.add(batchValue);

        JLabel idNoLabel = new JLabel("ID No.:");
        idNoLabel.setBounds(10, 380, 100, 20);
        idNoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(idNoLabel);

        JLabel idNoValue = new JLabel("123456");
        idNoValue.setBounds(120, 380, 150, 20);
        mainPanel.add(idNoValue);

        JButton moreInfoButton = new JButton("More Information");
        moreInfoButton.setBounds(80, 430, 150, 30);
        moreInfoButton.setBackground(new Color(255, 255, 255));
        moreInfoButton.setFocusPainted(false);
        moreInfoButton.addActionListener(e -> showMoreInformation(mainPanel, infoFrame));
        mainPanel.add(moreInfoButton);

        return mainPanel;
    }

    private static void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    private static void showMoreInformation(JPanel mainPanel, JFrame infoFrame) {
        JPanel moreInfoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawLine(g, 10, 260, 290, 260);
                drawLine(g, 10, 290, 290, 290);
                drawLine(g, 10, 320, 290, 320);
            }
        };

        moreInfoPanel.setBackground(new Color(172, 207, 203));
        moreInfoPanel.setLayout(null);

        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("cite.jpg"));
        pic.setBounds(100, 30, 150, 150);
        moreInfoPanel.add(pic);

        JLabel infoLabel = new JLabel("STUDENT's INFORMATION");
        infoLabel.setBounds(45, 200, 250, 30);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        moreInfoPanel.add(infoLabel);

        JTextArea lineArea = new JTextArea();
        lineArea.setBounds(0, 240, 315, 1);
        lineArea.setBackground(new Color(0, 0, 0));
        lineArea.setEditable(false);
        moreInfoPanel.add(lineArea);

        JLabel subjectsLabel = new JLabel("Subjects:");
        subjectsLabel.setBounds(10, 260, 80, 20);
        subjectsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        moreInfoPanel.add(subjectsLabel);

        JLabel subjectsValue = new JLabel("Math, Physics");
        subjectsValue.setBounds(120, 260, 150, 20);
        moreInfoPanel.add(subjectsValue);

        JLabel birthdayLabel = new JLabel("Birthday:");
        birthdayLabel.setBounds(10, 290, 80, 20);
        birthdayLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        moreInfoPanel.add(birthdayLabel);

        JLabel birthdayValue = new JLabel("January 1, 2000");
        birthdayValue.setBounds(120, 290, 150, 20);
        moreInfoPanel.add(birthdayValue);

        JLabel gradesLabel = new JLabel("Grades:");
        gradesLabel.setBounds(10, 320, 80, 20);
        gradesLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        moreInfoPanel.add(gradesLabel);

        JLabel gradesValue = new JLabel("Math (A), Physics (B)");
        gradesValue.setBounds(120, 320, 150, 20);
        moreInfoPanel.add(gradesValue);

        JButton closeInfoButton = new JButton("Close");
        closeInfoButton.setBounds(80, 430, 150, 30);
        closeInfoButton.setBackground(new Color(255, 255, 255));
        closeInfoButton.setFocusPainted(false);
        closeInfoButton.addActionListener(e -> {
            infoFrame.remove(moreInfoPanel);
            mainPanel.setVisible(true);
            infoFrame.repaint();
            infoFrame.revalidate();
        });
        moreInfoPanel.add(closeInfoButton);

        moreInfoPanel.setBounds(0, 0, 315, 500);
        infoFrame.add(moreInfoPanel);
        mainPanel.setVisible(false);
        infoFrame.repaint();
        infoFrame.revalidate();
    }
}
