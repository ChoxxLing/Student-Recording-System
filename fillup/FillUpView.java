package book.system.fillup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

class FillupForm{
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


	FillupForm(JFrame frame, JPanel loginPanel, String username){

		JPanel recordpanel = new JPanel();
		recordpanel.setBackground(Color.CYAN);
        recordpanel.setBounds(0, 0, 315, 540);
        recordpanel.setLayout(null);
        frame.add(recordpanel);

        frame.getContentPane().removeAll();
		frame.getContentPane().add(recordpanel);
		frame.repaint();
		frame.revalidate();

		JLabel titlelabel = new JLabel("Fill-up the details");
        titlelabel.setBounds(15, 5, 200, 40);
		titlelabel.setForeground(Color.RED);
		titlelabel.setFont(new Font("Calibre", Font.BOLD, 15));
        recordpanel.add(titlelabel);

        JLabel fnamelabel = new JLabel("First name:");
        fnamelabel.setBounds(5, 40, 100, 25);
        recordpanel.add(fnamelabel);

        fnamefield = new JTextField();
        fnamefield.setBounds(100, 40, 150, 22);
        recordpanel.add(fnamefield);

		JLabel mnamelabel = new JLabel("Middle name:");
        mnamelabel.setBounds(5, 70, 100, 22);
        recordpanel.add(mnamelabel);

        mnamefield = new JTextField();
        mnamefield.setBounds(100, 70, 150, 22);
        recordpanel.add(mnamefield);

		JLabel lnamelabel = new JLabel("Last name:");
        lnamelabel.setBounds(5, 100, 100, 22);
        recordpanel.add(lnamelabel);

        lnamefield = new JTextField();
        lnamefield.setBounds(100, 100, 150, 22);
        recordpanel.add(lnamefield);


        JLabel sectionlabel = new JLabel("Section:");
        sectionlabel.setBounds(5, 130, 100, 22);
        recordpanel.add(sectionlabel);

        sectionfield = new JTextField();
        sectionfield.setBounds(100, 130, 150, 22);
        recordpanel.add(sectionfield);

        JLabel batchlabel = new JLabel("Batch:");
        batchlabel.setBounds(5, 160, 100, 22);
        recordpanel.add(batchlabel);

        batchfield = new JTextField();
        batchfield.setBounds(100, 160, 150, 22);
        recordpanel.add(batchfield);

        JLabel idnolabel = new JLabel("Id no:");
        idnolabel.setBounds(5, 190, 100, 22);
        recordpanel.add(idnolabel);

        idnofield = new JTextField();
        idnofield.setBounds(100, 190, 150, 22);
        recordpanel.add(idnofield);

        JLabel birthdaylabel = new JLabel("Birthday:");
        birthdaylabel.setBounds(5, 220, 100, 22);
        recordpanel.add(birthdaylabel);

		monthComboBox = createMonthComboBox();
        monthComboBox.setBounds(100, 220, 53, 22);
        recordpanel.add(monthComboBox);

        dayComboBox = createComboBox(1, 31);
        dayComboBox.setBounds(155, 220, 40, 22);
        recordpanel.add(dayComboBox);

        yearComboBox = createComboBox(1990, getCurrentYear());
        yearComboBox.setBounds(197, 220, 54, 22);
        recordpanel.add(yearComboBox);

        JLabel emaillabel = new JLabel("Email address:");
        emaillabel.setBounds(5, 250, 100, 22);
        recordpanel.add(emaillabel);

        emailfield = new JTextField();
        emailfield.setBounds(100, 250, 150, 22);
        recordpanel.add(emailfield);

        JLabel phonenumberlabel = new JLabel("Phone number:");
        phonenumberlabel.setBounds(5, 280, 100, 22);
        recordpanel.add(phonenumberlabel);

        phonenumberfield = new JTextField();
        phonenumberfield.setBounds(100, 280, 150, 22);
        recordpanel.add(phonenumberfield);

        JLabel departmentlabel = new JLabel("Department:");
        departmentlabel.setBounds(5, 310, 100, 22);
        recordpanel.add(departmentlabel);
        String[] departmentOptions = {"Electrical Engineering", "Computer Engineering", "Electronics Engineering", "Mechanical Engineering"};
        departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setBounds(100, 310, 150, 22);
        recordpanel.add(departmentComboBox);

        JButton submitbtn = new JButton("SUBMIT");
        submitbtn.setBounds(150, 450, 100, 22);
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
                        JOptionPane.showMessageDialog(frame, "Registered successfully!");
                    
                        clearTextFields();
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
		"Jan", "Feb", "Mar", "Apr", "May", "June",
		"July", "Aug", "Sept", "Oct", "Nov", "Dec" };
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
        String filePath = "database\\users.dat";
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