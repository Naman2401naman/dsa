class Solution {
    public boolean doesAliceWin(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='e' || ch=='a' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        } 
        if(count!=0) return true;
        return false;
    }
}