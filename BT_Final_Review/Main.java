import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company = new Company();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // inputCompanyInfo();
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
                    // Manager managerWithMostEmployees = company.findManagerWithMostEmployees();
                    // if (managerWithMostEmployees != null) {
                    //     System.out.println("Manager with the most employees:");
                    //     System.out.println(managerWithMostEmployees);
                    // } else {
                    //     System.out.println("No managers in the company.");
                    // }
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
}
