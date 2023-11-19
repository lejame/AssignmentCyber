import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company = new Company();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputCompanyInfo();
                    break;
                case 2:
                    assignEmployeeToManager();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    company.printEmployeeInfo();
                    break;
                case 5:
                    company.calculateAndPrintTotalSalary();
                    break;
                case 6:
                    Employee highestPaidEmployee = company.findEmployeeWithHighestSalary();
                    if (highestPaidEmployee != null) {
                        System.out.println("Regular employee with the highest salary:");
                        System.out.println(highestPaidEmployee);
                    } else {
                        System.out.println("No regular employees in the company.");
                    }
                    break;
                case 7:
                    findManagerWithMostEmployees();
                    break;
                case 8:
                    company.sortEmployeesByName();
                    break;
                case 9:
                    company.sortEmployeesBySalaryDescending();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    // hàm này để nhập thông tin của 1 công ty
    public static void inputCompanyInfo() {
        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();
        System.out.print("Enter tax code: ");
        String taxCode = scanner.nextLine();
        System.out.print("Enter monthly revenue: ");
        double monthlyRevenue = scanner.nextDouble();
        scanner.nextLine();

        company.setCompanyName(companyName);
        company.setTaxCode(taxCode);
        company.setMonthlyRevenue(monthlyRevenue);
    }

    // xuất ra các menu
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Enter company information");
        System.out.println("2. Assign employee to manager");
        System.out.println("3. Add or remove employee");
        System.out.println("4. Print employee information");
        System.out.println("5. Calculate and print total salary");
        System.out.println("6. Find regular employee with highest salary");
        System.out.println("7. Find manager with most employees");
        System.out.println("8. Sort employees by name");
        System.out.println("9. Sort employees by salary (descending)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // đăng kí cho 1 nhân viên thành quản lý
    public static void assignEmployeeToManager() {
        company.printEmployeeInfo();

        System.out.print("Enter the index of the manager: ");
        int managerIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the index of the employee: ");
        int employeeIndex = scanner.nextInt();
        scanner.nextLine();

        if (managerIndex >= 0 && managerIndex < company.getEmployees().size() &&
                employeeIndex >= 0 && employeeIndex < company.getEmployees().size()) {
            Employee manager = company.getEmployees().get(managerIndex);
            Employee employee = company.getEmployees().get(employeeIndex);
            if (manager instanceof Manager && employee instanceof RegularEmployee) {
                Manager castedManager = (Manager) manager;
                RegularEmployee castedEmployee = (RegularEmployee) employee;
                castedManager.addEmployeeUnderManagement(castedEmployee);
                System.out.println("Employee successfully assigned to the manager.");
            } else {
                System.out.println(
                        "Invalid assignment. Make sure the manager is a Manager and the employee is a RegularEmployee.");
            }
        } else {
            System.out.println("Invalid index. Please enter valid indices for the manager and employee.");
        }
    }

    // tìm ra quản lý có số lượng nhân viên nhiều nhất
    private static void findManagerWithMostEmployees() {
        Manager managerWithMostEmployees = null;
        int maxEmployeeCount = 0;

        for (Employee employee : company.getEmployees()) {
            if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                int employeeCount = manager.getNumberOfEmployees();
                if (employeeCount > maxEmployeeCount) {
                    maxEmployeeCount = employeeCount;
                    managerWithMostEmployees = manager;
                }
            }
        }

        if (managerWithMostEmployees != null) {
            System.out.println("Manager with the most employees:");
            System.out.println(managerWithMostEmployees.toString());
            System.out.println("Number of employees under their management: " + maxEmployeeCount);
        } else {
            System.out.println("There are no managers in the system.");
        }
    }

    // hàm này em làm để mình có thể thêm thông tin của 1 person nào đó như nhân
    // viên , quản lý hoặc giám đóc dựa vào điều kiện
    private static void addEmployee() {
        System.out.print("Enter the employee type (1 for Regular Employee, 2 for Manager, 3 for Director): ");
        int employeeType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter ID of Employee:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the employee phone number: ");
        String phoneNumber = scanner.nextLine();

        // thêm thông tin
        if (employeeType == 1) {

            System.out.print("Enter the number of working days: ");
            int workingDays = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the daily salary: ");
            double dailySalary = scanner.nextDouble();
            scanner.nextLine();

            RegularEmployee regularEmployee = new RegularEmployee(id, name, phoneNumber, workingDays, dailySalary);
            company.addEmployee(regularEmployee);

            System.out.println("Regular employee added successfully.");
        } else if (employeeType == 2) {

            System.out.print("Enter the number of working days: ");
            int workingDays = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the daily salary: ");
            double dailySalary = scanner.nextDouble();
            scanner.nextLine();

            Manager manager = new Manager(id, name, phoneNumber, workingDays, dailySalary);
            company.addEmployee(manager);
            System.out.println("Manager added successfully.");

        } else if (employeeType == 3) {

            System.out.print("Enter the number of working days: ");
            int workingDays = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the daily salary: ");
            double dailySalary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter the number of company shares: ");
            int companyShares = scanner.nextInt();
            scanner.nextLine();

            Director director = new Director(id, name, phoneNumber, workingDays, dailySalary, companyShares);
            company.addEmployee(director);
            System.out.println("Director added successfully.");
        } else {
            System.out.println("Invalid employee type.");
        }
    }
}
