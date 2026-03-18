class Solution {
    public int findUnsortedSubarray(int[] nums){
        int start=-1;
        int end=-1;
        int i=nums.length-1;
        int j=0;
        while(j<nums.length-1 && nums[j]<=nums[j+1]){
            j++;
        }
        if(j==nums.length-1) return 0;
        start=j;
        while(i>0 && nums[i]>=nums[i-1]){
            i--;
        }
        end=i;

        int mini=Integer.MAX_VALUE;
        int maxa=Integer.MIN_VALUE;
        for(int i1=start;i1<=end;i1++){
            mini = Math.min(mini, nums[i1]);
            maxa = Math.max(maxa, nums[i1]);
        }
         
        while(j>0 && nums[j-1]>mini){
            j--;
        }
        while(i<nums.length-1 && nums[i+1]<maxa){
            i++;
        }
        return i-j+1;
    }
}