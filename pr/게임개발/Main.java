import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        FastReader fr = new FastReader();
        int n = Integer.parseInt(fr.next());
        List<Integer>[] buildingInfo = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buildingInfo[i] = new ArrayList<>();
            while (fr.hasMoreTokens()) {
                int val = Integer.parseInt(fr.next());
                buildingInfo[i].add(val);
                if (val == -1)
                    break;
            }
        }
        int[] results = solve(n, buildingInfo);
        StringBuilder sb = new StringBuilder();
        for (int res : results) {
            sb.append(res).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class Building {
        int index;
        int time;

        List<int[]> prevBuildings;

        public Building(int index, int time) {
            this.index = index;
            this.time = time;
            this.prevBuildings = new ArrayList<>();
        }

        public void addPrevBuilding(int prevBuilding, int time) {
            this.prevBuildings.add(new int[] { prevBuilding, time });
        }
    }

    int[] memo;
    List<Building> buildings = new ArrayList<>();

    /**
     * 문제 해결 메서드
     * 
     * @param n            건물의 개수
     * @param buildingInfo 각 줄의 정보 (시간, 선행 건물들, -1이 포함된 리스트 배열)
     * @return 각 건물이 완성되는 최소 시간 배열
     */
    public int[] solve(int n, List<Integer>[] buildingInfo) {
        // buildingInfo[i]는 {시간, 선행1, 선행2, ..., -1} 형태의 List입니다.

        memo = new int[n];
        Arrays.fill(memo, -1);
        buildings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buildings.add(new Building(i, buildingInfo[i].get(0)));

            for (int k = 1; k < buildingInfo[i].size(); k++) {
                int prevBuilding = buildingInfo[i].get(k);
                if (prevBuilding == -1)
                    break;
                buildings.get(i).addPrevBuilding(prevBuilding - 1, buildingInfo[prevBuilding - 1].get(0));
            }
        }

        int[] totalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            totalTimes[i] = dfs(i);
        }

        return totalTimes;
    }

    public int dfs(int index) {
        if (memo[index] != -1)
            return memo[index];

        int maxPrev = 0;

        for (int[] prev : buildings.get(index).prevBuildings) {
            int prevIdx = prev[0];
            maxPrev = Math.max(maxPrev, dfs(prevIdx));
        }

        memo[index] = buildings.get(index).time + maxPrev;
        return memo[index];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public boolean hasMoreTokens() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                if (line == null)
                    return false;
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}
