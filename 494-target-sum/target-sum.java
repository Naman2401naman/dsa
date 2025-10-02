import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return recur(nums, target, 0, 0, memo);
    }

    int recur(int[] nums, int target, int idx, int sum, Map<String, Integer> memo) {
        // Base case
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Create a unique key for the state
        String key = idx + "," + sum;

        // If already computed, return stored result
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive choices
        int add = recur(nums, target, idx + 1, sum + nums[idx], memo);
        int sub = recur(nums, target, idx + 1, sum - nums[idx], memo);

        // Store result in map
        memo.put(key, add + sub);

        return memo.get(key);
    }
}
