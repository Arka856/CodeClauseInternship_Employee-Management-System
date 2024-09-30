import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmployeeDashboard extends JFrame {
    private JTable employeeTable;

    public EmployeeDashboard() {
        setTitle("Employee Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a table to display employee data
        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load employee data into the table
        loadEmployeeData();
    }

    // Method to load employee data from the database into the table
    private void loadEmployeeData() {
        EmployeeDAO dao = new EmployeeDAO(); // Get the list of employees from the database
        List<Employee> employees = dao.getAllEmployees(); // You already have this method in EmployeeDAO

        // Column names for the table
        String[] columnNames = {"ID", "Name", "Position", "Salary", "Attendance"};

        // Create a table model with the column names and 0 initial rows
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add each employee's data to the table
        for (Employee employee : employees) {
            Object[] row = {
                    employee.getId(),
                    employee.getName(),
                    employee.getPosition(),
                    employee.getSalary(),
                    employee.getAttendance()
            };
            model.addRow(row);
        }

        // Set the table model with data into the employeeTable
        employeeTable.setModel(model);
    }

    // Main method to launch the Employee Dashboard
    public static void main(String[] args) {
        new EmployeeDashboard().setVisible(true);
    }
}


