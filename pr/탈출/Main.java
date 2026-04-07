import java.io.*;
import java.util.*;
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
    int R, C;
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    int[][] water;
    char[][] board;
    boolean[][] visited;

    public String solve(char[][] board) {
        R = board.length;
        C = board[0].length;
        this.board = board;

        water = new int[R][C];
        visited = new boolean[R][C];

        Queue<int[]> wq = new ArrayDeque<>();

        int gx = -1;
        int gy = -1;

        for (int i = 0; i < R; i++) {
            Arrays.fill(water[i], -1);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (board[i][j] == '*') {
                    wq.add(new int[] { i, j });
                    water[i][j] = 0;
                }

                if (board[i][j] == 'S') {
                    gx = i;
                    gy = j;
                }
            }
        }

        waterBfs(wq);

        int ans = gBfs(gx, gy);

        if (ans != -1) {
            return String.valueOf(ans);
        }

        return "KAKTUS";
    }

    public int gBfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { x, y, 0 });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];
            int ct = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nt = ct + 1;

                if (nx < 0 || R <= nx)
                    continue;
                if (ny < 0 || C <= ny)
                    continue;
                if (board[nx][ny] == 'X')
                    continue;

                if (visited[nx][ny])
                    continue;

                if (board[nx][ny] == 'D') {
                    return nt;
                }

                if (water[nx][ny] != -1 && water[nx][ny] <= nt)
                    continue;

                visited[nx][ny] = true;

                q.add(new int[] { nx, ny, nt });

            }
        }

        return -1;
    }

    public void waterBfs(Queue<int[]> wq) {
        while (!wq.isEmpty()) {
            int[] cur = wq.poll();

            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || R <= nx)
                    continue;
                if (ny < 0 || C <= ny)
                    continue;
                if (board[nx][ny] == 'X')
                    continue;

                if (board[nx][ny] == 'D') {
                    continue;
                }

                if (water[nx][ny] != -1)
                    continue;

                water[nx][ny] = water[cx][cy] + 1;
                wq.add(new int[] { nx, ny });
            }
        }
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
