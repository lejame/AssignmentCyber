import java.util.*;
public class Exercise4BT07{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        System.out.print("input sigh:");
        int n = sc.nextInt();
        System.out.print("input S1:");
        int s1 = sc.nextInt();
        System.out.print("input S2:");
        int s2 = sc.nextInt();
        System.out.print("Result:"+Sigh(n,s1,s2));

    }
    public static int Sigh(int n,int s1,int s2){
        if(n>4) throw new NoSuchElementException("No matching sigh");
        if(n == 1){return s1+s2;}
        else if(n ==2){return s1-s2;}
        else if(n==3){return s1*s2;}
        else{return s2<0?-1:s1/s2;}
    }

}
