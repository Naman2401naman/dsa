class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Long> um = new HashMap<>();   // future elements
        Map<Integer, Long> um1 = new HashMap<>();

        for(int x: nums){
            um.put(x,um.getOrDefault(x,0L)+1);
        }
        long count=0;
        for(int x:nums){
            um.put(x,um.get(x)-1);
            if(um.get(x)==0) um.remove(x);

            long target =2L*x;
            long leftCount=um1.getOrDefault((int)target,0L);
            long rightCount = um.getOrDefault((int)target,0L);

            count=(count+(leftCount*rightCount)%MOD)%MOD;
            um1.put(x,um1.getOrDefault(x,0L)+1);
        }
    return (int)count;
    }
}