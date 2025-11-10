class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n =nums.length;
        int count=0;
        for(int i:nums){
            while(!st.empty() && i<st.peek()){
                st.pop();
            }
            if(i==0) continue;
            if(st.empty() || i>st.peek()){
                count++;
                st.push(i);
            }
        }
        return count++;
    }
}