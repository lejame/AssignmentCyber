import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhap n:");
            n = sc.nextInt();
        } while (n == 0);
        System.out.println("Result:"+sumNumberold(n));
    }

    public static int sumNumberold(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i = i + 2) {
            sum += i;
        }
        return sum;
    }
}
