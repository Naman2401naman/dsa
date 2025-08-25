class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean[] seen=new boolean[10];
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    int num = ch - '0';
                    if (num < 1 || num > 9) return false;
                    if(seen[num]){
                        return false;
                    }
                    seen[num]=true;
                }
            }
        }

        for(int i=0;i<9;i++){
            boolean[] seen=new boolean[10];
            for(int j=0;j<9;j++){
                char ch = board[j][i];
                if(ch!='.'){
                    int num = ch - '0'; // convert char -> int
                    if (num < 1 || num > 9) return false;
                    if(seen[num]){
                        return false;
                    }
                    seen[num]=true;
                }
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean[] seen =new boolean[10];
                for(int k=0;k<3;k++){
                    for(int h=0;h<3;h++){
                        char ch=board[i+k][h+j];
                        if(ch!='.'){
                            int num=ch-'0';
                            if(num<1 || num>9){
                                return false;
                            }
                            if(seen[num]){
                                return false;
                            }
                            seen[num]=true;
                        }
                    }
                }
            }
        }
        return true;
    }
}