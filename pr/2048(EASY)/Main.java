import java.util.*;

public class Main {
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        board = new int[T][T];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solve();
        System.out.println(max);
    }

    public static void solve() {
        action(0, board);
    }

    public static void action(int count, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        if (count == 5) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 1. 보드 복사 (원본 보존을 위해)
            int[][] nextBoard = new int[board.length][board.length];
            for (int r = 0; r < board.length; r++)
                System.arraycopy(board[r], 0, nextBoard[r], 0, board.length);

            // 2. i 방향으로 밀기 (구현 필요)
            move(nextBoard, i);

            // 3. 다음 단계로 재귀 호출
            action(count + 1, nextBoard);

        }

    }

    public static int[][] move(int[][] board, int direction) {
        switch (direction) {
            // up
            case 0:
                return moveUp(board);
            // down
            case 1:
                return moveDown(board);
            // left
            case 2:
                return moveLeft(board);
            // right
            case 3:
                return moveRight(board);
        }
        return board;
    }

    public static int[][] moveUp(int[][] board) {
        for (int y = 0; y < board.length; y++) {
            List<Integer> list = new ArrayList<>();
            for (int x = 0; x < board.length; x++) {

                if (board[x][y] != 0) {
                    list.add(board[x][y]);
                }
                board[x][y] = 0;
            }

            // 2. 합치기 (Merge)
            int idx = 0; // 다시 채워넣을 위치 (위에서부터)
            for (int i = 0; i < list.size(); i++) {
                // 현재 숫자와 다음 숫자가 같으면 합침
                if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                    board[idx][y] = list.get(i) * 2;
                    i++; // 다음 숫자는 이미 합쳐졌으니 건너뜀
                } else {
                    board[idx][y] = list.get(i);
                }
                idx++;
            }

        }

        return board;

    }

    public static int[][] moveDown(int[][] board) {

        for (int y = 0; y < board.length; y++) {
            List<Integer> list = new ArrayList<>();
            for (int x = board.length - 1; x >= 0; x--) {

                if (board[x][y] != 0) {
                    list.add(board[x][y]);
                }
                board[x][y] = 0;
            }

            // 2. 합치기 (Merge)
            int idx = board.length - 1; // 다시 채워넣을 위치 (위에서부터)
            for (int i = 0; i < list.size(); i++) {
                // 현재 숫자와 다음 숫자가 같으면 합침
                if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                    board[idx][y] = list.get(i) * 2;
                    i++; // 다음 숫자는 이미 합쳐졌으니 건너뜀
                } else {
                    board[idx][y] = list.get(i);
                }
                idx--;
            }

        }

        return board;
    }

    public static int[][] moveLeft(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            List<Integer> list = new ArrayList<>();
            for (int y = 0; y < board.length; y++) {

                if (board[x][y] != 0) {
                    list.add(board[x][y]);
                }
                board[x][y] = 0;
            }

            // 2. 합치기 (Merge)
            int idy = 0; // 다시 채워넣을 위치 (위에서부터)
            for (int i = 0; i < list.size(); i++) {
                // 현재 숫자와 다음 숫자가 같으면 합침
                if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                    board[x][idy] = list.get(i) * 2;
                    i++; // 다음 숫자는 이미 합쳐졌으니 건너뜀
                } else {
                    board[x][idy] = list.get(i);
                }
                idy++;
            }

        }
        return board;
    }

    public static int[][] moveRight(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            List<Integer> list = new ArrayList<>();
            for (int y = board.length - 1; y >= 0; y--) {

                if (board[x][y] != 0) {
                    list.add(board[x][y]);
                }
                board[x][y] = 0;
            }

            // 2. 합치기 (Merge)
            int idy = board.length - 1; // 다시 채워넣을 위치 (위에서부터)
            for (int i = 0; i < list.size(); i++) {
                // 현재 숫자와 다음 숫자가 같으면 합침
                if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                    board[x][idy] = list.get(i) * 2;
                    i++; // 다음 숫자는 이미 합쳐졌으니 건너뜀
                } else {
                    board[x][idy] = list.get(i);
                }
                idy--;
            }

        }

        return board;
    }

    /**
     * 2 2 2
     * 4 4 4
     * 8 8 8
     */

    // 왼쪽, 오른쪽, 아래, 위로 움직일 수 있다.
    // 움직이면, 같은 숫자인 경우 합쳐지고, 다른 숫자라면 합쳐지지 않는다.
    // 최대 5번 움직일 수 있다.
    // 최대값을 구하라.

}
