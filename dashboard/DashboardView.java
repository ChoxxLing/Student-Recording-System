package book.system.dashboard;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Calendar;

public class DashboardView {
    private static JTable teacherTable;
    private static CustomTableModel model;
    private static JComboBox<String> departmentFilter;
    private static JPanel birthdayPanel;
    private static Object[] originalData;


    DashboardView(JFrame frame, JPanel adminPanel, Boolean setComponentsEnabled) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI(frame, adminPanel, setComponentsEnabled);
        });
    }

    private static void createAndShowGUI(JFrame frame, JPanel adminPanel, Boolean setComponentsEnabled) {
        JFrame dashFrame = new JFrame("Teacher Records");
        JPanel dashPanel = new JPanel(new BorderLayout());
        dashFrame.add(dashPanel);

        // Read data from the "users.dat" file
       Object[] columnNames = {"#", "accountname", "username", "password", "roleId",  "Teacher's Name", "Section", "Batch", "Id no",
        "Birthday", "Email Address", "Phone Number", "Department"};
        model = new CustomTableModel(addRowNumbers(readUserDataFromFile("database//teachers.dat")), columnNames);

        teacherTable = new JTable(model);
        adjustColumnWidths(teacherTable);

        JScrollPane scrollPane = new JScrollPane(teacherTable);
        dashPanel.add(scrollPane, BorderLayout.CENTER);

        // Search bar components
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(150, 20)); // Increase the size
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.WHITE);

        // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().toLowerCase();
                searchTeacher(model, searchTerm, teacherTable);
            }
        });

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Adjusted layout
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        dashPanel.add(searchPanel, BorderLayout.NORTH);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBackground(Color.WHITE);

            // Add ActionListener to the refresh button
            refreshButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    refreshTable();
                }
            });

            searchPanel.add(refreshButton);



    JButton moreDetailsButton = new JButton("More Details");
    moreDetailsButton.setBackground(Color.WHITE);

        // More Details button ActionListener
        moreDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = teacherTable.getSelectedRow();

                if (selectedRow != -1) {
                    Object[][] userData = readUserDataFromFile("database//teachers.dat");
                    showDetailsPanel(userData[selectedRow], selectedRow);
                } else {
                    JOptionPane.showMessageDialog(dashFrame, "Please select a row to view details");
                }
            }
        });

         JPanel editPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        editPanel.add(new JLabel("Teacher Records"));
        editPanel.add(moreDetailsButton);

        dashPanel.add(editPanel, BorderLayout.SOUTH);

        dashFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setComponentsEnabled(adminPanel, true);
            }
        });

        dashFrame.setSize(950, 360);
        dashFrame.setLocationRelativeTo(null);
        dashFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dashFrame.setVisible(true);

    }

    private static void setComponentsEnabled(Container container, boolean enabled) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                setComponentsEnabled((Container) component, enabled);
            }
            component.setEnabled(enabled);
        }
    }

   private static Object[][] addRowNumbers(Object[][] data) {
        if (data.length == 0 || data[0].length == 0) {
        return new Object[0][0]; // Return an empty array if data is empty
    }

    Object[][] newData = new Object[data.length][data[0].length + 1];


        for (int i = 0; i < data.length; i++) {
            newData[i][0] = i + 1; // Add row numbers starting from 1
            for (int j = 0; j < data[i].length; j++) {
                newData[i][j + 1] = data[i][j]; // Copy existing data correctly
            }
        }

        return newData;
    }



    private static Object[] getColumnNames() {
        return new Object[]{"#", "accountname", "username", "password", "roleId",  "Teacher's Name",
                "Section", "Batch", "Id no", "Birthday", "Email Address", "Phone Number", "Department"};
    }


    private static void refreshTable() {
        // Update the model for the table
        model.setDataVector(addRowNumbers(readUserDataFromFile("database//teachers.dat")), getColumnNames());
        model.fireTableDataChanged();

        adjustColumnWidths(teacherTable);
    }



    private static void adjustColumnWidths(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width

            // Get the preferred width based on the column name
            String columnName = table.getColumnName(column);
            FontMetrics metrics = table.getFontMetrics(table.getFont());
            int textWidth = metrics.stringWidth(columnName) + 10; 

            width = Math.max(textWidth, width);

            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }


    private static Object[][] readUserDataFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<Object[]> rows = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(":");
                
                // Check the condition (element num 3 is equal to "2")
                if (userData.length > 3 && "2".equals(userData[3])) {
                    // Read all elements (from index 0 to 11)
                    Object[] rowData = Arrays.copyOfRange(userData, 0, 12);
                    rows.add(rowData);
                }
            }

            return rows.toArray(new Object[0][0]);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return new Object[0][0];
    }

    private static void searchTeacher(CustomTableModel model, String searchTerm, JTable table) {
        TableRowSorter<CustomTableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);

        if (searchTerm.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm));
        }
    }

    private static void filterByDepartment(CustomTableModel model, String department, JTable table) {
        TableRowSorter<CustomTableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);

        if (department.isEmpty()) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + department, 2));
        }
    }


    private static class CustomTableModel extends DefaultTableModel {
        private boolean[] columnEditable;

        public CustomTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
            this.columnEditable = new boolean[columnNames.length];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return columnEditable[column];
        }

        public void setColumnEditable(int column, boolean editable) {
            columnEditable[column] = editable;
        }

        public Object[][] getData() {
            int rowCount = getRowCount();
            int columnCount = getColumnCount();
            Object[][] data = new Object[rowCount][columnCount];

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = getValueAt(i, j);
                }
            }

            return data;
        }
    }

    

    private static void showDetailsPanel(Object[] rowData, int selectedRow ) {
        JFrame detailsFrame = new JFrame("Teacher Details");

        JPanel mainPanel = new JPanel(new GridLayout(0, 2));
        mainPanel.setBackground(new Color(173, 216, 230));

        String[] columnNames = {"accountname ", "username ", "password ", "roleId ",  "Teacher's Name ", "Section ", "Batch ", "Id no ",
        "Birthday ", "Email Address ", "Phone Number ", "Department "};

        JComponent[] textFields = new JComponent[columnNames.length];

        
        for (int i = 0; i < columnNames.length; i++) {
            JLabel label = new JLabel(columnNames[i]);
            label.setHorizontalAlignment(JLabel.RIGHT);
            mainPanel.add(label);


            if (i == 8) { // Birthday column
                JPanel birthdayPanel = createBirthdayPanel(rowData[i]); // Create birthday panel
                disableComponents(birthdayPanel); // Make birthdayPanel uneditable
                mainPanel.add(birthdayPanel);
                textFields[i] = birthdayPanel; // Store the birthday panel reference in textFields array
            } else if (i == 11) { // Department column
                JComboBox<String> departmentComboBox = createDepartmentComboBox();
                departmentComboBox.setSelectedItem(rowData[i]); // Set initial value
                departmentComboBox.setEnabled(false); // Make it not editable
                mainPanel.add(departmentComboBox);
                textFields[i] = departmentComboBox; // Store the JComboBox reference in textFields array
            } else {
                JTextField textField;
                if (i == 3) { // Check if the current field is roleId
                    textField = new JTextField(String.valueOf(rowData[i])) {
                        @Override
                        public void setEditable(boolean editable) {
                            // Override setEditable to always make roleId uneditable
                            super.setEditable(false);
                        }
                    };
                } else {
                    textField = new JTextField(String.valueOf(rowData[i]));
                    textField.setEditable(false); // Set as not editable for other fields
                }
                textFields[i] = textField;
                mainPanel.add(textField);
            }
        }

        JPanel buttonPanel = new JPanel(null);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(155, 5, 70, 30);
        buttonPanel.add(editButton);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(155, 5, 70, 30);
        buttonPanel.add(saveButton);
        saveButton.setVisible(false);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(230, 5, 70, 30);
        buttonPanel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(detailsFrame,
                        "Are you sure you want to delete this entry?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Delete the selected row from the "users.dat" file
                    deleteRowFromFile("database//teachers.dat", selectedRow );

                    // Update the model for the table
                    refreshTable();

                    adjustColumnWidths(teacherTable);

                    // Close the details frame
                    detailsFrame.dispose();
                }
            }
        });


        JButton backButton = new JButton("Back");
        backButton.setBounds(80, 5, 70, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                detailsFrame.dispose(); // Close the details frame
            }
        });
        buttonPanel.add(backButton);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (JComponent component : textFields) {
                    if (component instanceof JTextField) {
                        ((JTextField) component).setEditable(true);
                    } else if (component instanceof JComboBox) {
                        ((JComboBox<?>) component).setEnabled(true);
                    } else if (component instanceof JPanel) {
                        enableBirthdayPanel((JPanel) component, true);
                    }
                }
                editButton.setVisible(false);
                saveButton.setVisible(true);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(detailsFrame,
                        "Are you sure you want to save changes?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Save changes to the specific row in the "users.dat" file
                    Object[][] updatedData = saveDataToFile(getUpdatedData(rowData, textFields), "teachers.dat", selectedRow);

                    // Set components back to not editable
                    for (JComponent component : textFields) {
                        if (component instanceof JTextField) {
                            ((JTextField) component).setEditable(false);
                        } else if (component instanceof JComboBox) {
                            ((JComboBox<?>) component).setEnabled(false);
                        }
                        else if (component instanceof JPanel) {
                            disableComponents(birthdayPanel); // amke the birtday panel un editable
                        }
                    }

                    // Update the model for the table
                    refreshTable();

                    adjustColumnWidths(teacherTable);

                    editButton.setVisible(true);
                    saveButton.setVisible(false);
                }
            }
        });

        detailsFrame.add(mainPanel);
        detailsFrame.add(buttonPanel);

        detailsFrame.setLayout(new BoxLayout(detailsFrame.getContentPane(), BoxLayout.Y_AXIS));
        detailsFrame.setSize(425, 570);
        detailsFrame.setLocationRelativeTo(null);
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setResizable(false);
        detailsFrame.setUndecorated(false);
        detailsFrame.setVisible(true);

    }



    private static Object[][] getUpdatedData(Object[] rowData, JComponent[] components) {
        Object[][] updatedData = new Object[1][rowData.length];

        for (int i = 0; i < rowData.length; i++) {
            if (components[i] instanceof JTextField) {
                updatedData[0][i] = ((JTextField) components[i]).getText();
            } else if (components[i] instanceof JComboBox) {
                updatedData[0][i] = ((JComboBox<?>) components[i]).getSelectedItem();
            } else if (components[i] instanceof JPanel) {
                // Handle components of the birthday panel
                Object birthdayData = getBirthdayPanelData((JPanel) components[i]);
                updatedData[0][i] = birthdayData;
            }
        }

        return updatedData;
    }

    private static Object getBirthdayPanelData(JPanel birthdayPanel) {
        Component[] components = birthdayPanel.getComponents();

        // Assuming the components are JComboBox for month, day, and year
        String month = ((JComboBox<?>) components[0]).getSelectedItem().toString();
        String day = ((JComboBox<?>) components[1]).getSelectedItem().toString();
        String year = ((JComboBox<?>) components[2]).getSelectedItem().toString();

        // Customize this part based on your data structure for birthday
        return month + " " + day + " " + year;
    }



    private static Object[][] saveDataToFile(Object[][] data, String fileName, int rowToUpdate) {
        String filePath = "database" + File.separator + fileName;
        String tempFilePath = "database" + File.separator + "temp.dat";

        // Store original data for the row to be updated
        Object[] originalRowData = readUserDataFromFile(filePath)[rowToUpdate];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFilePath))) {

            String line;
            int currentRow = 0;

            while ((line = reader.readLine()) != null) {
                if (currentRow == rowToUpdate) {
                    StringBuilder updatedLine = new StringBuilder();
                    String[] existingData = line.split(":");

                    // Update specific elements (element num 1 to 12)
                    for (int i = 0; i < 12; i++) {
                        // Check if data is available for update, else use existing data
                        updatedLine.append(i > 0 ? ":" : "").append(i < data[0].length ? data[0][i] : existingData[i]);
                    }
                    writer.println(updatedLine.toString());

                    // Debugging output
                    System.out.println("Updated Line: " + updatedLine.toString());
                } else {
                    writer.println(line);
                }
                currentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temp file to the original file
        try {
            Files.move(Paths.get(tempFilePath), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the "users.dat" file
        updateUsersFile(originalRowData, data[0]);

        // Return the updated data
        return data;
    }


    private static void updateUsersFile(Object[] originalData, Object[] newData) {
        String usersFilePath = "database" + File.separator + "users.dat";
        String tempUsersFilePath = "database" + File.separator + "temp_users.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFilePath));
            PrintWriter writer = new PrintWriter(new FileWriter(tempUsersFilePath))) {

            String line;
            boolean updated = false;

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the original accountname, username, and password
                if (line.contains(originalData[1] + ":" + originalData[2] + ":" + originalData[3])) {
                    // Replace the line with the new data, including only the first 4 elements
                    for (int i = 0; i < 4; i++) {
                        writer.print(String.valueOf(newData[i]));
                        if (i < 3) {
                            writer.print(":");
                        }
                    }
                    writer.println();  // Move to the next line after printing the first 4 elements
                    updated = true;
                } else {
                    writer.println(line);
                }
            }

            // If not updated, add the new data at the end (only the first 4 elements)
            if (!updated) {
                for (int i = 0; i < 4; i++) {
                    writer.print(String.valueOf(newData[i]));
                    if (i < 3) {
                        writer.print(":");
                    }
                }
                writer.println();  // Move to the next line after printing the first 4 elements
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Rename the temp file to the original file
        try {
            Files.move(Paths.get(tempUsersFilePath), Paths.get(usersFilePath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Saved to users.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static JComboBox<String> createDepartmentComboBox() {
        String[] departments = {"Computer Engineering", "Electrical Engineering", "Electronics Engineering", "Mechanical Engineering"};

        JComboBox<String> departmentComboBox = new JComboBox<>(departments);

        // Create a renderer to customize the appearance of the JComboBox
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                        boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setHorizontalAlignment(CENTER); // Center the text
                return this;
            }
        };

        departmentComboBox.setRenderer(renderer);

        return departmentComboBox;
    }

    private static JPanel createBirthdayPanel(Object birthdayData) {
        birthdayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        birthdayPanel.add(monthComboBox);

        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        JComboBox<String> dayComboBox = new JComboBox<>(days);
        birthdayPanel.add(dayComboBox);

        // Include the range from 1990 to the present year for the yearComboBox
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String[] years = new String[currentYear - 1989];
        for (int i = 1990; i <= currentYear; i++) {
            years[i - 1990] = String.valueOf(i);
        }
        JComboBox<String> yearComboBox = new JComboBox<>(years);
        birthdayPanel.add(yearComboBox);

        // Set the initial values based on the existing data
        if (birthdayData instanceof String) {
            String[] dateParts = ((String) birthdayData).split("/");
            if (dateParts.length == 3) {
                monthComboBox.setSelectedItem(dateParts[0]);
                dayComboBox.setSelectedItem(dateParts[1]);
                yearComboBox.setSelectedItem(dateParts[2]);
            }
        }

        return birthdayPanel;
    }



    private static void enableBirthdayPanel(JPanel birthdayPanel, boolean enable) {
        for (Component component : birthdayPanel.getComponents()) {
            if (component instanceof JComboBox) {
                ((JComboBox<?>) component).setEnabled(enable);
            }
        }

    }

    private static void disableComponents(Container container) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setEditable(false);
            } else if (component instanceof JComboBox) {
                ((JComboBox<?>) component).setEnabled(false);
            } else if (component instanceof JPanel && component.equals(birthdayPanel)) {
                disableComponents((Container) component);
            }
        }
    }


    
    private static void deleteRowFromFile(String fileName, int rowToDelete) {
        // Read the original data before deleting the row
        Object[] originalData = readUserDataFromFile(fileName)[rowToDelete];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
            PrintWriter writer = new PrintWriter(new FileWriter("database" + File.separator + "temp.dat"))) {

            String line;
            int currentRow = 0;

            while ((line = reader.readLine()) != null) {
                if (currentRow != rowToDelete) {
                    writer.println(line);
                }
                currentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temp file to the original file
        try {
            Files.move(Paths.get("database" + File.separator + "temp.dat"), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Removed from " + fileName);

            // Delete the corresponding line from the users.dat file
            deleteFromUsersFile(originalData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFromUsersFile(Object[] originalData) {
        String usersFilePath = "database" + File.separator + "users.dat";
        String tempUsersFilePath = "database" + File.separator + "temp_users.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFilePath));
            PrintWriter writer = new PrintWriter(new FileWriter(tempUsersFilePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the original accountname, username, and password
                if (!line.contains(originalData[1] + ":" + originalData[2] + ":" + originalData[3])) {
                    writer.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temp file to the original file
        try {
            Files.move(Paths.get(tempUsersFilePath), Paths.get(usersFilePath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Deleted from users.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    
}
