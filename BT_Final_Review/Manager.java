import java.util.ArrayList;
import java.util.List;
// class manager này em ké thừa hét toàn bộ thuộc tính và phương chức cảu employ
public class Manager extends Employee {
    // em tạo 1 dnah sách nhân viên , nhầm để tính toán lương của 1 manager
    private List<RegularEmployee> employeesUnderManagement;

    public Manager(int id, String name, String phoneNumber, int numberOfWorkingDays, double dailySalary) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
        employeesUnderManagement = new ArrayList<>();
    }
    // Thên 1 nhân viên trong sự quản lý của manager
    public void addEmployeeUnderManagement(RegularEmployee employee) {
        employeesUnderManagement.add(employee);
    }
    // xóa
    public void removeEmployeeUnderManagement(RegularEmployee employee) {
        employeesUnderManagement.remove(employee);
    }
    // lấy số lượng nhân viên
    public int getNumberOfEmployees() {
        return employeesUnderManagement.size();
    }
    // tính tiền lương
    @Override
    public double calculateMonthlySalary() {
        return dailySalary * numberOfWorkingDays + 100 * employeesUnderManagement.size();
    }
}

