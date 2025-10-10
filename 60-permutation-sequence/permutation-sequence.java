class Solution {
    int count = 0; // global counter for recursion

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;

        int ic = 0; // starting index
        while (k > fact(n - 1)) {  // adjust k and index count
            k = k - fact(n - 1);
            ic++;
        }

        return generate(arr, "", k, ic);
    }

    public int fact(int n) {
        if (n < 2) return 1;
        return n * fact(n - 1);
    }

    private String generate(int[] arr, String current, int k, int ic) {
        if (current.length() == arr.length) {
            count++;
            if (count == k) return current;
            return "";
        }

        for (int i = ic; i < arr.length; i++) {
            if (arr[i] == -1) continue; // skip used numbers

            int temp = arr[i];
            arr[i] = -1; // mark as used
            String result = generate(arr, current + temp, k, 0); // restart from 0 in next level
            arr[i] = temp; // backtrack

            if (!result.isEmpty()) return result;
        }
        return "";
    }
}
