class Solution {
    
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        int n=nums.length;
        int q=queries.length;
        for(int i=0;i<q;i++){
            int idx=queries[i][0];
            while(idx<=queries[i][1]){
                nums[idx]=(int)((long)nums[idx]*queries[i][3]%mod);
                idx+=queries[i][2];
            }
        }
         int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}