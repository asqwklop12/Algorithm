import java.util.*;

class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        parent = new int[n];

        for(int i = 0; i<n;i++) {
            parent[i] = i;
        }
        for(int i = 0; i<n;i++) {
            for(int j = 0; j<m;j++) {
                if(isConnected[i][j] == 1) {
                    union(i,j);
                }

            }

        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }

        return set.size();
        
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb= find(b);

        if(pa != pb) {
            parent[pb] = pa;
        }

    }

    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
