import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        Map<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        for (int i = 0; i < sb.length(); i++) {
           
            
            if(i+1<sb.length() && romanMap.get(sb.charAt(i))<romanMap.get(sb.charAt(i+1)) ){
                
                count=count-romanMap.get(sb.charAt(i));
            }
            else{
                count=count+romanMap.get(sb.charAt(i));
            }
        }

        return count;
    }
}
