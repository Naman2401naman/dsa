class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            int sum = 0;

            for (int j = 0; j < len; j++) {
                char s = words[i].charAt(j);
                int ad = s - 'a';
                int f = weights[ad];
                sum += f;
            }

            int mod = sum % 26;
            char mapped = (char)('z' - mod);
            ans.append(mapped);
        }

        return ans.toString();
    }
}