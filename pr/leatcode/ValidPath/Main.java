import java.util.*;
class Solution {
    int[][] grid;
    boolean[][] visted;
    int n;
    int m;
    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.visted = new boolean[n][m];

        return bfs(0,0);
    }

    public boolean bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visted[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if(cx == n-1 && cy == m-1) {
                return true;
            }

            int[][] dirs = next(grid[cx][cy]);

        for (int[] dir : dirs) {
            int nx = cx + dir[0];
            int ny = cy + dir[1];



            if(nx < 0 || n <= nx) continue;
            if(ny < 0 || m <= ny) continue;
            if(visted[nx][ny]) continue;

            // 다음 칸이 현재 칸으로 다시 연결되는지 확인
            if (!canConnectBack(cx, cy, nx, ny)) continue;

            visted[nx][ny] = true;
            q.add(new int[]{nx,ny});
          }    

        }

        return false;
    }
    public boolean canConnectBack(int cx, int cy, int nx, int ny) {
        int[][] nextDirs = next(grid[nx][ny]);

        for (int[] dir : nextDirs) {
            int bx = nx + dir[0];
            int by = ny + dir[1];

            if (bx == cx && by == cy) {
                return true;
            }
        }
        return false;
    }
    
    public int[][] next(int locate) {
    switch (locate) {
        case 1: return new int[][]{{0, -1}, {0, 1}};   // 좌우
        case 2: return new int[][]{{-1, 0}, {1, 0}};   // 상하
        case 3: return new int[][]{{0, -1}, {1, 0}};   // 좌, 하
        case 4: return new int[][]{{0, 1}, {1, 0}};    // 우, 하
        case 5: return new int[][]{{0, -1}, {-1, 0}};  // 좌, 상
        case 6: return new int[][]{{0, 1}, {-1, 0}};   // 우, 상
        default: return new int[][]{};
    }
}
    
}
