import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(solve(str));

    }

    public static String solve(String str) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                flag = true;

                while (!stack.isEmpty()) {
                    result += stack.pop();
                }
                result += ch;
                continue;
            }

            if (ch == '>') {
                flag = false;
                result += ch;
                continue;
            }

            if (flag) {
                result += ch;
                continue;
            }

            if (ch == ' ') {
                while (!stack.isEmpty()) {
                    result += stack.pop();
                }
                result += ch;
            } else {
                stack.push(ch);
            }

        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}
