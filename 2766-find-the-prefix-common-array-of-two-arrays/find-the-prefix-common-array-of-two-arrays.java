class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int count = 0;
        int n = A.length;

        int[] c = new int[n];

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);

            if (mp.get(A[i]) == 2) {
                count++;
            }

            mp.put(B[i], mp.getOrDefault(B[i], 0) + 1);

            if (mp.get(B[i]) == 2) {
                count++;
            }

            c[i] = count;
        }

        return c;
    }
}