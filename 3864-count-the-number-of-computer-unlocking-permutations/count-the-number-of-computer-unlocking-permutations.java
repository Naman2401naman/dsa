class Solution {
    public int countPermutations(int[] complexity) {
     final int MOD = 1_000_000_007;
        int min=Integer.MAX_VALUE;
        int idx=complexity[0];
        
        Arrays.sort(complexity);
        int n=complexity.length;
        if(idx>complexity[0]) return 0;
        if(complexity[0]==complexity[1]) return 0;

        long[] arr=new long[n];
        arr[0]=1;
        for(int i=1;i<n;i++){
            arr[i]=(arr[i-1]*i)%MOD;
        }
        return (int)arr[n-1];
    }

}