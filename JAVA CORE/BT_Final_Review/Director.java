class Director extends Employee {
    // thuộc tính cổ phần của công ty
    private double companyShares;

    public Director(int id, String name, String phoneNumber, int numberOfWorkingDays, double dailySalary, double companyShares) {
        super(id, name, phoneNumber, numberOfWorkingDays, dailySalary);
        this.companyShares = companyShares;
    }

    public void setCompanyShares(double companyShares) {
        this.companyShares = companyShares;
    }
    // tính lương
    @Override
    public double calculateMonthlySalary() {
        return dailySalary * numberOfWorkingDays;
    }
}

