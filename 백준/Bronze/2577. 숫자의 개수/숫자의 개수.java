import java.util.*;

public class Main {

    static int[] arr = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        long newResult = (long) a * b * c;
        char[] str = String.valueOf(newResult).toCharArray();
        for (char ch : str) {
            arr[(int) ch - '0']++;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }


}