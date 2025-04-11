import java.util.*;

class Solution {
    public int solution(String[] board) {
        int h = board.length;
        int w = board[0].length();
        int[][] dist = new int[h][w];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int startY = 0, startX = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (board[y].charAt(x) == 'R') {
                    startY = y;
                    startX = x;
                }
            }
        }

        // PriorityQueue - 이동 횟수 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{startY, startX, 0});
        dist[startY][startX] = 0;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int y = cur[0], x = cur[1], cnt = cur[2];

            if (board[y].charAt(x) == 'G') return cnt;

            if (cnt > dist[y][x]) continue; // 이미 더 빠른 경로로 온 경우 스킵

            for (int d = 0; d < 4; d++) {
                int ny = y, nx = x;

                while (true) {
                    int ty = ny + dy[d];
                    int tx = nx + dx[d];

                    if (ty < 0 || ty >= h || tx < 0 || tx >= w || board[ty].charAt(tx) == 'D') break;

                    ny = ty;
                    nx = tx;
                }

                if (dist[ny][nx] > cnt + 1) {
                    dist[ny][nx] = cnt + 1;
                    pq.offer(new int[]{ny, nx, cnt + 1});
                }
            }
        }

        return -1;
    }
}
