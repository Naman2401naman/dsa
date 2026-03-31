class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] char1 = new char[n + m - 1];

        // Step 1: fill with '?'
        for (int i = 0; i < char1.length; i++) {
            char1[i] = '?';
        }

        // Step 2: handle 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (char1[i + j] != '?' && char1[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    char1[i + j] = str2.charAt(j);
                }
            }
        }

        // Step 3: handle 'F' (FIXED PART)
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (char1[i + j] == '?' || char1[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // if exact match → break it
                if (match) {
                    boolean broken = false;

                    for (int k = m - 1; k >= 0; k--) {
                        int idx = i + k;

                        if (char1[idx] == str2.charAt(k)) {
                            for (char c = 'a'; c <= 'z'; c++) {
                                if (c != str2.charAt(k)) {
                                    char1[idx] = c;
                                    broken = true;
                                    break;
                                }
                            }
                        }

                        if (broken) break;
                    }

                    if (!broken) return "";
                }
            }
        }

        // Step 4: fill remaining '?' with 'a'
        for (int i = 0; i < char1.length; i++) {
    if (char1[i] == '?') {

        boolean placed = false;

        for (char c = 'a'; c <= 'z'; c++) {

            char1[i] = c;
            boolean valid = true;

            // check all substrings affected by this position
            for (int start = Math.max(0, i - m + 1); start <= Math.min(i, n - 1); start++) {

                String sub = new String(char1, start, m);

                if (str1.charAt(start) == 'T' && !sub.equals(str2)) {
                    valid = false;
                    break;
                }

                if (str1.charAt(start) == 'F' && sub.equals(str2)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                placed = true;
                break;
            }
        }

        if (!placed) return "";
    }
}

        // Step 5: final validation
        for (int i = 0; i < n; i++) {
            String sub = new String(char1, i, m);
            if (str1.charAt(i) == 'T' && !sub.equals(str2)) return "";
            if (str1.charAt(i) == 'F' && sub.equals(str2)) return "";
        }

        return new String(char1);
    }
}