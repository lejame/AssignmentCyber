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
                    // assignEmployeeToManager();
                    break;
                case 3:
                    // removeEmployee();
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
                    //
                    break;
                case 8:
                    company.sortEmployeesByName();
                    break;
                case 9:
                    // company.sortEmployeesBySalaryDescending();
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

    private static void assignEmployeeToManager() {
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
}
