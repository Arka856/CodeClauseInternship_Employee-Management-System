import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeForm extends JFrame {
    private JTextField nameField;
    private JTextField positionField;
    private JTextField salaryField;
    private JTextField attendanceField;
    private JButton saveButton;

    public EmployeeForm() {
        setTitle("Employee Management System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create and position labels and fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 10, 160, 25);
        add(nameField);

        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setBounds(10, 40, 80, 25);
        add(positionLabel);

        positionField = new JTextField();
        positionField.setBounds(100, 40, 160, 25);
        add(positionField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(10, 70, 80, 25);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(100, 70, 160, 25);
        add(salaryField);

        JLabel attendanceLabel = new JLabel("Attendance:");
        attendanceLabel.setBounds(10, 100, 80, 25);
        add(attendanceLabel);

        attendanceField = new JTextField();
        attendanceField.setBounds(100, 100, 160, 25);
        add(attendanceField);

        // Create and position the Save button
        saveButton = new JButton("Save");
        saveButton.setBounds(10, 130, 250, 25);
        add(saveButton);

        // Action listener for the Save button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Create an Employee object with data from the form
                    Employee employee = new Employee(
                            0,
                            nameField.getText(),
                            positionField.getText(),
                            Double.parseDouble(salaryField.getText()),
                            Integer.parseInt(attendanceField.getText())
                    );
                    EmployeeDAO dao = new EmployeeDAO();
                    dao.addEmployee(employee);
                    JOptionPane.showMessageDialog(null, "Employee added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Salary and Attendance.");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Ensure the form is displayed properly on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new EmployeeForm().setVisible(true); // This will make the UI form visible
        });
    }
}