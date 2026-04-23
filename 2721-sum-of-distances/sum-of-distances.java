class Solution {
    public long[] distance(int[] nums) {
        long[] ans=new long[nums.length];
        int n=nums.length;
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.computeIfAbsent(nums[i],k->new ArrayList()).add(i);
        }

        for(List<Integer> pos:mp.values()){
            long sum=0;
           
            for(int x:pos) sum+=x;

            long leftSum=0;
            int m=pos.size();

            for(int i=0;i<m;i++){
                long RightSum=sum-leftSum-pos.get(i);
                long left =(long)pos.get(i)*i-leftSum;
                long right=RightSum-(long)pos.get(i)*(m-i-1);
                ans[pos.get(i)]=left+right;
                leftSum+=pos.get(i);

            }
        }
        return ans;
    }
}