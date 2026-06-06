class Solution1 {//recursive solution
    public int uniquePaths(int m, int n) {
        return fun(m-1,n-1);
    }
    public int fun(int i , int j){
        if(i < 0 || j < 0) return 0;
        if(i == 0 && j == 0) return 1; 

        return fun(i-1,j) + fun(i,j-1);
    }
}

class Solution2 {//memoization here
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int d[] : dp) Arrays.fill(d,-1);
        return fun(m-1,n-1,dp);
    }
    public int fun(int i , int j,int dp[][]){
        if(i < 0 || j < 0) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = fun(i-1,j,dp) + fun(i,j-1,dp);
    }
}

class Solution3 {//bottom up 
    public int uniquePaths(int m, int n) {
        int table[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    table[i][j] = 1;
                }else{
                    table[i][j] = table[i-1][j] + table[i][j-1];
                }
            }
        }
        return table[m-1][n-1];
    }
}
class Solution {//bottom up space optimised solution
    public int uniquePaths(int m, int n) {
        int table[] = new int[n];
        Arrays.fill(table,1);

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                    table[j] = table[j] + table[j-1];
            }
        }
        return table[n-1];
    }
}