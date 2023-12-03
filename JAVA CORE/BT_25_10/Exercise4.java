public class Exercise4 {
    public static void main(String[] agrs) {
        Account ac1 = new Account(123, "lehuuloi", 10000);
        ac1.naptien(10000);
        System.out.println(ac1.toString());
        Account ac2 = new Account(12, "lehuuloi1", 10000);
        ac2.naptien(10000);
        ac1.chuyenkhoan(ac1, ac2, 10000);
        System.out.println(ac2.getTien());
        System.out.println(ac1.getTien());
    }
}
