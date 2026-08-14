class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        int max=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            while(mp.get(nums[i])>k){
                int ch=nums[j];
                mp.put(ch,mp.get(ch)-1);
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}