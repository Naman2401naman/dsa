class Solution {
        public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        // Step 2: check triples
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i < list.size() - 2; i++) {
                    int dist = 2 * (list.get(i + 2) - list.get(i));
                    min = Math.min(min, dist);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}