package book.system.fillup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.*;

class FillUpView{
	private JLabel titlelabel;
	private JTextField fnamefield;
    private JTextField mnamefield;
    private JTextField lnamefield;
    private JTextField sectionfield;
    private JTextField batchfield;
    private JTextField idnofield;
    private JTextField emailfield;
    private JTextField phonenumberfield;
    private JComboBox<String> monthComboBox;  
    private JComboBox<String> dayComboBox;   
    private JComboBox<String> yearComboBox;   
    private JComboBox<String> departmentComboBox;


	FillUpView(JFrame frame, JPanel loginPanel, String username){

		LineBorder lineBorder =new LineBorder(Color.white, 1, true);

		JPanel recordpanel = new JPanel();
		recordpanel.setBackground(new Color(172, 207, 203));
        recordpanel.setBounds(0, 0, 315, 540);
        recordpanel.setLayout(null);
        frame.add(recordpanel);

        frame.getContentPane().removeAll();
		frame.getContentPane().add(recordpanel);
		frame.repaint();
		frame.revalidate();

        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("pictures\\cite.jpg"));
        pic.setBounds(93, 15, 125, 124);
        recordpanel.add(pic);

		titlelabel = new JLabel("DETAILS");
        titlelabel.setBounds(114, 127, 250, 44);
        titlelabel.setFont(new Font("Calibre", Font.BOLD, 20));
        recordpanel.add(titlelabel);
        
        JTextArea lineArea = new JTextArea();
        lineArea.setBounds(0,162,300,1);
        lineArea.setBackground(new Color(0,0,0));
        lineArea.setEditable(false);
        recordpanel.add(lineArea);

        JLabel fnamelabel = new JLabel("First name:");
        fnamelabel.setBounds(5, 170, 100, 25);
        recordpanel.add(fnamelabel);

        fnamefield = new JTextField();
        fnamefield.setBounds(100, 170, 150, 22);
        fnamefield.setBorder(lineBorder);
        recordpanel.add(fnamefield);

		JLabel mnamelabel = new JLabel("Middle name:");
        mnamelabel.setBounds(5, 200, 100, 22);
        recordpanel.add(mnamelabel);

        mnamefield = new JTextField();
        mnamefield.setBounds(100, 200, 150, 22);
        mnamefield.setBorder(lineBorder);
        recordpanel.add(mnamefield);

		JLabel lnamelabel = new JLabel("Last name:");
        lnamelabel.setBounds(5, 230, 100, 22);
        recordpanel.add(lnamelabel);

        lnamefield = new JTextField();
        lnamefield.setBounds(100, 230, 150, 22);
        lnamefield.setBorder(lineBorder);
        recordpanel.add(lnamefield);


        JLabel sectionlabel = new JLabel("Section:");
        sectionlabel.setBounds(5, 260, 100, 22);
        recordpanel.add(sectionlabel);

        sectionfield = new JTextField();
        sectionfield.setBounds(100, 260, 150, 22);
        sectionfield.setBorder(lineBorder);
        recordpanel.add(sectionfield);

        JLabel batchlabel = new JLabel("Batch:");
        batchlabel.setBounds(5, 290, 100, 22);
        recordpanel.add(batchlabel);

        batchfield = new JTextField();
        batchfield.setBounds(100, 290, 150, 22);
        batchfield.setBorder(lineBorder);
        recordpanel.add(batchfield);

        JLabel idnolabel = new JLabel("Id no:");
        idnolabel.setBounds(5, 320, 100, 22);
        recordpanel.add(idnolabel);

        idnofield = new JTextField();
        idnofield.setBounds(100, 320, 150, 22);
        idnofield.setBorder(lineBorder);
        recordpanel.add(idnofield);

        JLabel birthdaylabel = new JLabel("Birthday:");
        birthdaylabel.setBounds(5, 350, 100, 22);
        recordpanel.add(birthdaylabel);

		monthComboBox = createMonthComboBox();
        monthComboBox.setBounds(100, 350, 53, 22);
        monthComboBox.setBorder(lineBorder);
        recordpanel.add(monthComboBox);

        dayComboBox = createComboBox(1, 31);
        dayComboBox.setBounds(155, 350, 40, 22);
        dayComboBox.setBorder(lineBorder);
        recordpanel.add(dayComboBox);

        yearComboBox = createComboBox(1990, getCurrentYear());
        yearComboBox.setBounds(197, 350, 54, 22);
        yearComboBox.setBorder(lineBorder);
        recordpanel.add(yearComboBox);

        JLabel emaillabel = new JLabel("Email address:");
        emaillabel.setBounds(5, 380, 100, 22);
        recordpanel.add(emaillabel);

        emailfield = new JTextField();
        emailfield.setBounds(100, 380, 150, 22);
        emailfield.setBorder(lineBorder);
        recordpanel.add(emailfield);

        JLabel phonenumberlabel = new JLabel("Phone number:");
        phonenumberlabel.setBounds(5, 410, 100, 22);
        recordpanel.add(phonenumberlabel);

        phonenumberfield = new JTextField();
        phonenumberfield.setBounds(100, 410, 150, 22);
        phonenumberfield.setBorder(lineBorder);
        recordpanel.add(phonenumberfield);

        JLabel departmentlabel = new JLabel("Department:");
        departmentlabel.setBounds(5, 440, 100, 22);
        recordpanel.add(departmentlabel);

