import java.util.*;

class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sorting helps in handling duplicates
        findSubsets(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);  
    }

    public void findSubsets(int[] nums, int index, List<Integer> sublist) {
        if (index == nums.length) {
            res.add(new ArrayList<>(sublist)); // Copy to avoid reference issues
            return;
        }

        // Include current element
        sublist.add(nums[index]);
        findSubsets(nums, index + 1, sublist);

        // Backtrack
        sublist.remove(sublist.size() - 1);

        // Exclude current element
        findSubsets(nums, index + 1, sublist);
    }
}
