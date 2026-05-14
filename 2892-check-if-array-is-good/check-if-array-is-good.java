class Solution {

    public boolean isGood(int[] nums) {

        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        // Frequency count
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // Check 1 to n-2 appears once
        for(int i = 1; i <= n-2; i++) {

            if(!map.containsKey(i) || map.get(i) != 1) {
                return false;
            }
        }

        // Check n-1 appears twice
        if(!map.containsKey(n-1) || map.get(n-1) != 2) {
            return false;
        }

        return true;
    }
}