class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        Map<Character,Integer> char1=new HashMap<>();
        for(int i=26;i>0;i--){
            char c = (char) ('a' + i - 1);
            char1.put(c,27-i);
        }
        for(int j=1;j<=s.length();j++){
            char ch=s.charAt(j-1);
            sum+=j*char1.get(ch);
        }
        return sum;
    }
}