class Solution {
    public String reverseParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                st.push(ans.length());
                i++;

            } 
            else if (s.charAt(i) == ')') {
                int idx = st.pop();
                reverse(ans, idx, ans.length() - 1);
                i++;
            } 
            else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }

    private void reverse(StringBuilder sb, int left, int right) {

        while (left < right) {

            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }
    }
}