import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();

        solve();

    }

    public static void solve() {
        int n = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                StringBuilder first = new StringBuilder(str.substring(0, i));
                StringBuilder second = new StringBuilder(str.substring(i, j));
                StringBuilder third = new StringBuilder(str.substring(j));
                list.add(first.reverse().toString() + second.reverse().toString() + third.reverse().toString());
            }

        }

        Collections.sort(list);

        System.out.println(list.get(0));

    }

}