public class Main {
    public static void main(String[] agrs) {

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
        int numberEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                numberEven = arr[i];
            }
        }
        if (numberEven == 0) {
            return -1;
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
        if(numberEven!=0){return numberEven;}
        return -1;
    }
}