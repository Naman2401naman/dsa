class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        int shift = k % m;   // correct
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                int newIndex;
                
                if (i % 2 == 0) {
                    // even row → right shift
                    newIndex = (j + shift) % m;
                } else {
                    // odd row → left shift
                    newIndex = (j - shift + m) % m;
                }
                
                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}