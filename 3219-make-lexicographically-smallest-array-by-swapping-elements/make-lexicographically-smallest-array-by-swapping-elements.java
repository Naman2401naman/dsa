import java.util.*;

class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

       
        int n=nums.length;
        int[][] a1=new int[n][2];
        for(int i=0;i<n;i++){
            a1[i][0]=nums[i];
            a1[i][1]=i;
        }
        Arrays.sort(a1,(a,b)->a[0]-b[0]);
        int[] ans=new int[n];
        int start=0;
        while(start<n){
            int end=start;
            while(end+1<n && a1[end+1][0]-a1[end][0]<=limit){
                end++;
            }
            ArrayList<Integer> ls=new ArrayList<>();
            for(int i=start;i<=end;i++){
                ls.add(a1[i][1]);
            }
            Collections.sort(ls);
            for(int i=0;i<ls.size();i++){
                ans[ls.get(i)]=a1[start+i][0];  
            }
            start=end+1;
        }
        return ans;
    }
}