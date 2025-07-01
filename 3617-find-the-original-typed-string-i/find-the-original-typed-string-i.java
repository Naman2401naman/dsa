class Solution {
    public int possibleStringCount(String word) {
        int res=1;
        int i=0;
        char cur;
        int val;
        while(i<word.length()){
            val=1;
            cur=word.charAt(i);
            while(i<word.length()-1 && cur==word.charAt(i+1)){
                val++;
                i++;
            }
            i++;
            res+=val-1;

        }
        return res;
    }
}