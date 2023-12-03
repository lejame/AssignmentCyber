// đây là nhân viên tạm thời, class này là class chứa thông tin nhân viên chính thức, có thể set thuộc tính manager để làm quản lý
class RegularEmployee extends Employee {
    private Manager manager;

    public RegularEmployee(int id, String name, String phoneNumber, int numberOfWorkingDays, double dailySalary,
            Manager manager) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
        this.manager = manager;
    }

    public RegularEmployee(int id, String name, String phoneNumber, int numberOfWorkingDays, double dailySalary) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
    }

    // set thuộc tính manager
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    // tính số lương của nhân viên theo yêu cầu
    @Override
    public double calculateMonthlySalary() {
        return dailySalary * numberOfWorkingDays;
    }
}