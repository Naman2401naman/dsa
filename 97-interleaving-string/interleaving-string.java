class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {

        // length check
        if (s1.length() + s2.length() != s3.length())
            return false;

        // dp[i][j] = -1 (unknown), 0 (false), 1 (true)
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s1, s2, s3, dp);
    }

    boolean solve(int i, int j, String s1, String s2, String s3, int[][] dp) {

        // if already solved, return stored answer
        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        int k = i + j;

        // base case
        if (k == s3.length()) {
            boolean res = (i == s1.length() && j == s2.length());
            dp[i][j] = res ? 1 : 0;
            return res;
        }

        boolean ok = false;

        // take from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ok = solve(i + 1, j, s1, s2, s3, dp);
        }

        // take from s2
        if (!ok && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ok = solve(i, j + 1, s1, s2, s3, dp);
        }

        dp[i][j] = ok ? 1 : 0;
        return ok;
    }
}
