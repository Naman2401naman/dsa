import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lastRain = new HashMap<>(); // lake -> last rainy day
        TreeSet<Integer> dryDays = new TreeSet<>(); // stores indices of dry days
        int[] result = new int[rains.length];
        
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                int lake = rains[i];
                if (lastRain.containsKey(lake)) {
                    // Find next dry day after last rain of this lake
                    Integer dry = dryDays.higher(lastRain.get(lake));
                    if (dry == null) {
                        return new int[0]; // flood occurs
                    }
                    result[dry] = lake; // dry this lake on that day
                    dryDays.remove(dry);
                }
                result[i] = -1; // rainy day
                lastRain.put(lake, i);
            } else {
                dryDays.add(i); // possible dry day
                result[i] = 1; // default value
            }
        }
        return result;
    }
}
