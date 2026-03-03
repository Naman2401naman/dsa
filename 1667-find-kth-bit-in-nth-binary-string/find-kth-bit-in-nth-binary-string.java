class Solution {
    public char findKthBit(int n, int k) {
        
        String ch=find(n-1);
        return ch.charAt(k-1);
    }
    String find(int n){
        if(n==0){
            return "0";
        }
        String s=find(n-1);
        String s1=s+"1"+inverse(s);
        return s1;
    }

    String inverse(String s){
        StringBuilder st=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                st.append("1");
            }else{
                st.append("0");
            }
        }
        return st.reverse().toString();
    }
}