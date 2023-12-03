public class Main {
    public static void main(String [] agrs){
        Student st = new Student("Le Huu Loi", "123123", 7, 5, 5);
        System.out.println(st.toString());
        System.out.print(""+st.xepLoai(st.diemtrungbinh()));
    }
}
