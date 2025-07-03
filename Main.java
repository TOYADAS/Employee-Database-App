import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            EmployeeDAO dao = new EmployeeDAO();
            int choice;
            do {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Department: ");
                        String dept = scanner.nextLine();
                        dao.addEmployee(new Employee(name, email, dept));
                        System.out.println("Employee added!");
                        break;
                    case 2:
                        List<Employee> list = dao.getAllEmployees();
                        list.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("New Email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("New Department: ");
                        String newDept = scanner.nextLine();
                        dao.updateEmployee(new Employee(idToUpdate, newName, newEmail, newDept));
                        System.out.println("Employee updated.");
                        break;
                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        dao.deleteEmployee(idToDelete);
                        System.out.println("Employee deleted.");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}