class Solution {
    public int maximumGain(String s, int x, int y) {
        int total=0;
        if( x > y ){
            total+=max(s,'a','b',x);
            s=removestring(s,'a','b');
            total+=max(s,'b','a',y);
        }else{
            total+=max(s,'b','a',y);
            s=removestring(s,'b','a');
            total+=max(s,'a','b',x);
        }
        return total;
    }
    static int max(String s,char first,char second,int pts){
        Stack<Character> st=new Stack<>();
       int ans=0;
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==first && c==second){
                st.pop();
                ans=ans+pts;
            }else{
                st.push(c);
            }
        }
        return ans;
    }
    static String removestring(String s,char first,char second){
        Stack<Character> stack=new Stack<>();
        StringBuilder result=new StringBuilder();
        for(char ch : s.toCharArray()){
             if(!stack.isEmpty() && stack.peek()==first && ch==second){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
         return result.reverse().toString();
    }
    

}