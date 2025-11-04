import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] arrSum = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            // Count frequency in the current window
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            // Convert to list for sorting
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

            // Sort by frequency (descending), then by key (descending)
            list.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                } else {
                    return b.getKey() - a.getKey();
                }
            });

            // Take sum of top x keys
            int sum = 0;
            for (int k1 = 0; k1 < Math.min(list.size(), x); k1++) {
               Map.Entry<Integer, Integer> entry = list.get(k1);
                sum += entry.getKey() * entry.getValue();
            }

            arrSum[i] = sum;
        }

        return arrSum;
    }
}
