public class Employee {
    private int id;             // Unique identifier for the employee
    private String name;        // Name of the employee
    private String position;     // Job position of the employee
    private double salary;      // Salary of the employee
    private int attendance;     // Attendance count

    // Constructor
    public Employee(int id, String name, String position, double salary, int attendance) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.attendance = attendance;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public int getAttendance() {
        return attendance;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
    public double calculatePayroll() {
        double dailyRate = this.salary / 30; // Assuming 30 workdays in a month
        return dailyRate * this.attendance;
    }
}
