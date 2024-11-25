import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
class EmployeeDetails {
    int EmployeeId;
    String EmployeeName;
    String EmployeeDesignation;

    EmployeeDetails(int EmployeeId, String EmployeeName, String EmployeeDesignation) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.EmployeeDesignation = EmployeeDesignation;
    }
}

class EmployeeManager {
    private List<EmployeeDetails> employeeList;

    public EmployeeManager() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(EmployeeDetails emp) {
        employeeList.add(emp);
    }

    public boolean removeEmployee(int employeeId) {
        for (EmployeeDetails emp : employeeList) {
            if (emp.EmployeeId == employeeId) {
                employeeList.remove(emp);
                return true;
            }
        }
        return false;
    }

    public EmployeeDetails searchEmployeeById(int id) {
        for (EmployeeDetails emp : employeeList) {
            if (emp.EmployeeId == id) {
                return emp;
            }
        }
        return null;
    }

    public List<EmployeeDetails> getAllEmployees() {
        return employeeList;
    }
}

public class EmployeeManagementSystem extends JFrame {
    private JTextField txtEmployeeId, txtEmployeeName, txtEmployeeDesignation;
    private JButton btnAdd, btnDelete, btnSearch, btnModify, btnViewAll;
    private JTable employeeTable;
    private EmployeeManager empManager;
    private DefaultTableModel tableModel;

    public EmployeeManagementSystem() {
        // Set up the JFrame
        setTitle("Employee Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        empManager = new EmployeeManager();

        // Set layout for the main content
        setLayout(new BorderLayout());

        // Create the panel for employee details input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);  // Add space between components

        // Labels and text fields
        JLabel lblEmployeeId = new JLabel("Employee ID:");
        txtEmployeeId = new JTextField(15);
        JLabel lblEmployeeName = new JLabel("Employee Name:");
        txtEmployeeName = new JTextField(15);
        JLabel lblEmployeeDesignation = new JLabel("Employee Designation:");
        txtEmployeeDesignation = new JTextField(15);

        // Buttons
        btnAdd = new JButton("Add Employee");
        btnDelete = new JButton("Delete Employee");
        btnSearch = new JButton("Search Employee");
        btnModify = new JButton("Modify Employee");
        btnViewAll = new JButton("View All Employees");

        // Add components to input panel using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(lblEmployeeId, gbc);
        gbc.gridx = 1;
        inputPanel.add(txtEmployeeId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(lblEmployeeName, gbc);
        gbc.gridx = 1;
        inputPanel.add(txtEmployeeName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(lblEmployeeDesignation, gbc);
        gbc.gridx = 1;
        inputPanel.add(txtEmployeeDesignation, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        inputPanel.add(btnAdd, gbc);

        gbc.gridy = 4;
        inputPanel.add(btnDelete, gbc);

        gbc.gridy = 5;
        inputPanel.add(btnSearch, gbc);

        gbc.gridy = 6;
        inputPanel.add(btnModify, gbc);

        gbc.gridy = 7;
        inputPanel.add(btnViewAll, gbc);

        // Add the input panel to the top of the frame
        add(inputPanel, BorderLayout.WEST);

        // Create table model and JTable for displaying employees
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Designation"}, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add Action Listeners to buttons
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmployee();
            }
        });

        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyEmployee();
            }
        });

        btnViewAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllEmployees();
            }
        });
    }

    private void addEmployee() {
        try {
            int id = Integer.parseInt(txtEmployeeId.getText());
            String name = txtEmployeeName.getText();
            String designation = txtEmployeeDesignation.getText();

            if (name.isEmpty() || designation.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Designation cannot be empty.");
                return;
            }

            EmployeeDetails emp = new EmployeeDetails(id, name, designation);
            empManager.addEmployee(emp);
            JOptionPane.showMessageDialog(this, "Employee added successfully.");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID.");
        }
    }

    private void deleteEmployee() {
        try {
            int id = Integer.parseInt(txtEmployeeId.getText());
            boolean isRemoved = empManager.removeEmployee(id);
            if (isRemoved) {
                JOptionPane.showMessageDialog(this, "Employee removed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Employee ID not found.");
            }
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID.");
        }
    }

    private void searchEmployee() {
        try {
            int id = Integer.parseInt(txtEmployeeId.getText());
            EmployeeDetails emp = empManager.searchEmployeeById(id);
            if (emp != null) {
                txtEmployeeName.setText(emp.EmployeeName);
                txtEmployeeDesignation.setText(emp.EmployeeDesignation);
            } else {
                JOptionPane.showMessageDialog(this, "Employee ID not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID.");
        }
    }

    private void modifyEmployee() {
        try {
            int id = Integer.parseInt(txtEmployeeId.getText());
            EmployeeDetails emp = empManager.searchEmployeeById(id);
            if (emp != null) {
                emp.EmployeeName = txtEmployeeName.getText();
                emp.EmployeeDesignation = txtEmployeeDesignation.getText();
                JOptionPane.showMessageDialog(this, "Employee details updated.");
            } else {
                JOptionPane.showMessageDialog(this, "Employee ID not found.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Employee ID.");
        }
    }

    private void viewAllEmployees() {
        tableModel.setRowCount(0); // Clear existing rows
        for (EmployeeDetails emp : empManager.getAllEmployees()) {
            tableModel.addRow(new Object[]{emp.EmployeeId, emp.EmployeeName, emp.EmployeeDesignation});
        }
    }

    private void clearFields() {
        txtEmployeeId.setText("");
        txtEmployeeName.setText("");
        txtEmployeeDesignation.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementSystem().setVisible(true);
            }
        });
    }
}
