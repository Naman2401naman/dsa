class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int idx=Math.floorMod((i+nums[i]),nums.length);
            result[i]=nums[idx];
        }
        return result;
    }
}