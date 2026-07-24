import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return 1;

        if (n == 2) {
            HashSet<Integer> set = new HashSet<>();
            for (int x : nums)
                set.add(x);
            return set.size();
        }

        HashSet<Integer> pair = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair.add(nums[i] ^ nums[j]);
            }
        }
        for (int p : pair) {
            for (int x : nums) {
                ans.add(p ^ x);
            }
        }

        return ans.size();
    }
}