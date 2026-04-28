class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int[] arr=new int[m*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i*m+j]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int rem=arr[0]%x;
        for(int i=1;i<n*m;i++){
            if((arr[i]%x)!=rem){
                return -1;
            }
        }
        int median = arr[arr.length / 2];

        int operations = 0;

        // Calculate operations
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}