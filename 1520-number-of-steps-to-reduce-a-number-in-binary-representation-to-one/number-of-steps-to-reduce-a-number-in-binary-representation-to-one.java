class Solution {
    public int numSteps(String s) {

        int steps = 0;
        StringBuilder sb = new StringBuilder(s);

        while (!sb.toString().equals("1")) {

            if (sb.charAt(sb.length() - 1) == '0') {
                // even → divide by 2
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // odd → add 1 (binary addition)
                int i = sb.length() - 1;

                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }

                if (i < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }
            }

            steps++;
        }

        return steps;
    }
}