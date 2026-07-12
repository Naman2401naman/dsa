class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] a = Arrays.copyOf(arr, arr.length);
        Arrays.sort(a);

        Map<Integer, Integer> mp = new HashMap<>();

        int rank = 1;

        for (int x : a) {
            if (!mp.containsKey(x)) {
                mp.put(x, rank++);
            }
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = mp.get(arr[i]);
        }

        return ans;
    }
}