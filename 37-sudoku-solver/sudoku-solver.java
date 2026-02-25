class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char d='1';d<='9';d++){
                        if(isValid(board,i,j,d)){
                            board[i][j]=d;

                            if(solve(board)){
                            return true;
                            }

                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(char[][] board,int row,int col,char d){
        for(int i=0;i<9;i++){
            if(board[i][col]==d) return false;
            if(board[row][i]==d) return false;
        }
        int row_i=(row/3)*3;
        int col_j=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[row_i+i][col_j+j]==d) return false;
            }
        }
        return true;
    }
}