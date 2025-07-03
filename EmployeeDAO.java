import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() throws SQLException {
        conn = DBConnection.getConnection();
    }

    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, email, department) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getEmail());
        stmt.setString(3, emp.getDepartment());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            employees.add(new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("department")
            ));
        }
        rs.close();
        stmt.close();
        return employees;
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employees SET name = ?, email = ?, department = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getEmail());
        stmt.setString(3, emp.getDepartment());
        stmt.setInt(4, emp.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
}
