import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums)
            total += num;
        
        int target = (int)(total % p);
        if (target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // base case

        long prefix = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int curMod = (int)(prefix % p);
            int needed = (curMod - target + p) % p;

            if (map.containsKey(needed))
                minLen = Math.min(minLen, i - map.get(needed));

            map.put(curMod, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}
