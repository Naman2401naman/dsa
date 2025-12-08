class Solution {
    public void nextPermutation(int[] A) {
        int n = A.length;
        int pivot = -1;

        // ---------- STEP 1: Find the pivot ----------
        // Find first index from right where A[i] < A[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot -> array is descending -> reverse whole array
        if (pivot == -1) {
            reverse(A, 0, n - 1);
            return;
        }

        // ---------- STEP 2: Find next greater element and swap ----------
        for (int i = n - 1; i > pivot; i--) {
            if (A[i] > A[pivot]) {
                swap(A, i, pivot);
                break;
            }
        }

        // ---------- STEP 3: Reverse suffix (pivot+1 to end) ----------
        reverse(A, pivot + 1, n - 1);
    }

    // Utility: swap elements
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Utility: reverse a portion of the array
    private void reverse(int[] A, int left, int right) {
        while (left < right) {
            swap(A, left, right);
            left++;
            right--;
        }
    }
}
