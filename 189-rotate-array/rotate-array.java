class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr=new int[k];
        int n=nums.length;
        k = k % n;
        for(int i=0;i<k;i++){
            arr[i]=nums[nums.length-k+i];
        }
        for(int i=nums.length-1;i>=k;i--){
            nums[i]=nums[i-k];
        }
        for(int i=0;i<k;i++){
            nums[i]=arr[i];
        }
    }
}