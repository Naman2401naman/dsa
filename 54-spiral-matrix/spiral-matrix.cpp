class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        int x=0;int y=0;
        while(x < (matrix.size() + 1) / 2 && y < (matrix[0].size() + 1) / 2){
            int y1=y;
            int x1=x;
             while(y1<matrix[0].size()-y) {res.push_back(matrix[x1][y1]); y1++;}
             y1--;
             x1++;
            while(x1<matrix.size()-x){ res.push_back(matrix[x1][y1]);x1++;}
            x1--;
            y1--;
            if(x1!=x){ 
           while(y1>=y){ res.push_back(matrix[x1][y1]); y1--;}}
           y1++;
           x1--;
           if(y1!=matrix[0].size()-y-1){
           while(x1>x){ res.push_back(matrix[x1][y1]); x1--;}}
           x++;
           y++;
        }
        return res;
    }
};