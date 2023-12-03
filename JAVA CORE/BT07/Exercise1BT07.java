public class Exercise1BT07{
    public static void main(String[] agrs){
        int[] arr = {2, 3, 10};
        int maxNumber = numberMax(arr);
        System.out.println("So lon nhat trong 3 so: " + maxNumber);
    }
    public static int numberMax(int [] arr){
        int max = arr[0];
        for(int i = 1 ;i<arr.length ;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}