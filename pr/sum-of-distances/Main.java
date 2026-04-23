import java.util.*;

class Solution {
    int n;
    public long[] distance(int[] nums) {
        n = nums.length;
        long[] ans = new long[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i<n;i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> arr : map.values()) {
            int size = arr.size();
            long[] prefix = new long[size+1];

            for (int i = 0; i < size; i++) {
                prefix[i + 1] = prefix[i] + arr.get(i);
            }

           
            for (int i = 0; i < size; i++) {
                long cur = arr.get(i);

                long left = cur * i - prefix[i];
                long right = (prefix[size] - prefix[i + 1]) - cur * (size - i - 1);

                ans[(int)cur] = left + right;
        
            }
        }



        return ans;
    }
}
