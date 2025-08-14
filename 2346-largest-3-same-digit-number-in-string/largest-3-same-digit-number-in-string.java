class Solution {
    public String largestGoodInteger(String num) {
        String largest = ""; // Stores the largest good integer found
        
        for (int i = 0; i < num.length() - 2; i++) {
            char ch = num.charAt(i);
            
            // Check if this and the next two characters are the same
            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2)) {
                String current = num.substring(i, i + 3);
                
                // Compare lexicographically
                if (largest.equals("") || current.compareTo(largest) > 0) {
                    largest = current;
                }
            }
        }
        
        return largest;
    }
}
