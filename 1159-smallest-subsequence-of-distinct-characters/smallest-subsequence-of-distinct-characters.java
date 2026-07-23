class Solution {
    public String smallestSubsequence(String s) {
        int[] rec=new int[26];
        for(int i=0;i<s.length();i++){
            rec[s.charAt(i)-'a']=i;
        }
        boolean[] er=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(er[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && rec[st.peek()-'a']>i && st.peek()>ch){
                er[st.pop()-'a']=false;
            }
            st.push(s.charAt(i));
            er[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
         for(int i=0;i<st.size();i++){
                sb.append(st.get(i));
            }
        return sb.toString();
    }
}