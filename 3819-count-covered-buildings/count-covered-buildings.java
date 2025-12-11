class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Map: x -> all y coordinates on that vertical line
        HashMap<Integer, TreeSet<Integer>> mp_x = new HashMap<>();
        // Map: y -> all x coordinates on that horizontal line
        HashMap<Integer, TreeSet<Integer>> mp_y = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            mp_x.putIfAbsent(x, new TreeSet<>());
            mp_y.putIfAbsent(y, new TreeSet<>());

            mp_x.get(x).add(y);
            mp_y.get(y).add(x);
        }

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            TreeSet<Integer> ys = mp_x.get(x); 
            TreeSet<Integer> xs = mp_y.get(y); 
            if (ys.first() == y || ys.last() == y) continue;
            if (xs.first() == x || xs.last() == x) continue;
            count++;
        }

        return count;
    }
}
