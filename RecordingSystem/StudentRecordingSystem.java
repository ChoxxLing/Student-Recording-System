  import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class JTextFieldLimit extends PlainDocument {
    private int limit;
    private boolean allowLettersAndNumbers;

    public JTextFieldLimit(int limit, boolean allowLettersAndNumbers) {
        super();
        this.limit = limit;
        this.allowLettersAndNumbers = allowLettersAndNumbers;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            if (allowLettersAndNumbers && str.matches("[a-zA-Z0-9]+")) {
                super.insertString(offset, str, attr);
            } else if (!allowLettersAndNumbers) {
                super.insertString(offset, str, attr);
            }
        }
    }
}

class Student {
    int id;
    String lastName;
    String firstName;
    String middleName;
    String suffix;
    String course;
    int yearLevel;
    String section;
    String address;
    String birthdate;
    String classAdviser;
    List<String> subjects;

    public Student(int id, String lastName, String firstName, String middleName, String suffix, String course, int yearLevel, String section, String address, String birthdate, String classAdviser, List<String> subjects) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.course = course;
        this.yearLevel = yearLevel;
        this.section = section;
        this.address = address;
        this.birthdate = birthdate;
        this.classAdviser = classAdviser;
        this.subjects = subjects;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + lastName + ", " + firstName + " " + middleName + " " + suffix +
                ", Course: " + course + ", Grade Level: " + yearLevel + ", Section: " + section +
                "\nAddress: " + address + ", Birthdate: " + birthdate + ", Class Adviser: " + classAdviser +
                ", Subjects: " + String.join(", ", subjects);
    }

    public String toSaveString() {
        return id + "|" + lastName + "|" + firstName + "|" + middleName + "|" + suffix +
                "|" + course + "|" + yearLevel + "|" + section + "|" + address + "|" + birthdate +
                "|" + classAdviser + "|" + String.join(",", subjects);
    }
}

public class StudentRecordingSystem extends JFrame {
    private Map<String, List<Student>> sectionStudentMap;
    private DefaultTableModel tableModel;
    private JTable table;

