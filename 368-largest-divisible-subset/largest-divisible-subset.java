class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] idx=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            idx[i]=i;
            int j=i-1;
            while(j>=0){
                if(nums[i]%nums[j]==0 || nums[j]%nums[i]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        idx[i]=j;
                    }
                }
                j--;
            }
        }
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> ls=new ArrayList<>();
        while(idx[maxIndex]!=maxIndex){
            ls.add(nums[maxIndex]);
            maxIndex=idx[maxIndex];
        }
        ls.add(nums[maxIndex]);
        Collections.reverse(ls);
        return ls;
    }
}