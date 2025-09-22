class Solution {
    public int smallestNumber(int n) {
        int add=0;
        int i=0;
        while(n>0){
            add+=Math.pow(2,i);
            i++;
            n=n>>1;
        }
        return add;
    }
}