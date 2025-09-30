class Solution {
    public int minMaxGame(int[] nums) {
        int n=nums.length;
        
        while(n>1){
            int[] arr=new int[n/2];
            for(int i=0;i<n/2;i++){
                if(i%2==0){
                    arr[i]= Math.min(nums[2*i],nums[2*i+1]);
                }else{
                    arr[i]= Math.max(nums[2*i],nums[2*i+1]);
                }              
            }
           nums=arr;
           n=nums.length;
        }
        return nums[0];
    }
}