class Solution {
    static final long MOD = 1000000007L;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int []p:points ){
            map.put(p[1],map.getOrDefault(p[1],0)+1);
        }
        long edgesSum=0;
        long ans =0;

        for(Map.Entry<Integer,Integer> Entry:map.entrySet()){
             long count = Entry.getValue();

            // edges = C(count, 2)
            long edges = (count * (count - 1)) / 2;

            ans = (ans + (edges * edgesSum) % MOD) % MOD;

            edgesSum = (edgesSum + edges) % MOD;
        }
        return (int)(ans%MOD);
    }
}