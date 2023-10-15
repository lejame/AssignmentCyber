import java.util.*;
public class Exercise1 {
    private static int nguoithang = 0;
    private static int maythang = 0;
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n ;
        do{
            System.out.print("Nhap n:");
            n = sc.nextInt();
            if(n==0){
                System.out.println("Nguoi thang:"+nguoithang);
                System.out.println("May thang:"+maythang);
                return;
            }
            Oantuti(n);
        }while(n!=0);

    }
    // giả sử bao = 1 , kéo  = 2, kim = 3
    public static void Oantuti(int nguoi){
        int may = (int)(Math.random()* 3) + 1;
        int ng = checknguoi(nguoi);
        if(ng>may){
            nguoithang++;
        }
        else if(may>ng){
            maythang++;
        }
        else{
            System.out.println("hoa");
        }
    }
    public static int checknguoi(int n){
        if(n>3){ return (int)(Math.random()* 3) + 1;}
        return n;
    }
}
