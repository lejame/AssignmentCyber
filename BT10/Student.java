public class Student {
    private String ten;
    private String masv;
    private double toan;
    private double ly;
    private double hoa;

    public Student() {
    }

    public Student(String ten, String masv, double toan, double ly, double hoa) {
        this.ten = ten;
        this.masv = masv;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public double diemtrungbinh() {
        return (toan + ly + hoa) / 3;
    }

    public String xepLoai(double dtb) {
        if (dtb >= 9) {
            return "Xuat sac";
        } else if (dtb > 8) {
            return "Gioi";
        } else if (dtb >= 7) {
            return "Kha";
        } else if (dtb >= 6) {
            return "Trung binh kha";
        } else if (dtb >= 5) {
            return "Trung binh";
        } else {
            return "Yeu";
        }
    }

    @Override
    public String toString() {
        return "Student [ten=" + ten + ", masv=" + masv + ", toan=" + toan + ", ly=" + ly + ", hoa=" + hoa + "]";
    }
}