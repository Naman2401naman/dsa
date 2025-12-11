class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Map: x -> all y coordinates on that vertical line
        HashMap<Integer, TreeSet<Integer>> mp_x = new HashMap<>();
        // Map: y -> all x coordinates on that horizontal line
        HashMap<Integer, TreeSet<Integer>> mp_y = new HashMap<>();

        // Fill maps
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            mp_x.putIfAbsent(x, new TreeSet<>());
            mp_y.putIfAbsent(y, new TreeSet<>());

            mp_x.get(x).add(y); // add y to x's vertical list
            mp_y.get(y).add(x); // add x to y's horizontal list
        }

        int count = 0;

        // Check every building
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            TreeSet<Integer> ys = mp_x.get(x); // all y for this x
            TreeSet<Integer> xs = mp_y.get(y); // all x for this y

            // If y is the smallest OR largest in its vertical list → boundary
            if (ys.first() == y || ys.last() == y) continue;

            // If x is the smallest OR largest in its horizontal list → boundary
            if (xs.first() == x || xs.last() == x) continue;

            // Otherwise it is surrounded from all 4 sides
            count++;
        }

        return count;
    }
}
