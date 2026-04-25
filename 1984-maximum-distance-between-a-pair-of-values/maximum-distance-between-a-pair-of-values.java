class Solution {
    int binary(int start,int end,int val,int[] nums2){
        int best=start;
        while(start<=end){
            int mid=start+ (end-start)/2;
            if(nums2[mid]>=val){
                best=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return best;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
       int ans=0;
       for(int i=0;i<nums1.length;i++){
            int ne=binary(i,nums2.length-1,nums1[i],nums2);
            ans=Math.max(ne-i,ans);
       }
       return ans;
    }
}