class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int m = Integer.MIN_VALUE;

        for (int i = 0; i < trips.length; i++) {
            m = Math.max(m, trips[i][2]);
        }

        int[] ans = new int[m];
        int[] diff = new int[m + 1];

        for (int i = 0; i < trips.length; i++) {
            diff[trips[i][1]] += trips[i][0];
            diff[trips[i][2]] -= trips[i][0];
        }

        ans[0] = diff[0];

        for (int i = 1; i < m; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }

        for (int i = 0; i < m; i++) {
            if (ans[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}