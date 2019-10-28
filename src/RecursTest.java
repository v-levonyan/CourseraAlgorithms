public class RecursTest {

    public void printRec(int n) {

        if (n == 0) return;
        printRec(n-1);
        System.out.println(n);
    }
}
