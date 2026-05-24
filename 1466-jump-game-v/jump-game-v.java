class Solution {

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> arr[a] - arr[b]);

        int result = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (Math.abs(idx[i] - idx[j]) <= d
                        && arr[idx[i]] > arr[idx[j]]) {

                    boolean fl = true;
                    for (int k = Math.min(idx[i], idx[j]) + 1;
                         k < Math.max(idx[i], idx[j]);
                         k++) {

                        if (arr[k] >= arr[idx[i]]) {
                            fl = false;
                            break;
                        }
                    }

                    if (fl) {

                        dp[idx[i]] = Math.max(
                                dp[idx[i]],
                                dp[idx[j]] + 1
                        );
                    }
                }
            }

            result = Math.max(result, dp[idx[i]]);
        }

        return result;
    }
}