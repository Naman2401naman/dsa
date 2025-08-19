class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max++;
            }else{
                count=count+((max)*(max+1))/2;
                max=0;
            }
            if(i==nums.length-1 && max!=0){
                count=count+((max)*(max+1))/2;
                
            }
            
        }
        return count;
    }
}
