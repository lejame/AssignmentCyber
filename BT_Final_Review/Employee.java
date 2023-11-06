// em tạo 1 abstract Employ để chứa các thuộc tính chung và cả phương thức tính toán
abstract class Employee {
    protected int id;
    protected String name;
    protected String phoneNumber;
    protected int numberOfWorkingDays;
    protected double dailySalary;

    public Employee(int id, String name, String phoneNumber, int numberOfWorkingDays, double dailySalary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.dailySalary = dailySalary;
    }
    // tính số lương
    public abstract double calculateMonthlySalary();
    // lấy tên của nhân viên
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phoneNumber + ", Monthly Salary: "
                + calculateMonthlySalary();
    }
}