        String[] departmentOptions = {"Electrical Engineering", "Computer Engineering", "Electronics Engineering", "Mechanical Engineering"};
        departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setBounds(100, 440, 150, 22);
        departmentComboBox.setBorder(lineBorder);
        recordpanel.add(departmentComboBox);

        JTextArea lineArea2 = new JTextArea();
        lineArea2.setBounds(0,470,300,1);
        lineArea2.setBackground(new Color(0,0,0));
        lineArea2.setEditable(false);
        recordpanel.add(lineArea2);


        JButton logoutbtn = new JButton("LOGOUT");
        logoutbtn.setBounds(30, 475, 90, 22);
        logoutbtn.setFont(new Font("Dialog", Font.BOLD, 12));
        logoutbtn.setBackground(new Color(255, 77, 77));
        logoutbtn.addActionListener(new ActionListener() {
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
        recordpanel.add(logoutbtn); 

        JButton submitbtn = new JButton("SUBMIT");
        submitbtn.setBounds(155, 475, 100, 22);
        recordpanel.add(submitbtn);


        submitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (validateTextFields()) {
                    String firstName = fnamefield.getText();
                    String middleName = mnamefield.getText();
                    String lastName = lnamefield.getText();
                    String studentName = firstName + " " + middleName + " " + lastName;

                    String section = sectionfield.getText();
                    String batch = batchfield.getText();
                    String idNo = idnofield.getText();
                    String selectedDay = (String) dayComboBox.getSelectedItem();
                    String selectedMonth = (String) monthComboBox.getSelectedItem();
                    String selectedYear = (String) yearComboBox.getSelectedItem();
                    String birthday = selectedMonth + " " + selectedDay + " " + selectedYear;
                    String emailAddress = emailfield.getText();
                    String phoneNumber = phonenumberfield.getText();
                    String selectedDepartment = (String) departmentComboBox.getSelectedItem();

                    String outputMessage = "Full Name: " + studentName +
                            "\nSection: " + section +
                            "\nBatch: " + batch +
                            "\nId No: " + idNo +
                            "\nBirthday: " + birthday +
                            "\nEmail Address: " + emailAddress +
                            "\nPhone Number: " + phoneNumber +
                            "\nDepartment: " + selectedDepartment;

                    int registrationOption = JOptionPane.showOptionDialog(frame, outputMessage,
                            "User Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, null, null);

                    String userData = studentName + ":" + section + ":" + batch + ":" +
                    idNo + ":" + birthday + ":" + emailAddress + ":" + phoneNumber + ":" +
                    selectedDepartment;

                    // Save the data to the "users.dat" file
                    saveUserDataToFile(userData, username);

                    if (registrationOption == JOptionPane.OK_OPTION) {
                        JOptionPane.showMessageDialog(frame, "Details saved successfully!");
                        JOptionPane.showMessageDialog(frame, "Login to your account again.");

                        frame.getContentPane().removeAll();
                        frame.getContentPane().add(loginPanel);
                        frame.repaint();
                        frame.revalidate();
                    }
                } else {
                        JOptionPane.showMessageDialog(recordpanel, "Please fill in all details", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }


	private JComboBox<String> createComboBox(int start, int end) {
        String[] options = new String[end - start + 1];
        for (int i = 0; i < options.length; i++) {
            options[i] = String.valueOf(start + i);
        }
        return new JComboBox<>(options);
    }

    private JComboBox<String> createMonthComboBox() {
        String[] monthOptions = {
		"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        return new JComboBox<>(monthOptions);
    }

    private int getCurrentYear() {
        return java.time.Year.now().getValue();
    }
	


	// checking if the neccessary txt field have input
	private boolean validateTextFields() {
        JTextField[] textFields = {fnamefield, mnamefield, lnamefield,
                emailfield, phonenumberfield};

        for (JTextField textField : textFields) {
            if (textField.getText().trim().isEmpty()) {
                return false; // At least one field is empty
            }
        }
        // Validate email field
        String email = emailfield.getText().trim();
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
         // Validate phone number field
        String phoneNumber = phonenumberfield.getText().trim();
        if (!isNumeric(phoneNumber)) {
            JOptionPane.showMessageDialog(null, "Phone number should contain only numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; // All fields have input
    }

    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void saveUserDataToFile(String data, String username) {
        String filePath = "database\\students.dat";
        int lineIndex = -1; // Initialize the line index

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
            PrintWriter pw = new PrintWriter(new FileWriter("database\\temp.dat", true))) {

            String line;
            int currentIndex = 0; // Initialize the current index
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2 && parts[1].equals(username)) { // Check if the username matches
                    line += ":" + data; // Append the data to the line
                    lineIndex = currentIndex; // Store the line index
                }
                pw.println(line);
                currentIndex++;
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        // Close the resources before attempting to rename
        try {
            Files.deleteIfExists(Paths.get(filePath));
            Files.move(Paths.get("database\\temp.dat"), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to rename the file.");
        }

        if (lineIndex != -1) {
            System.out.println("Data appended successfully to line " + (lineIndex + 1));
        } else {
            System.out.println("Username not found in the file.");
        }
    }



    private void clearTextFields() {
        JTextField[] textFields = {fnamefield, mnamefield, lnamefield,
                sectionfield, batchfield, idnofield, emailfield, phonenumberfield};

        for (JTextField textField : textFields) {
            textField.setText("");
        }
        // Set default values for combo boxes
        monthComboBox.setSelectedIndex(0);
        dayComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        departmentComboBox.setSelectedIndex(0);
    }




}