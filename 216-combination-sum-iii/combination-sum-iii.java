class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res =new ArrayList<>();
        int[] arr=new int[9];
        for(int i=1;i<10;i++){
            arr[i-1]=i;
        }
        solve(0,arr,n,k,res,new ArrayList<>());
        return res;
    }

    private static void solve(int idx,int[] arr,int target,int sze,List<List<Integer>> res,List<Integer> temp){
        if(target==0 && temp.size()==sze){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx;i<arr.length;i++){
            if(arr[i]>target) return;
            
            temp.add(arr[i]);
            solve(i+1,arr,target-arr[i],sze,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}