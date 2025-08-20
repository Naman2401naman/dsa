class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s=s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i=0;
        long num=0;

        int sign=1;
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){
            sign=(s.charAt(i)=='-')?-1:1;
            i++;
        }
        for(int j=i;j<s.length();j++){
            char ch =s.charAt(j);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');

                // overflow check
                if (sign == 1 && num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && -num < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;  // stop if non-digit is found
            }
        }
         return (int)(sign*num);
    }
}