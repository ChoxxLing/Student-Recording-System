package book.system.student;

import java.util.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class StudentView {
	private JLabel studentNameValue;
    private JLabel sectionValue;
    private JLabel departmentValue;
    private JLabel batchValue;
    private JLabel idNoValue;
	private JLabel emailValue = new JLabel();
	private JLabel birthdayValue = new JLabel();
	private JLabel phoneValue = new JLabel();
    private JLabel gradeValue = new JLabel();
	private JFrame frame; 

	
	StudentView(JFrame frame, JPanel loginPanel, String username) {
		JPanel studentPanel = new JPanel();
		Color studentBackground = new Color(172, 207, 203);
		studentPanel.setBackground(studentBackground);
		studentPanel.setBounds(0, 0, 315, 540);
		studentPanel.setLayout(null);
		frame.add(studentPanel);

		frame.getContentPane().removeAll();
		frame.getContentPane().add(studentPanel);
		frame.repaint();
		frame.revalidate();
		
        departmentValue = new JLabel();
        batchValue = new JLabel();
        idNoValue = new JLabel();

		JLabel pic = new JLabel();
		pic.setIcon(new ImageIcon("pictures\\cite.jpg"));
		pic.setBounds(100, 30, 150, 150);
		studentPanel.add(pic);

		JLabel infoLabel = new JLabel("STUDENT's INFORMATION");
		infoLabel.setBounds(45, 200, 250, 30);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
		studentPanel.add(infoLabel);

		JTextArea lineArea = new JTextArea();
		lineArea.setBounds(0, 240, 315, 1);
		lineArea.setBackground(new Color(0, 0, 0));
		lineArea.setEditable(false);
		studentPanel.add(lineArea);

		JLabel studentNameLabel = new JLabel("Student's Name:");
		studentNameLabel.setBounds(10, 260, 120, 20);
		studentNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		studentPanel.add(studentNameLabel);

		studentNameValue = new JLabel("");
		studentNameValue.setBounds(120, 260, 150, 20);
		studentPanel.add(studentNameValue);

		JLabel sectionLabel = new JLabel("Section:");
		sectionLabel.setBounds(10, 290, 100, 20);
		sectionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		studentPanel.add(sectionLabel);
		
		sectionValue = new JLabel("");
		sectionValue.setBounds(120, 290, 100, 30);
		studentPanel.add(sectionValue);

		JLabel departmentLabel = new JLabel("Department:");
		departmentLabel.setBounds(10, 320, 100, 20);
		departmentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		studentPanel.add(departmentLabel);

		departmentValue = new JLabel();
		departmentValue.setBounds(120, 320, 150, 20);
		studentPanel.add(departmentValue);

		JLabel batchLabel = new JLabel("Batch:");
		batchLabel.setBounds(10, 350, 100, 20);
		batchLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		studentPanel.add(batchLabel);

		batchValue = new JLabel();
		batchValue.setBounds(120, 350, 150, 20);
		studentPanel.add(batchValue);

		JLabel idNoLabel = new JLabel("ID No.:");
		idNoLabel.setBounds(10, 380, 100, 20);
		idNoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		studentPanel.add(idNoLabel);

		idNoValue = new JLabel();
		idNoValue.setBounds(120, 380, 150, 20);
		studentPanel.add(idNoValue);


		JButton moreInfoButton = new JButton("More Information");
        moreInfoButton.setBounds(80, 430, 150, 30);
        moreInfoButton.setBackground(new Color(255, 255, 255));
        moreInfoButton.setFocusPainted(false);
        moreInfoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JPanel moreInfoPanel = new JPanel();
				moreInfoPanel.setBackground(new Color(172, 207, 203));
				moreInfoPanel.setLayout(null);

				JLabel pic = new JLabel();
				pic.setIcon(new ImageIcon("pictures\\cite.jpg"));
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
				

				JLabel emailLabel = new JLabel("Email:");
				emailLabel.setBounds(10, 260, 80, 20);
				emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
				moreInfoPanel.add(emailLabel);

				emailValue.setBounds(120, 260, 150, 20);
				moreInfoPanel.add(emailValue);

				JLabel birthdayLabel = new JLabel("Birthday:");
				birthdayLabel.setBounds(10, 290, 80, 20);
				birthdayLabel.setFont(new Font("Arial", Font.PLAIN, 14));
				moreInfoPanel.add(birthdayLabel);

				birthdayValue.setBounds(120, 290, 150, 20);
                moreInfoPanel.add(birthdayValue);

				JLabel phoneLabel = new JLabel("Phone:");
				phoneLabel.setBounds(10, 320, 80, 20);
				phoneLabel.setFont(new Font("Arial", Font.PLAIN, 14));
				moreInfoPanel.add(phoneLabel);

				phoneValue.setBounds(120, 320, 150, 20);
				moreInfoPanel.add(phoneValue);

                JLabel gradeLabel = new JLabel("Grade:");
				gradeLabel.setBounds(10, 350, 80, 20);
				gradeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
				moreInfoPanel.add(gradeLabel);

                gradeValue.setBounds(120, 350, 150, 20);
				moreInfoPanel.add(gradeValue);

				JButton closeInfoButton = new JButton("Close");
				closeInfoButton.setBounds(80, 430, 150, 30);
				closeInfoButton.setBackground(new Color(255, 255, 255));
				closeInfoButton.setFocusPainted(false);
				closeInfoButton.addActionListener(ex -> {
					frame.remove(moreInfoPanel);
					studentPanel.setVisible(true);
					frame.repaint();
					frame.revalidate();
				});
				moreInfoPanel.add(closeInfoButton);
				
				
				moreInfoPanel.setBounds(0, 0, 315, 500);
				frame.add(moreInfoPanel);
				studentPanel.setVisible(false);
				frame.repaint();
				frame.revalidate();
			}	
		});
        studentPanel.add(moreInfoButton);


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
		studentPanel.add(logoutBtn);
		
		loadUserData(username);
    }
	
	private void loadUserData(String username) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("database/students.dat"));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] userData = line.split(":"); // Assuming ":" as the delimiter, adjust as needed

				String storedUsername = userData[1].trim(); // Assuming the username is the second field
				if (username.equals(storedUsername)) {
					displayUserData(userData);
					break; // Stop reading after finding a match
				}
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}


    private void displayUserData(String[] userData) {
		String fullname = getValue(userData, 4);
        studentNameValue.setText(getValue(userData, 4));
        sectionValue.setText(getValue(userData, 5));
        departmentValue.setText(getValue(userData, 11));
        batchValue.setText(getValue(userData, 6));
        idNoValue.setText(getValue(userData, 7));
        String birthday = getValue(userData, 8);
        birthdayValue.setText(birthday);
        emailValue.setText(getValue(userData, 9));
        phoneValue.setText(getValue(userData, 10));
        gradeValue.setText(getValue(userData, 12));

        // Check and display birthday notification
		JOptionPane.showMessageDialog(frame, "Welcome, " + fullname);
        checkBirthday(birthday, fullname);
    }

    private String getValue(String[] userData, int index) {
        if (index >= 0 && index < userData.length) {
            return userData[index].trim();
        } else {
            return ""; // Return an empty string if the index is out of bounds
        }
    }

    private void checkBirthday(String birthday, String fullname) {
		// Parse the birthday string to LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
		LocalDate userBirthday = LocalDate.parse(birthday, formatter);

		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Check if it's the user's birthday
		if (userBirthday.getMonth().equals(currentDate.getMonth()) &&
				userBirthday.getDayOfMonth() == currentDate.getDayOfMonth()) {
			// Load the birthday GIF from file
			ImageIcon gifIcon = new ImageIcon("pictures\\bday.gif");

			// Create a JPanel with the GIF
			JPanel gifPanel = new JPanel();
			gifPanel.add(new JLabel(gifIcon));

			// Show a JOptionPane with the GIF and birthday message
			JOptionPane.showMessageDialog(
					null,
					gifPanel,
					"HAPPY BIRTHDAY!  " + fullname,
					JOptionPane.PLAIN_MESSAGE
			);
		}
	}



}