class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
           if(s1.size()+s2.size()!=s3.size()){
            return false;
           }
        vector<vector<int>> dp(s1.size() + 1,vector<int>(s2.size() + 1, -1));
        return so(dp,s1,s2,s3,0,0);
    }
    bool so(vector<vector<int>>& dp,string s1, string s2, string s3,int i,int j){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int k=i+j;
        if(k==s3.size()){
             return dp[i][j] = (i == s1.size() && j == s2.size());
        }
        
        bool ok = false;

        if (i<s1.size() && s1[i] == s3[k])
             ok = so( dp,s1, s2, s3, i + 1, j);

        if (j<s2.size() && s2[j] == s3[k])
            ok = ok||so(dp, s1, s2, s3,i, j + 1);

        return dp[i][j]=ok;
    }
};
