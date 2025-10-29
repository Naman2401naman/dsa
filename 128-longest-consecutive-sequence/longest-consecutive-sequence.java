import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums); // O(n log n)

        int max = 1;
        int count = 1;

        // Iterate through the sorted array
        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Check for consecutive
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                // Sequence is broken, reset count
                count = 1;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}