import java.util.*;
class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    char[][] grid;
    boolean[][] visted;
    int n;
    int m;
    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
   

        this.n = grid.length;
        this.m = grid[0].length;

        visted = new boolean[n][m];

        
        for(int i = 0; i<n;i++) {
            for(int j = 0; j<m;j++) {

                if(visted[i][j]) continue;

                if(bfs(i,j)) {
                    return true;
                }
                

            }
        }

       

        return false;
        
    }

    boolean bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, -1, -1});
        visted[sx][sy] = true;

         while(!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int px = cur[2];
            int py = cur[3];


            visted[x][y] = true;

            // 이동
            for(int i = 0 ;i <4;i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                

                if(nx < 0 || n <= nx) continue;
                if(ny < 0 || m <= ny) continue;
                

                // 다른 알파벳인 경우에는 패스한다.
                if(grid[x][y] != grid[nx][ny]) continue;

                if(nx == px && ny == py) continue;

                if(visted[nx][ny]) {
                    return true;
                }

                visted[nx][ny] = true;
                q.add(new int[]{nx, ny, x, y});

            }

        }

        return false;

    }
}
