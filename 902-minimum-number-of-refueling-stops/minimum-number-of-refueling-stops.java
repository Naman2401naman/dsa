import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max-heap to track the largest fuel amounts available
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int fuel = startFuel;
        int stops = 0;
        int i = 0, n = stations.length;

        while (fuel < target) {
            // Add all stations that can be reached with current fuel
            while (i < n && stations[i][0] <= fuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }

            // No fuel options available, can't proceed
            if (maxHeap.isEmpty()) return -1;

            // Refuel with the station that gives the most fuel
            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}