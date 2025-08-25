class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;       // number of rows
        int n = mat[0].length;    // number of columns
        int[] arr = new int[m * n];
        
        int row = 0, col = 0, dir = 1; // dir = 1 means up-right, -1 means down-left
        
        for (int i = 0; i < m * n; i++) {
            arr[i] = mat[row][col];

            if (dir == 1) { // moving up-right
                if (col == n - 1) { // hit last column → move down
                    row++;
                    dir = -1;
                } else if (row == 0) { // hit first row → move right
                    col++;
                    dir = -1;
                } else { // normal move
                    row--;
                    col++;
                }
            } else { 
                if (row == m - 1) { 
                    col++;
                    dir = 1;
                } else if (col == 0) { 
                    row++;
                    dir = 1;
                } else { 
                    row++;
                    col--;
                }
            }
        }
        return arr;
    }
}
