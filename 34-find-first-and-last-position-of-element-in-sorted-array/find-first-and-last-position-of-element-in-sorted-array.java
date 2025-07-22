class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a=-1;
        int b=-1;
        int num=nums.length;
        int count=0;
        int[] arr=new int[]{a,b};
        for(int i=0;i<num;i++){
            if(count==0){
                if(nums[i]==target){
                    a=i;
                    b=i;
                    count++;
                }
            }else{
                if(nums[i]==target){
                    b=i;

                }
            }
        }
        
        return new int[]{a,b};
    }
}