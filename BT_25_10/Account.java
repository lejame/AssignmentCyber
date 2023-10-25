import java.util.NoSuchElementException;

public class Account {
    private long sotaikhoan;
    private String taikhoan;
    private double tien;
    private float laisuat = (float) 0.035;
    private float phirut = (float) 3000;
    public Account(long sotaikhoan, String taikhoan) {
        this.sotaikhoan = sotaikhoan;
        this.taikhoan = taikhoan;
        this.tien = 50;
    }

    public Account() {
        this.sotaikhoan = 0;
        this.taikhoan = "";
        this.tien = 0;
    }

    public Account(long sotaikhoan, String taikhoan, double tien) {
        this.sotaikhoan = sotaikhoan;
        this.taikhoan = taikhoan;
        this.tien = tien;
    }

    public long getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(long sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }
    @Override
    public String toString() {
        return "Account [sotaikhoan=" + this.sotaikhoan + ", taikhoan=" + this.taikhoan + ", tien=" + this.tien + "]";
    }

    public void naptien(float tiennap){
        this.tien = this.tien + tiennap;
        System.out.println("Nap tien thanh cong");
    }

    public float ruttien(float tienrut) {
        if(this.tien<tienrut) throw new NoSuchElementException("tai khoan khong du tien");
        this.tien = this.tien - (tienrut + phirut);
        return tienrut;
    }

    public void daohan(){
        this.tien = this.tien + this.tien*laisuat;
    }
    // 
    public void chuyenkhoan(Account ac1,Account ac2,float tienchuyen){
        float tiensechuyen= ac1.ruttien(tienchuyen);
        ac2.naptien(tiensechuyen);
    }
}
