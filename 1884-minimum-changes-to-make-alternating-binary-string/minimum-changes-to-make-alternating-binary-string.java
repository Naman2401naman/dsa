class Solution {
    public int minOperations(String s) {
        int zero=0;
        int one =0;

        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i)=='0'){
                one++;
            }else{
                zero++;
            }
        }
        for(int i=1;i<s.length();i+=2){
            if(s.charAt(i)=='0'){
                zero++;
            }else{
                one++;
            }
        }
        return Math.min(one , zero);
    }
}