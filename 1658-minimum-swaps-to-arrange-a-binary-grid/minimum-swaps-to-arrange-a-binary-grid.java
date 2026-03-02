class Solution {
    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int[] arr = new int[n];

        // Step 1: Count trailing zeros
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            arr[i] = count;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {

            int required = n - 1 - i;
            int pos = -1;

            // Find valid row
            for (int j = i; j < n; j++) {
                if (arr[j] >= required) {
                    pos = j;
                    break;
                }
            }

            if (pos == -1) return -1;

            // Count swaps directly
            result += (pos - i);

            // Shift elements instead of multiple swaps
            int temp = arr[pos];
            for (int j = pos; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = temp;
        }

        return result;
    }
}