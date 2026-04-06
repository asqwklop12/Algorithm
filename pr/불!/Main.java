import java.io.*;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }
        String input = sb.toString().trim();
        Solution sol = new Solution();
        Parse parser = new Parse();
        String result = parser.parseAndCallSolve(sol, input);
        System.out.println(result);
    }
}

// ===== Solution =====

class Solution {
    char[][] board;
    boolean[][] visited;

    int r;
    int c;

    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    int[][] fireTime;

    public String solve(char[][] board) {
        this.r = board.length;
        this.c = board[0].length;
        this.board = board;
        this.visited = new boolean[r][c];
        this.fireTime = new int[r][c];
        Queue<int[]> fq = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            Arrays.fill(fireTime[i], -1);
        }

        int jx = -1;
        int jy = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'F') {
                    fq.add(new int[] { i, j });
                    fireTime[i][j] = 0;
                }

                if (board[i][j] == 'J') {
                    jx = i;
                    jy = j;
                }
            }
        }

        fire(fq);
        int result = bfs(jx, jy);
        if (result != -1) {
            return String.valueOf(result);
        }

        return "IMPOSSIBLE";
    }

    private void fire(Queue<int[]> q) {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || r <= nx)
                    continue;
                if (ny < 0 || c <= ny)
                    continue;

                if (board[nx][ny] == '#')
                    continue;

                if (fireTime[nx][ny] != -1)
                    continue;

                fireTime[nx][ny] = fireTime[x][y] + 1;
                q.add(new int[] { nx, ny });
            }
        }

    }

    private int bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { x, y, 0 });
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            int curTime = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                int nextTime = curTime + 1;

                if (nx < 0 || r <= nx || ny < 0 || c <= ny) {
                    return nextTime;
                }

                if (board[nx][ny] == '#')
                    continue;

                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= nextTime)
                    continue;

                if (visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                q.add(new int[] { nx, ny, nextTime });
            }
        }

        return -1;

    }
}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = st.nextToken().toCharArray();
        }
        return sol.solve(board);
    }
}
