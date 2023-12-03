import java.util.Scanner;

public class Main {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 23, 1, 5, 22, 6, 8, 9, -3 };
        System.out.print("Nhập lựa chọn của bạn:");
        int n = sc.nextInt();
        input(n, arr);
    }

    /**
     * 
     */
    public static void input(int n,int [] arr) {

        switch (n) {
            case 1: {
                System.out.println("Result:" + cauB(arr));
                break;
            }
            case 2: {
                System.out.println("Result:" + cauC(arr));
                break;
            }
            case 3: {
                System.out.println("Result:" + cauD(arr));
                break;
            }
            case 4: {
                System.out.println("Result:" + cauE(arr));
                break;
            }
            case 5: {
                System.out.println("Result:" + cauF(arr));
                break;
            }
            case 6: {
                System.out.println("Result:" + cauG(arr));
                break;
            }
            case 7: {
                System.out.println("Result:" + cauH(arr));
                break;
            }
            case 8: {
                System.out.println("Result:" + cauI(arr));
                break;
            }
            case 9: {
                System.out.println("Result:" + cauJ(arr));
                break;
            }
            case 10: {
                System.out.println("Result:" + cauK(arr));
                break;
            }
            default:
                System.out.print("Nhập lại lựa chọn của bản");
        }
    }

    public static int cauB(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static int cauC(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static int cauD(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    public static int cauE(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int cauF(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] > 0) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int cauG(int[] arr) {
        if (!checkEven(arr)) {
            return -1;
        }
        int numberEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                numberEven = arr[i];
            }
        }
        return numberEven;
    }

    public static int cauH(int[] arr) {
        int numberEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                numberEven = arr[i];
                break;
            }
        }
        if (numberEven != 0) {
            return numberEven;
        }
        return -1;
    }

    public static int cauI(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (checkPrime(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int cauJ(int[] arr) {
        if (!checkPositivenumber(arr)) {
            return -1;
        }
        int positivenumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positivenumber = arr[i];
            }
        }
        return positivenumber;
    }

    public static int cauK(int[] arr) {
        if (!checkEven(arr)) {
            return -1;
        }
        int positivenumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] < positivenumber) {
                positivenumber = arr[i];
            }
        }
        return positivenumber;
    }

    public static int checkPrime(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return 1;
        }
        return 0;
    }

    public static boolean checkEven(int[] arr) {
        for (int a : arr) {
            if (a % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPositivenumber(int[] arr) {
        for (int a : arr) {
            if (a >= 0) {
                return true;
            }
        }
        return false;
    }
}