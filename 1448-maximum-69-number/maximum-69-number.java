class Solution {
    public int maximum69Number(int num) {
        int temp = num;
        int index = -1;   // position of the first 6 (from left)
        int position = 0; // digit position from right (0 = units place)

        // Find the rightmost 6
        while (temp > 0) {
            if (temp % 10 == 6) {
                index = position; 
            }
            temp /= 10;
            position++;
        }

        // If a 6 was found, add 3 * (10^index) to turn it into 9
        if (index != -1) {
            num += 3 * (int)Math.pow(10, index);
        }

        return num;
    }
}
