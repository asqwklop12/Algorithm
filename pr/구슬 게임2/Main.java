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
    int n;
    int m;

    char[][] board;

    // 방향만 지정
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    boolean[][][][] visited;

    public int solve(char[][] board) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m][n][m];

        int[] red = new int[2];
        int[] blue = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
                if (board[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }

        return bfs(red, blue);
    }

    int bfs(int[] red, int[] blue) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { red[0], red[1], blue[0], blue[1], 1 });
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int rx = cur[0];
            int ry = cur[1];
            int bx = cur[2];
            int by = cur[3];
            int cnt = cur[4];

            if (cnt > 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nrx = rx;
                int nry = ry;
                int nbx = bx;
                int nby = by;
                int rDist = 0;

                while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    rDist++;

                    if (board[nrx][nry] == 'O') {
                        break;
                    }
                }

                int bDist = 0;
                while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    bDist++;
                    if (board[nbx][nby] == 'O') {
                        break;
                    }
                }

                if (board[nbx][nby] == 'O') {
                    continue;
                }
                if (board[nrx][nry] == 'O') {
                    return cnt;
                }

                if (nrx == nbx && nry == nby) {
                    if (rDist > bDist) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if (visited[nrx][nry][nbx][nby]) {
                    continue;
                }
                visited[nrx][nry][nbx][nby] = true;
                q.add(new int[] { nrx, nry, nbx, nby, cnt + 1 });

            }

        }

        return -1;
    }

}

// ===== Parse =====

class Parse {
    public String parseAndCallSolve(Solution sol, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = st.nextToken();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        return String.valueOf(sol.solve(board));
    }
}
