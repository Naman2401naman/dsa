class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // 1. Count characters of s
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        // 2. Check if palindrome is possible
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // 3. Characters needed for LEFT HALF
        int half = n / 2;

        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }

        /*
         * First check:
         * What if target's first half itself can be used?
         */
        int[] temp = halfCnt.clone();
        boolean possible = true;

        for (int i = 0; i < half; i++) {
            int c = target.charAt(i) - 'a';

            if (temp[c] == 0) {
                possible = false;
                break;
            }

            temp[c]--;
        }

        if (possible) {

            String left = target.substring(0, half);

            String candidate = makePalindrome(left, middle);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * 4. Try to make the LEFT HALF bigger.
         *
         * Start from right because we want the
         * smallest possible increase.
         */
        for (int i = half - 1; i >= 0; i--) {

            // Start again with all half characters
            int[] available = halfCnt.clone();

            // Use target's prefix [0 ... i-1]
            boolean possiblePrefix = true;

            for (int j = 0; j < i; j++) {

                int c = target.charAt(j) - 'a';

                if (available[c] == 0) {
                    possiblePrefix = false;
                    break;
                }

                available[c]--;
            }

            if (!possiblePrefix) {
                continue;
            }

            // Current character of target
            int cur = target.charAt(i) - 'a';

            // Find smallest character > target[i]
            int next = -1;

            for (int c = cur + 1; c < 26; c++) {
                if (available[c] > 0) {
                    next = c;
                    break;
                }
            }

            if (next == -1) {
                continue;
            }

            // Use next character
            available[next]--;

            // Build left half
            StringBuilder left = new StringBuilder();

            // Keep target prefix
            left.append(target.substring(0, i));

            // Put bigger character
            left.append((char) ('a' + next));

            // Put remaining characters in sorted order
            for (int c = 0; c < 26; c++) {
                while (available[c] > 0) {
                    left.append((char) ('a' + c));
                    available[c]--;
                }
            }

            // Make palindrome
            return makePalindrome(left.toString(), middle);
        }

        return "";
    }

    private String makePalindrome(String left, int middle) {

        StringBuilder ans = new StringBuilder();

        // Left half
        ans.append(left);

        // Middle character
        if (middle != -1) {
            ans.append((char) ('a' + middle));
        }

        // Reverse left half
        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString();
    }
}