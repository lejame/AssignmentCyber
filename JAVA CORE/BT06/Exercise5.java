public class Exercise5 {
    public static void main(String [] agrs){
        int money = 1000;
        System.out.print("So tien ma anh X nha duoc la:"+laiKep(money, 2));
    }
    public static int laiKep(int money,int year){
        int tong = 0;
        for(int i = 0;i<=year;i++){
            tong += money*0.1;
        }
        return money+tong;
    }
}
