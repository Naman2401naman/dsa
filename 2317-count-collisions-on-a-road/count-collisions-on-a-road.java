class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        Stack<Character> st = new Stack<>();
        int count = 0;

        st.push(directions.charAt(0));

        for (int i = 1; i < n; i++) {
            char ch = directions.charAt(i);

            if (ch == 'L') {

                // Case 1: "R" + "L" → both collide → becomes "S"
                if (!st.isEmpty() && st.peek() == 'R') {
                    count += 2;     // R hits L
                    st.pop();
                    st.push('S');

                    // If below stack also had more R...RR + L
                    while (!st.isEmpty() && st.size() > 1 && st.get(st.size() - 2) == 'R') {
                        count++;   // Each extra R also collides
                        st.remove(st.size() - 2);
                    }

                // Case 2: "S" + "L" → L hits S → becomes S
                } else if (!st.isEmpty() && st.peek() == 'S') {
                    count++;
                    st.push('S');
                } else {
                    st.push('L');
                }

            } else if (ch == 'R') {
                st.push('R');

            } else if (ch == 'S') {

                // All previous R's collide into S
                while (!st.isEmpty() && st.peek() == 'R') {
                    count++;
                    st.pop();   // R becomes S after collision
                }
                st.push('S');
            }
        }

        return count;
    }
}
