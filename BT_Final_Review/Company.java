import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    private String companyName;
    private String taxCode;
    private double monthlyRevenue;
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }
    // khi nhập thông tin từ bàn phím , em set thông tin lại cho Company
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public void setMonthlyRevenue(double monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }
    // thêm 1 nhân viên mới
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    // xóa 1 nhân viên
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
    // xuất thông tin nhân viên
    public void printEmployeeInfo() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the company.");
        } else {
            System.out.println("Employee Information:");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println("Employee " + (i + 1) + ":");
                System.out.println(employees.get(i));
            }
        }
    }
    // tính xuất tổng số lương cửa tường nhân viên
    public void calculateAndPrintTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateMonthlySalary();
        }
        System.out.println("Total salary for all employees: " + totalSalary);
    }
    // tìm nhân viên có số lương cao nhất
    public Employee findEmployeeWithHighestSalary() {
        if (employees.isEmpty()) {
            return null;
        }

        Employee highestPaidEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (employee instanceof RegularEmployee) {
                RegularEmployee regularEmployee = (RegularEmployee) employee;
                if (regularEmployee.calculateMonthlySalary() > highestPaidEmployee.calculateMonthlySalary()) {
                    highestPaidEmployee = regularEmployee;
                }
            }
        }

        return highestPaidEmployee;
    }
    // sắp xếp nhân viên theo tên, Em dùng hàm compator để so sánh cho 2 đối tượng nhân viên 1 và nhan viên 2
    public void sortEmployeesByName() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                double salary1 = employee1.calculateMonthlySalary();
                double salary2 = employee2.calculateMonthlySalary();
                return Double.compare(salary2, salary1);
            }
        });
        System.out.println("Employees sorted by salary (descending order):");
        printEmployeeInfo();
    }
}
