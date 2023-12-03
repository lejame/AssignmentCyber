public class Exercise2 {
    public static void main(String[] agrs){
        System.out.println("Result:"+findN());
    }
    public static int findN(){
        int sum = 0;
        int i = 0;
        for(;i<=10000;i++){
            if(sum>10000){
                return i;
            }
            sum +=i;
        }
        return i;
    }
}
