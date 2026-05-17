import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            // Check if any number in window is within valueDiff
            Long ceil  = window.ceiling(num - valueDiff);  // closest >= num-valueDiff
            Long floor = window.floor(num + valueDiff);    // closest <= num+valueDiff

            if (ceil != null && ceil <= num + valueDiff)
                return true;

            window.add(num);

            // Remove element that is now out of index window
            if (i >= indexDiff)
                window.remove((long) nums[i - indexDiff]);
        }
        return false;
    }
}