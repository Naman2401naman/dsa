import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }
        
        // Step 2: Count total occurrences of elements with max frequency
        int result = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                result += f;
            }
        }
        
        return result;
    }
}
