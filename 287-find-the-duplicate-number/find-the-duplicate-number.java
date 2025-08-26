class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] seen=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(seen[num]){
                return num;
            }
            seen[num]=true;
        }
        return 0;
    }
}