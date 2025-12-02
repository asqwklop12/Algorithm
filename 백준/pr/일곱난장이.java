import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(sc.nextInt());
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += list.get(i);
        }

        boolean found = false;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - list.get(i) - list.get(j) == 100) {
                    // Remove the element at the larger index first
                    list.remove(j);
                    list.remove(i);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        Collections.sort(list);

        for (int i : list) {
            System.out.println(i);
        }
    }
}
