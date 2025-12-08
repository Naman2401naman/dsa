class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
    void reverse(char[] cha,int left,int right){
        if(left>=right) return;
        char temp=cha[left];
        cha[left]=cha[right];
        cha[right]=temp;
        reverse(cha,left+1,right-1);
    }
}