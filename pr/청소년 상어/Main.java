import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    public void run() {
        FastReader fr = new FastReader();
                int[][] board = new int[4][8];
        for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 8; j++) {
        board[i][j] = Integer.parseInt(fr.next());
        }
        }
        System.out.println(this.solve(board));
    }
    class Fish {
        int num, x, y, dir;
        boolean isAlive;

        Fish(int num, int x, int y, int dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isAlive = true;
        }

        public void die() {
            this.isAlive = false;
        }
    }

    class Shark {
        int x, y, dir;

        Shark(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    public int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
    public int maxScore = 0;

    /**
     * 문제 해결 메서드
     * 
     * @param 문제에 맞는 파라미터들
     * @return 문제에 맞는 반환 타입
     */
    public int solve(int[][] board) {

        // 물고기가 있는곳
        int[][] map = new int[4][4];
        Fish[] fishs = new Fish[17];

        // 물고기를 넣어준다.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = board[i][j * 2];
                int dir = board[i][j * 2 + 1] - 1;
                fishs[num] = new Fish(num, i, j, dir);
                map[i][j] = num;
            }
        }

        Fish fish = fishs[map[0][0]];
        Shark shark = new Shark(fish.x, fish.y, fish.dir);
        fish.die();
        map[0][0] = -1;

        sharkMove(map, fishs, shark, fish.num);

        return maxScore;
    }

    public void fishMove(int[][] map, Fish[] fishs, Shark shark) {
        // 물고기 대 이동
        for (int i = 1; i <= 16; i++) {
            // 죽은 물고기는 움직일 수 없다.
            if (!fishs[i].isAlive)
                continue;

            for (int d = 0; d < 8; d++) {
                int nextDir = (fishs[i].dir + d) % 8;
                int nx = fishs[i].x + dx[nextDir];
                int ny = fishs[i].y + dy[nextDir];

                if (nx < 0 || 4 <= nx)
                    continue;
                if (ny < 0 || 4 <= ny)
                    continue;

                // 해당 위치에 상어가 있다면?
                if (map[nx][ny] == -1)
                    continue;

                // 물고기의 이동

                int targetNum = map[nx][ny];

                map[nx][ny] = fishs[i].num; // 내 자리가 됨
                map[fishs[i].x][fishs[i].y] = targetNum; // 원래 내 자리는 타겟번호(또는 빈칸)가 차지

                if (targetNum != 0) {
                    fishs[targetNum].x = fishs[i].x;
                    fishs[targetNum].y = fishs[i].y;
                }
                fishs[i].x = nx;
                fishs[i].y = ny;
                fishs[i].dir = nextDir;
                break;
            }

        }

    }

    public void sharkMove(int[][] map, Fish[] fishs, Shark shark, int currentScore) {
        maxScore = Math.max(maxScore, currentScore);
        fishMove(map, fishs, shark);
        for (int i = 1; i <= 3; i++) {
            int nx = shark.x + dx[shark.dir] * i;
            int ny = shark.y + dy[shark.dir] * i;

            if (nx < 0 || 4 <= nx)
                continue;
            if (ny < 0 || 4 <= ny)
                continue;

            if (map[nx][ny] == 0) {
                continue;
            }

            int[][] nextMap = new int[4][4];
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    nextMap[x][y] = map[x][y];
                }
            }

            Fish[] nextFishs = new Fish[17];
            for (int k = 1; k <= 16; k++) {
                if (fishs[k] != null) {
                    Fish f = fishs[k];
                    nextFishs[k] = new Fish(f.num, f.x, f.y, f.dir);
                    nextFishs[k].isAlive = f.isAlive; // 생존 여부도 꼭 챙기기!
                }
            }

            int eatNum = nextMap[nx][ny];
            Shark nextShark = new Shark(nx, ny, nextFishs[eatNum].dir);

            nextFishs[eatNum].die();
            nextMap[nx][ny] = -1;
            nextMap[shark.x][shark.y] = 0;

            sharkMove(nextMap, nextFishs, nextShark, currentScore + eatNum);

        }
    }

    static class FastReader {
        BufferedReader br; StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { } } return st.nextToken(); }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public boolean hasMoreTokens() { while (st == null || !st.hasMoreElements()) { String line = null; try { line = br.readLine(); } catch (IOException e) { } if (line == null) return false; st = new StringTokenizer(line); } return true; }
    }
}
