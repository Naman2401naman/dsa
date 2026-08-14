class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int max=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            while(mp.get(s.charAt(i))>2){
                char ch=s.charAt(j);
                mp.put(ch,mp.get(ch)-1);
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}