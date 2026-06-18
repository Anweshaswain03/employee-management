import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    String position;
    double salary;

    Employee(int id, String name, String department, String position, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Position: " + position +
                ", Salary: " + salary;
    }
}

class employeeManagementSystem {

    static ArrayList<Employee> employeeList = new ArrayList<>();
    static HashMap<Integer, Employee> employeeMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Position: ");
        String position = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, position, salary);

        employeeList.add(emp);
        employeeMap.put(id, emp);

        System.out.println("Employee Added Successfully!");
    }

    public static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No Employees Found!");
            return;
        }

        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    public static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = employeeMap.get(id);

        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    public static void updateEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = employeeMap.get(id);

        if (emp != null) {
            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            emp.salary = salary;

            System.out.println("Salary Updated Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = employeeMap.remove(id);

        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("Employee Deleted Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    public static void salaryReport() {
        double total = 0;

        for (Employee emp : employeeList) {
            total += emp.salary;
        }

        System.out.println("Total Employees: " + employeeList.size());
        System.out.println("Total Salary Expense: " + total);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Salary Report");
            System.out.println("7. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        searchEmployee();
                        break;
                    case 4:
                        updateEmployee();
                        break;
                    case 5:
                        deleteEmployee();
                        break;
                    case 6:
                        salaryReport();
                        break;
                    case 7:
                        System.out.println("Thank You!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid Input");
                sc.nextLine();
            }
        }
    }
}