class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        solve(nums,0,res);
        Set<List<Integer>> ans=new HashSet<>(res);
        List<List<Integer>> res1 = new ArrayList<List<Integer>>(ans);
        return res1;
       
        
    }
    
    public void solve(int nums[], int ind, List<List<Integer>> res)
    {
        int n = nums.length;
        
        // base case
        if(ind == n-1)
        {
            List<Integer> sublist = new ArrayList<Integer>();
            for(int el : nums)
            {
                sublist.add(el);
            }
            res.add(new ArrayList<>(sublist));
            return;
        }
        
        //tasks
        
        for(int i = ind; i<n ; i++)
        {
            swap(nums,i,ind);
            
            solve(nums,ind+1,res);
            //backtracking
            swap(nums,i,ind);
        }
    }
    
    public void swap(int nums[], int i1, int i2)
    {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    
    
    
   
}
                                    