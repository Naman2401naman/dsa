import java.util.*;

class Solution {

    List<List<String>> res = new ArrayList<>();
    int N;

    public List<List<String>> solveNQueens(int n) {

        N = n;

        List<List<String>> board = new ArrayList<>();

        // create empty board with "."
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(".");
            }
            board.add(row);
        }

        solve(board, 0);
        return res;
    }

    void solve(List<List<String>> board, int row) {

        if (row == N) {
            // IMPORTANT: make deep copy
            List<String> temp = new ArrayList<>();
            for (List<String> r : board) {
                temp.add(String.join("", r));
            }
            res.add(temp);
            return;
        }

        for (int col = 0; col < N; col++) {

            if (isValid(board, row, col)) {

                board.get(row).set(col, "Q");
                solve(board, row + 1);
                board.get(row).set(col, ".");
            }
        }
    }

    boolean isValid(List<List<String>> board, int row, int col) {

        // check column
        for (int i = 0; i < row; i++) {
            if (board.get(i).get(col).equals("Q"))
                return false;
        }

        // check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).get(j).equals("Q"))
                return false;
        }

        // check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board.get(i).get(j).equals("Q"))
                return false;
        }

        return true;
    }
}