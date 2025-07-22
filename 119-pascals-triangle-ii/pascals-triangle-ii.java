class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

            for (int j = 1; j < i; j++) {
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                row.set(j, val);
            }
             result.add(row);
        }
        List<Integer> ans=result.get(result.size()-1);
        return ans;
    }
}