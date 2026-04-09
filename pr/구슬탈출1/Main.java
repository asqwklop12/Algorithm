import java.util.*;

public class Solution {
    int n, m;

    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };
    char[][] board;
    boolean[][][][] visited;

    public boolean solve(char[][] board) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m][n][m];

        int rx = -1, ry = -1, bx = -1, by = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        return bfs(rx, ry, bx, by);
    }

    boolean bfs(int rx, int ry, int bx, int by) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { rx, ry, bx, by, 1 });
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int crx = cur[0];
            int cry = cur[1];

            int cbx = cur[2];
            int cby = cur[3];
            int cnt = cur[4];

            if (cnt >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nrx = crx;
                int nry = cry;

                int rm = 0;
                while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    rm++;

                    if (board[nrx][nry] == 'O') {
                        break;
                    }
                }

                int nbx = cbx;
                int nby = cby;
                int bm = 0;
                while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    bm++;

                    if (board[nbx][nby] == 'O') {
                        break;
                    }

                }
                if (board[nbx][nby] == 'O') {
                    continue;
                }

                if (board[nrx][nry] == 'O') {
                    return true;
                }

                // 겹치는 경우
                if (nrx == nbx && nry == nby) {
                    // 빨간공이 파란공보다 앞서는경우
                    if (rm > bm) {
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
        return false;
    }
}
