import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView {
    private static JTable teacherTable;
    private static CustomTableModel model;
    private static JComboBox<String> departmentFilter;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame dashFrame = new JFrame("Teacher Records");
        JPanel dashPanel = new JPanel(new BorderLayout());
        dashFrame.add(dashPanel);

        // Sample data for the table (replace with your actual data)
        Object[][] rowData = {
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"},
                {"John Doe", "A1", "Science", "Math, Physics"},
                {"Jane Smith", "B2", "English", "Literature, Grammar"}


                // Add more rows as needed
        };

        Object[] columnNames = {"Teacher's Name", "Section", "Department", "Subjects"};

        model = new CustomTableModel(rowData, columnNames);

        teacherTable = new JTable(model);

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

        // Edit and Remove buttons
        JButton editButton = new JButton("Edit");
        editButton.setBackground(Color.WHITE);
        JButton removeButton = new JButton("Remove");
        removeButton.setBackground(Color.WHITE);

        // Edit button ActionListener
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = teacherTable.getSelectedRow();
                int selectedColumn = teacherTable.getSelectedColumn();

                if (selectedRow != -1 && selectedColumn != -1) {
                    // Make the selected cell editable
                    model.setColumnEditable(selectedColumn, true);
                } else {
                    JOptionPane.showMessageDialog(dashFrame, "Please select a cell to edit");
                }
            }
        });

        // Remove button ActionListener
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = teacherTable.getSelectedRow();

                if (selectedRow != -1) {
                    // Remove the selected row
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(dashFrame, "Please select a row to remove");
                }
            }
        });


        // Department filter components
        JLabel departmentLabel = new JLabel("Filter by Department:");
        String[] departments = {"", "Science", "English", "Math", "History"}; // Add your departments
        departmentFilter = new JComboBox<>(departments);
        JButton applyFilterButton = new JButton("Apply Filter");

        // Add ActionListener to the filter button
        applyFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDepartment = (String) departmentFilter.getSelectedItem();
                filterByDepartment(model, selectedDepartment, teacherTable);
            }
        });

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.add(departmentLabel);
        filterPanel.add(departmentFilter);
        filterPanel.add(applyFilterButton);

        dashPanel.add(filterPanel, BorderLayout.SOUTH);

        JPanel editPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        editPanel.add(new JLabel("Teacher Records"));
        editPanel.add(editButton);
        editPanel.add(removeButton);

        dashPanel.add(editPanel, BorderLayout.SOUTH);

        dashFrame.setSize(650, 340);
        dashFrame.setLocationRelativeTo(null);
        dashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashFrame.setVisible(true);
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
    }
}
