class Solution {
    public String largestNumber(int[] nums) {
        Integer[] num=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(num, (a, b) -> ("" + b + a).compareTo("" + a + b));
        Arrays.toString(num);
         if (num[0] == 0) {
            return "0";
        }
        StringBuilder ans=new StringBuilder();
        for(int i = 0;i<num.length;i++){
            ans.append(num[i]);
        }
        return ans.toString();
    }
}