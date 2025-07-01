class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combSum(candidates, 0, new ArrayList<>(), result, target);
        return result;
    }

    private void combSum(int[] arr, int index, List<Integer> comb, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        if (index >= arr.length || target < 0) {
            return;
        }

        // Include current element (can be reused)
        comb.add(arr[index]);
        combSum(arr, index, comb, result, target - arr[index]);

        // Backtrack
        comb.remove(comb.size() - 1);

        // Skip current element
        combSum(arr, index + 1, comb, result, target);
    }
}
