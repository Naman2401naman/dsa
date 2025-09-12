class Solution {
    public boolean doesAliceWin(String s) {
       
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='e' || ch=='a' || ch=='i' || ch=='o' || ch=='u'){
                return true;
            }
        } 
        return false; 
    }
}