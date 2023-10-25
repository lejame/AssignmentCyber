public class Student {
    private int mssv;
    private String hoten;
    private float LT,TH;
    public Student() {
        this.mssv = 0 ;
        this.hoten = "";
        this.LT = 0;
        this.TH = 0;
    }
    public Student(int mssv, String hoten, float lT, float tH) {
        this.mssv = mssv;
        this.hoten = hoten;
        LT = lT;
        TH = tH;
    }
    public int getMssv() {
        return mssv;
    }
    public void setMssv(int mssv) {
        this.mssv = mssv;
    }
    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public float getLT() {
        return LT;
    }
    public void setLT(float lT) {
        LT = lT;
    }
    public float getTH() {
        return TH;
    }
    public void setTH(float tH) {
        TH = tH;
    }
    public double dtb(float LT,float TH){
        return (LT+TH)/2;
    }
}