    public StudentRecordingSystem() {
        sectionStudentMap = new HashMap<>();

        setTitle("Student Recording System");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model
        String[] columnNames = {"ID", "Last Name", "First Name", "Middle Name", "Suffix", "Course", "Grade Level", "Section"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create JTable
        table = new JTable(tableModel);

        // Create JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create JPanel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        addButton.setBackground(new Color(0x00FF00)); // Set background color to green
        buttonPanel.add(addButton);

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
        deleteButton.setBackground(new Color(0xFF0000)); // Set background color to red
        buttonPanel.add(deleteButton);

        JButton viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudentDetails();
            }
        });
        viewDetailsButton.setBackground(new Color(0xFFFF00)); // Set background color to yellow
        buttonPanel.add(viewDetailsButton);

        JButton saveDetailsButton = new JButton("Save Details");
        saveDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDetailsToFile();
            }
        });
        saveDetailsButton.setBackground(new Color(0xADD8E6)); // Set background color to light blue
        buttonPanel.add(saveDetailsButton);

        // Add mouse listener for selecting rows in the table
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    // Double-click to edit the selected student
                    editStudent();
                }
            }
        });

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addStudent() {
        // Get student information through input dialogs
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID:"));
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String middleName = JOptionPane.showInputDialog("Enter middle name:");
        String suffix = JOptionPane.showInputDialog("Enter suffix:");
        String fullName = firstName + " " + middleName + " " + lastName + " " + suffix;

        // Check for duplicate names
        if (isDuplicateName(fullName)) {
            JOptionPane.showMessageDialog(this, "A student with the same name already exists.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String course = JOptionPane.showInputDialog("Enter course:");
        int yearLevel = Integer.parseInt(JOptionPane.showInputDialog("Enter Grade level:"));
        String section = JOptionPane.showInputDialog("Enter section:");
        String address = JOptionPane.showInputDialog("Enter address:");
        String birthdate = JOptionPane.showInputDialog("Enter birthdate (e.g., MM/DD/YYYY):");
        String classAdviser = JOptionPane.showInputDialog("Enter class adviser:");

        // Get subjects through input dialogs
        List<String> subjects = new ArrayList<>();
        boolean addMoreSubjects;
        do {
            String subject = JOptionPane.showInputDialog("Enter subject:");
            subjects.add(subject);
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to add another subject?", "Add Subject", JOptionPane.YES_NO_OPTION);
            addMoreSubjects = (choice == JOptionPane.YES_OPTION);
        } while (addMoreSubjects);

        // Create a new Student object
        Student student = new Student(id, lastName, firstName, middleName, suffix, course, yearLevel, section, address, birthdate, classAdviser, subjects);

        // Add the student to the map based on the section
        sectionStudentMap.computeIfAbsent(section, k -> new ArrayList<>()).add(student);

        // Update the table
        updateTable();
    }

    private boolean isDuplicateName(String fullName) {
        for (List<Student> studentsInSection : sectionStudentMap.values()) {
            for (Student student : studentsInSection) {
                String existingFullName = student.firstName + " " + student.middleName + " " + student.lastName + " " + student.suffix;
                if (existingFullName.equalsIgnoreCase(fullName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Get the section of the selected student
            String section = (String) table.getValueAt(selectedRow, 7);

            // Remove the student from the list in the section
            List<Student> studentsInSection = sectionStudentMap.get(section);
            studentsInSection.remove(selectedRow);

            // Remove the section entry if there are no students left
            if (studentsInSection.isEmpty()) {
                sectionStudentMap.remove(section);
            }

            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        // Clear the table
        tableModel.setRowCount(0);

        // Populate the table with student information from the map
        for (List<Student> studentsInSection : sectionStudentMap.values()) {
            for (Student student : studentsInSection) {
                Object[] rowData = {
                        student.id,
                        student.lastName,
                        student.firstName,
                        student.middleName,
                        student.suffix,
                        student.course,
                        student.yearLevel,
                        student.section,
                };
                tableModel.addRow(rowData);
            }
        }
    }

    private void editStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Get the selected student
            Student student = getStudentFromTable(selectedRow);

            // Create a dialog for editing student information
            JPanel editPanel = new JPanel(new GridLayout(12, 2));
            editPanel.add(new JLabel("ID:"));
            JTextField idField = new JTextField(String.valueOf(student.id));
            idField.setEditable(false); // ID should not be editable
            editPanel.add(idField);
            editPanel.add(new JLabel("Last Name:"));
            JTextField lastNameField = new JTextField(student.lastName);
            editPanel.add(lastNameField);
            editPanel.add(new JLabel("First Name:"));
            JTextField firstNameField = new JTextField(student.firstName);
            editPanel.add(firstNameField);
            editPanel.add(new JLabel("Middle Name:"));
            JTextField middleNameField = new JTextField(student.middleName);
            editPanel.add(middleNameField);
            editPanel.add(new JLabel("Suffix:"));
            JTextField suffixField = new JTextField(student.suffix);
            editPanel.add(suffixField);
            editPanel.add(new JLabel("Course:"));
            JTextField courseField = new JTextField(student.course);
            editPanel.add(courseField);
            editPanel.add(new JLabel("Grade Level:"));
            JTextField yearLevelField = new JTextField(String.valueOf(student.yearLevel));
            editPanel.add(yearLevelField);
            
            // Modify section input to allow only letters and numbers
            editPanel.add(new JLabel("Section (Letters and Numbers Only):"));
            JTextField sectionField = new JTextField(student.section);
            editPanel.add(sectionField);
            sectionField.setDocument(new JTextFieldLimit(10, true)); // Limit to 10 characters and allow only letters and numbers

            editPanel.add(new JLabel("Address:"));
            JTextField addressField = new JTextField(student.address);
            editPanel.add(addressField);
            editPanel.add(new JLabel("Birthdate:"));
            JTextField birthdateField = new JTextField(student.birthdate);
            editPanel.add(birthdateField);
            editPanel.add(new JLabel("Class Adviser:"));
            JTextField classAdviserField = new JTextField(student.classAdviser);
            editPanel.add(classAdviserField);

            // Add subjects input
            StringBuilder subjectsText = new StringBuilder();
            for (String subject : student.subjects) {
                subjectsText.append(subject).append("\n");
            }
            JTextArea subjectsArea = new JTextArea(subjectsText.toString());
            JScrollPane subjectsScrollPane = new JScrollPane(subjectsArea);
            editPanel.add(new JLabel("Subjects:"));
            editPanel.add(subjectsScrollPane);

            int result = JOptionPane.showConfirmDialog(this, editPanel, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // Update the student information
                student.lastName = lastNameField.getText();
                student.firstName = firstNameField.getText();
                student.middleName = middleNameField.getText();
                student.suffix = suffixField.getText();
                student.course = courseField.getText();
                student.yearLevel = Integer.parseInt(yearLevelField.getText());
                student.section = sectionField.getText();
                student.address = addressField.getText();
                student.birthdate = birthdateField.getText();
                student.classAdviser = classAdviserField.getText();

                // Update subjects
                String[] subjectsArray = subjectsArea.getText().split("\n");
                student.subjects = new ArrayList<>();
                for (String subject : subjectsArray) {
                    student.subjects.add(subject);
                }

                // Update the table
                updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Student getStudentFromTable(int rowIndex) {
        int count = 0;
        for (List<Student> studentsInSection : sectionStudentMap.values()) {
            if (rowIndex < count + studentsInSection.size()) {
                return studentsInSection.get(rowIndex - count);
            }
            count += studentsInSection.size();
        }
        return null;
    }

    private void viewStudentDetails() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Get the selected student
            Student student = getStudentFromTable(selectedRow);

            // Create a dialog for viewing formatted student details
            JTextArea textArea = new JTextArea();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Use a monospaced font for consistent spacing

            // Add student details with formatting
            textArea.append(String.format("ID: %d\n", student.id));
            textArea.append(String.format("Name: %s, %s %s %s\n", student.lastName, student.firstName, student.middleName, student.suffix));
            textArea.append(String.format("Course: %s\n", student.course));
            textArea.append(String.format("Grade Level: %d\n", student.yearLevel));
            textArea.append(String.format("Section: %s\n", student.section));
            textArea.append(String.format("Address: %s\n", student.address));
            textArea.append(String.format("Birthdate: %s\n", student.birthdate));
            textArea.append(String.format("Class Adviser: %s\n", student.classAdviser));
            textArea.append(String.format("Subjects: %s\n", String.join(", ", student.subjects)));

            // Set background color
            textArea.setBackground(new Color(240, 240, 240)); // Light






  // Create a separator line
            textArea.append("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

            // Set the text area as uneditable
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);

            // Show the dialog
            JOptionPane.showMessageDialog(this, scrollPane, "Student Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to view details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveDetailsToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Student Details");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.endsWith(".txt")) {
                    filePath += ".txt";
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                // Add a title
                writer.write("Student Record Details");
                writer.newLine();

                // Write student details
                for (List<Student> studentsInSection : sectionStudentMap.values()) {
                    for (Student student : studentsInSection) {
                        writer.write(student.toSaveString());
                        writer.newLine();
                    }
                }

                writer.close();
                JOptionPane.showMessageDialog(this, "Student details saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving student details.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentRecordingSystem();
            }
        });
    }
}