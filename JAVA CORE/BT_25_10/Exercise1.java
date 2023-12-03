import java.util.NoSuchElementException;
// bài 1 và 2 giống nhau nên em làm 1 bài nha a
public class Exercise1{
    private double a,b,c;

    public Exercise1() {
    }

    public Exercise1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double delta(double a,double b,double c){
        return Math.sqrt(Math.pow(b, 2)-4*a*c);
    }
    // đề không yêu cầu nên em làm phương trình đặc biệt khi delta = 0
    public double nghiem(double a,double b,double c){
        double delta = delta(a, b, c);
        if(delta==0){
            return -b/(2*a);
        }
        else{
            throw new NoSuchElementException("khong phai truong hop dac biet");
        }
    }
}