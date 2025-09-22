class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;  // ways to reach step 1
        int second = 2; // ways to reach step 2
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = first + second; // ways(n-1) + ways(n-2)
            first = second;         // move forward
            second = result;
        }

        return result;
    }
}
