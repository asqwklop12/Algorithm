import java.util.Scanner;

public class Main {
    static int[] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n];
        action();
    }

    public static void action() {
        int result = chess(0);
        System.out.println(result);
    }

    public static int chess(int row) {
        if (row == board.length) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (check(row, col))
                continue;

            board[row] = col;
            count += chess(row + 1);
        }

        return count;
    }

    public static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col)
                return true;
            if (Math.abs(row - i) == Math.abs(col - board[i]))
                return true;
        }

        return false;
    }

}
