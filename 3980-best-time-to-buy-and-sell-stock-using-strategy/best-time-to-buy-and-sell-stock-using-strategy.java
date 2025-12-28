class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {

        int n = strategy.length;

        int[] k1 = new int[k];
        for (int i = k / 2; i < k; i++) {
            k1[i] = 1;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) strategy[i] * prices[i];
        }

        long max = sum;

        long remove = 0;
        long add = 0;

        // initial window
        for (int j = 0; j < k; j++) {
            remove += (long) strategy[j] * prices[j];
            add += (long) k1[j] * prices[j];
        }

        max = Math.max(max, sum - remove + add);

        // sliding window
        for (int i = k; i < n; i++) {

            remove += (long) strategy[i] * prices[i];
            remove -= (long) strategy[i - k] * prices[i - k];

            add += (long) prices[i];          // enters last k/2
            add -= (long) prices[i - k / 2];  // exits last k/2

            max = Math.max(max, sum - remove + add);
        }

        return max;
    }
}
