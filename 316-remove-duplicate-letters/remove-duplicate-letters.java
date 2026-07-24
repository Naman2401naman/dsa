class Solution {
    public String removeDuplicateLetters(String s) {
        int[] rec=new int[26];
        for(int i=0;i<s.length();i++){
            rec[s.charAt(i)-'a']=i;
        }
        boolean[] che=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
            if(che[s.charAt(i)-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch && rec[st.peek()-'a']>i){
                che[st.pop()-'a']=false;
            }
            st.push(ch);
            che[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<st.size();i++){
            sb.append(st.get(i));
        }
        return sb.toString();
    }
}