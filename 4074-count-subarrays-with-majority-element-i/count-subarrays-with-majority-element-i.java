class Solution {

    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            prefix[i + 1] = prefix[i] + val;
        }

        int shift = n + 1;
        int size = 2 * n + 5;

        Fenwick ft = new Fenwick(size);

        long ans = 0;

        // Initial prefix sum = 0
        ft.update(shift + 1, 1);

        for (int i = 1; i <= n; i++) {
            int idx = prefix[i] + shift + 1;

            // Count previous prefix sums smaller than current
            ans += ft.query(idx - 1);

            ft.update(idx, 1);
        }

        return (int) ans;
    }
}