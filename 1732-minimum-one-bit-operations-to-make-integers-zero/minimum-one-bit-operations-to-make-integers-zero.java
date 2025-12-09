class Solution {
    public int minimumOneBitOperations(int n) {
        int s=1;
        int count=0;
        while(n!=0){
            if(n%2!=0){
                count=(2*s-1)-count;
            }
            s=s*2;
            n=n>>1;
        }
        return count;
    }
}