class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        List<Integer> answer = new ArrayList<>(
                Collections.nCopies(n, 0)
        );

        if (n == 0) {
            return answer;
        }
        Map<Integer,Integer> mp=new HashMap<>();
        int count=1;
        int[] arr=nums.clone();
        Arrays.sort(arr);
        for(int i=0;i<nums.length;i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i],count);
                count++;
            }
        }
        int distCount=count-1;
        FenWickTree bit=new FenWickTree(distCount);
        for(int i=n-1;i>=0;i--){
            int curr=mp.get(nums[i]);
            answer.set(i,(int)bit.query(curr-1));
            bit.update(curr,1);
        }
        return answer;
        
    }
    class FenWickTree{
        private final int n;
        private final long[] bit;
        FenWickTree(int n){
            this.n=n;
            this.bit=new long[n+1];
        }
        void update(int idx,long delta){
            while(idx<=n){
                bit[idx]+=delta;
                idx+=idx&-idx;
            }
        }
        long query(int idx){
            long sum=0;
            while(idx>0){
                sum+=bit[idx];
                idx-=idx&-idx;
            }
            return sum;
        }
    }
}
