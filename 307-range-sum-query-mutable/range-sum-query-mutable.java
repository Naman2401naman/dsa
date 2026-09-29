class NumArray {
    int[] nums;
    int[] BIT;
    int n;
    public NumArray(int[] nums) {
        this.nums=nums;
        n=nums.length;
        BIT=new int[n+1];
        for(int i=0;i<n;i++){
            init(i,nums[i]);
        }
    }
    public void init(int i,int del){
        i++;
        while(i<=n){
            BIT[i]+=del;
            i=i+(i&-i);
        }
    }
    
    public void update(int i, int val) {
        int diff=val-nums[i];
        nums[i]=val;
        init(i,diff);
    }
    
    public int sumRange(int left, int right) {
        return sum(right)-sum(left-1);
    }
    int sum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=BIT[i];
            i=i-(i&-i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */