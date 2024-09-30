import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO employees (name, position, salary, attendance) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getPosition());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getAttendance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM employees";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getInt("attendance")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getInt("attendance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // Method to update employee
    public void updateEmployee(Employee employee) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE employees SET name = ?, position = ?, salary = ?, attendance = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getPosition());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getAttendance());
            ps.setInt(5, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete employee
    public void deleteEmployee(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM employees WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

