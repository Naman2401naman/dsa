import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        List<Integer> li = new ArrayList<>();
        int n = healths.length;

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = positions[i];
            arr[i][1] = healths[i];
            arr[i][2] = directions.charAt(i);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        
        Stack<Integer> right = new Stack<>();
        for (int i = 0; i < n; i++) {

            if (arr[i][2] == 'R') {
                right.push(i);   // store index
            } 
            else {

                while (!right.isEmpty() && arr[i][1] > 0) {

                    int top = right.peek();

                    if (arr[top][1] > arr[i][1]) {
                        arr[top][1]--;
                        arr[i][1] = 0;
                        break;
                    } 
                    else if (arr[top][1] == arr[i][1]) {
                        arr[top][1] = 0;
                        arr[i][1] = 0;
                        right.pop();
                        break;
                    } 
                    else {
                        right.pop();
                        arr[i][1]--;
                        arr[top][1] = 0;
                    }
                }
            }
        }

       List<int[]> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i][1] > 0) {
                temp.add(new int[]{arr[i][3], arr[i][1]});
            }
        }

        // sort by original index
        Collections.sort(temp, (a, b) -> a[0] - b[0]);

        
        for (int[] t : temp) {
            li.add(t[1]);
        }

        return li;

    }
}