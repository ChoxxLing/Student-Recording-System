import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordingSystem {
    public static void main(String[] args) {
        JFrame recordframe = new JFrame("Recording System");
        recordframe.setSize(315, 540);
        recordframe.setLayout(null);
        recordframe.setVisible(true);
        recordframe.getContentPane().setBackground(Color.CYAN);

        JLabel studentlabel = new JLabel("Student's name:");
        studentlabel.setBounds(5, 40, 100, 15);
        recordframe.add(studentlabel);

        JTextField studentsfield = new JTextField();
        studentsfield.setBounds(100, 40, 150, 15);
        recordframe.add(studentsfield);

        JLabel sectionlabel = new JLabel("Section:");
        sectionlabel.setBounds(5, 70, 100, 15);
        recordframe.add(sectionlabel);

        JTextField sectionfield = new JTextField();
        sectionfield.setBounds(100, 70, 150, 15);
        recordframe.add(sectionfield);

        JLabel batchlabel = new JLabel("Batch:");
        batchlabel.setBounds(5, 100, 100, 15);
        recordframe.add(batchlabel);

        JTextField batchfield = new JTextField();
        batchfield.setBounds(100, 100, 150, 15);
        recordframe.add(batchfield);

        JLabel idnolabel = new JLabel("Id no:");
        idnolabel.setBounds(5, 130, 100, 15);
        recordframe.add(idnolabel);

        JTextField idnofield = new JTextField();
        idnofield.setBounds(100, 130, 150, 15);
        recordframe.add(idnofield);

        JLabel birthdaylabel = new JLabel("Birthday:");
        birthdaylabel.setBounds(5, 160, 100, 15);
        recordframe.add(birthdaylabel);

        JTextField birthdayfield = new JTextField();
        birthdayfield.setBounds(100, 160, 150, 15);
        recordframe.add(birthdayfield);

        JLabel emaillabel = new JLabel("Emailaddress:");
        emaillabel.setBounds(5, 190, 100, 15);
        recordframe.add(emaillabel);

        JTextField emailfield = new JTextField();
        emailfield.setBounds(100, 190, 150, 15);
        recordframe.add(emailfield);

        JLabel phonenumberlabel = new JLabel("Phonenumber:");
        phonenumberlabel.setBounds(5, 220, 100, 15);
        recordframe.add(phonenumberlabel);

        JTextField phonenumberfield = new JTextField();
        phonenumberfield.setBounds(100, 220, 150, 15);
        recordframe.add(phonenumberfield);

        JLabel departmentlabel = new JLabel("Department:");
        departmentlabel.setBounds(5, 250, 100, 15);
        recordframe.add(departmentlabel);
        String[] departmentOptions = {"Elec", "Comp", "Elex", "Mech"};
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setBounds(100, 250, 150, 20);
        recordframe.add(departmentComboBox);

        JButton submitbtn = new JButton("SUBMIT");
        submitbtn.setBounds(150, 450, 100, 20);
        recordframe.add(submitbtn);

        submitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(recordframe,
                        "Are you sure you want to submit?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    String studentName = studentsfield.getText();
                    String section = sectionfield.getText();
                    String batch = batchfield.getText();
                    String idNo = idnofield.getText();
                    String birthday = birthdayfield.getText();
                    String emailAddress = emailfield.getText();
                    String phoneNumber = phonenumberfield.getText();
                    String selectedDepartment = (String) departmentComboBox.getSelectedItem();

                    String outputMessage = "Student's Name: " + studentName +
                            "\nSection: " + section +
                            "\nBatch: " + batch +
                            "\nId No: " + idNo +
                            "\nBirthday: " + birthday +
                            "\nEmail Address: " + emailAddress +
                            "\nPhone Number: " + phoneNumber +
                            "\nDepartment: " + selectedDepartment;

                    int registrationOption = JOptionPane.showOptionDialog(recordframe, outputMessage,
                            "User Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, null, null);

                    if (registrationOption == JOptionPane.OK_OPTION) {
                        JOptionPane.showMessageDialog(recordframe, "Registered successfully!");
                    }
                }
            }
        });
    }
}
