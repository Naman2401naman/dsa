class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int pro=1;
        int n1=n;
        while(n1>0){
            int temp=n1%10;
            sum+=temp;
            pro*=temp;
            n1=n1/10;
        }
        int N=pro+sum;
        if(n%N==0){
            return true;
        }
        return false;
    }
}