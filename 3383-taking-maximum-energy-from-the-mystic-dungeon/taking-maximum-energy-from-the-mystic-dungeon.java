class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int max = Integer.MIN_VALUE;

        // Start from the last element and move backward
        for (int i = n - 1; i >= 0; i--) {
            // If jumping k steps is possible, add that value
            if (i + k < n) {
                energy[i] += energy[i + k];
            }
            // Keep track of the maximum value
            max = Math.max(max, energy[i]);
        }

        return max;
    }
}
