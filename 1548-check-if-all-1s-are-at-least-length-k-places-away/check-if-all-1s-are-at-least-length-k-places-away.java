class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        ArrayList<Integer> idx=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                idx.add(i);
            }
        }
        for(int i=1;i<idx.size();i++){
            if((idx.get(i)-idx.get(i-1))-1 < k) return false;
        }
        return true;
    }
}