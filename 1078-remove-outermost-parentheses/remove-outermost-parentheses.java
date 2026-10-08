class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder s1=new StringBuilder();
        int cou=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(cou>0){
                    s1.append(ch);
                }
                cou++;
            }else{
                cou--;
                if(cou>0){
                     s1.append(ch);
                }
               
            }
        }
        return s1.toString();
    }
}