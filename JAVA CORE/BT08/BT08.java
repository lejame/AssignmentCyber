import java.util.Scanner;

public class BT08 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input type of car:");
        String type = sc.nextLine();
        System.out.print("Input long:");
        int km = sc.nextInt();
        System.out.print("Input time:");
        int time = sc.nextInt();
        System.out.print("The total that you have to pay:"+Grab(type, km, time));
    }

    public static int Grab(String type, int km, int time) {
        int timeCar = 2000;
        int timeSuv = 3000;
        int timeBlack = 3500;
        if (type.toLowerCase().equals("grab car")) {
            return wattingTime(time, timeCar) + GrabCar(km);
        } else if (type.toLowerCase().equals("grab suv")) {
            return wattingTime(time, timeSuv) + GrabSuv(km);
        } else {
            return wattingTime(time, timeBlack) + GrabBlack(km);
        }
    }

    public static int wattingTime(int time, int money) {
        return (time / 3) * money;
    }

    public static int GrabCar(int km) {
        if (km == 1) {
            return 8000;
        } else if (km <= 19) {
            return (km - 1) * 7500 + 8000;
        } else {
            return 8000 + 18 * 7500 + (km - 19) * 7000;
        }
    }

    public static int GrabSuv(int km) {
        if (km == 1) {
            return 9000;
        } else if (km <= 19) {
            return (km - 1) * 8500 + 9000;
        } else {
            return 9000 + 18 * 8500 + (km - 19) * 8000;
        }
    }

    public static int GrabBlack(int km) {
        if (km == 1) {
            return 10000;
        } else if (km <= 19) {
            return (km - 1) * 9500 + 10000;
        } else {
            return 10000 + 18 * 9500 + (km - 19) * 9000;
        }
    }
}