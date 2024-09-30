import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmployeeForm extends JFrame {
    private JTextField idField, nameField, positionField, salaryField, attendanceField;
    private JButton searchButton, updateButton, deleteButton;

    public UpdateEmployeeForm() {
        setTitle("Update or Delete Employee");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Labels and fields for Employee ID, Name, Position, Salary, and Attendance
        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(10, 10, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 10, 160, 25);
        add(idField);

        searchButton = new JButton("Search");
        searchButton.setBounds(10, 40, 270, 25);
        add(searchButton);

        // Other fields for name, position, salary, and attendance
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 70, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 70, 160, 25);
        add(nameField);

        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setBounds(10, 100, 100, 25);
        add(positionLabel);

        positionField = new JTextField();
        positionField.setBounds(120, 100, 160, 25);
        add(positionField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(10, 130, 100, 25);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(120, 130, 160, 25);
        add(salaryField);

        JLabel attendanceLabel = new JLabel("Attendance:");
        attendanceLabel.setBounds(10, 160, 100, 25);
        add(attendanceLabel);

        attendanceField = new JTextField();
        attendanceField.setBounds(120, 160, 160, 25);
        add(attendanceField);

        // Update and Delete buttons
        updateButton = new JButton("Update Employee");
        updateButton.setBounds(10, 190, 160, 25);
        add(updateButton);

        deleteButton = new JButton("Delete Employee");
        deleteButton.setBounds(180, 190, 160, 25);
        add(deleteButton);

        // Search for Employee
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeDAO dao = new EmployeeDAO();
                Employee employee = dao.getEmployeeById(Integer.parseInt(idField.getText()));

                if (employee != null) {
                    nameField.setText(employee.getName());
                    positionField.setText(employee.getPosition());
                    salaryField.setText(String.valueOf(employee.getSalary()));
                    attendanceField.setText(String.valueOf(employee.getAttendance()));
                } else {
                    JOptionPane.showMessageDialog(null, "Employee not found!");
                }
            }
        });

        // Update Employee
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        positionField.getText(),
                        Double.parseDouble(salaryField.getText()),
                        Integer.parseInt(attendanceField.getText())
                );
                EmployeeDAO dao = new EmployeeDAO();
                dao.updateEmployee(employee);
                JOptionPane.showMessageDialog(null, "Employee updated successfully!");
            }
        });

        // Delete Employee
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeId = Integer.parseInt(idField.getText());
                EmployeeDAO dao = new EmployeeDAO();
                dao.deleteEmployee(employeeId);
                JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
            }
        });
    }

    public static void main(String[] args) {
        new UpdateEmployeeForm().setVisible(true);
    }
}
