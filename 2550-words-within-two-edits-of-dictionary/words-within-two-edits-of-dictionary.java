class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String q : queries) {
            for (String d : dictionary) {
                if (change(q, d) <= 2) {
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }

    int change(String s, String s1) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s1.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}