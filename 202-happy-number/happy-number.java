import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Integer> has = new HashMap<>();
        
        while (n != 1) {
            n = sqrnum(n);
            
            if (has.containsKey(n)) {   // cycle detected
                return false;
            }
            
            has.put(n, 1);  // mark number as seen
        }
        
        return true;  // if n becomes 1 → happy number
    }

    int sqrnum(int n) {
        int r = 0;
        int sqr = 0;
        while (n > 0) {
            r = n % 10;
            sqr += r * r;
            n /= 10;
        }
        return sqr;   // missing return fixed
    }
}
