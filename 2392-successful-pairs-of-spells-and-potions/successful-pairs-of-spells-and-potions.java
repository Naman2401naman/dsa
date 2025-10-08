import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            // minimum potion needed for success
            long minPotion = (success + spell - 1) / spell; // ceil(success/spell)
            
            // find the first potion >= minPotion using binary search
            int index = lowerBound(potions, minPotion);
            
            // all potions after this index are successful
            result[i] = m - index;
        }
        return result;
    }

    // helper function for binary search (first index with potion >= target)
    private int lowerBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
