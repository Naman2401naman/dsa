class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==digitSum(nums[i])){

                return i;
            }
        }
        return -1;
    }
    int digitSum(int n){
        int m=n;
        int sum=0;
        while(m>0){
            sum+=m%10;
            m=m/10;
        }
        return sum;
    }
}