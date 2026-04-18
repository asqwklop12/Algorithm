class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if(sub.length() < 3) continue;
                ans += check(sub);
            }
        }

        return ans;

    }

    public int check(String sub) {
        int[] abc = new int[26];

        for(int i = 0; i< sub.length();i++) {
            abc[sub.charAt(i) - 'a']++;
        }
        

        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<26;i++) {

            if(abc[i] == 0) {
                continue;
            }

            max = Math.max(abc[i],max);
            min = Math.min(abc[i],min);
        }

        if(max == min) {
            return 0;
        }

        return max - min;
    }
}
