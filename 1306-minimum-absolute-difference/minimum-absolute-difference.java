class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ls=new ArrayList<>();
        int max=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];
            if(diff<max){
                max=diff;
                ls=new ArrayList<>();
                ls.add(Arrays.asList(arr[i-1],arr[i]));
            }else if(diff==max){
                ls.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return ls;
    }
}