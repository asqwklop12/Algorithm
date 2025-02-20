import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        Set<Integer> arr = new HashSet<>();

        while (x-- > 0) { 
            arr.add(sc.nextInt());
        }

        int r = sc.nextInt();
        int answer = 0;

        for (int num : arr) { 
            if (arr.contains(r - num)) {
                answer++;
            }
        }

        System.out.println(answer / 2);

    }


}