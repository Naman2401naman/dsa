class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len=encodedText.length();
        int cols=len/rows;
        char[][] arr=new char[rows][cols];
       
        for (int i = 0; i < len; i++) {
            int r = i / cols;
            int c = i % cols;
            arr[r][c] = encodedText.charAt(i);
        }
        StringBuilder sb = new StringBuilder();

        // Decode diagonally
        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0, c = startCol;
            while (r < rows && c < cols) {
                sb.append(arr[r][c]);
                r++;
                c++;
            }
        }
        int end=sb.length();
        while(end>0 && sb.charAt(end-1)==' '){
            end--;
        }
        
        return sb.substring(0,end);
        
    }
}