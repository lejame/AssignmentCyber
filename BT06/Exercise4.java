public class Exercise4 {
    public static void main(String [] agrs){
        System.out.print("Result:"+sum(2,5));
    }
    public static int sum(int x,int n){
        int tong =  0;
        for(int  i = 1;i<=n;i++){
            tong+=(int) Math.pow(x, i);
        }
        return tong;
    }
}
