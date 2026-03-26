class Solution {
    public int strStr(String haystack, String needle) {
        int idx=kmp(needle,haystack);
        return idx;
    }
    int kmp(String needle,String haystack){
        int[] arr=build(needle);
        int i=0;
        int j=0;
        while(i < haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            if(j==needle.length()) return i-j;

            else if(i<haystack.length() && haystack.charAt(i)!=needle.charAt(j)){
                if(j!=0){
                    j=arr[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }

    int[] build(String needle ){
        int[] lps=new int[needle.length()];
        int i=1;
        int len=0;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}