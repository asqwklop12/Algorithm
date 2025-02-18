import java.util.Scanner;

public class Main {
    // 97이 a
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        int[] result = new int[26];
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 97);
            for (char c : charArray) {
                if(ch == c) {
                    result[i]++;
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
