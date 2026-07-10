class Solution1 {//Pure recursion : O(2^n) time exponential 
    public int minInsertions(String s) {
        int len = s.length();
        return fun(0,len-1 , s);
    }
    public int fun(int i , int j , String s){
        //base case
        if(i >= j) return 0;

        if(s.charAt(i) == s.charAt(j)){
            return fun(i+1 , j - 1, s);
        }else{
            int left = 1 + fun(i , j - 1 , s);
            int right = 1 + fun(i+1 , j , s);
            return Math.min(left , right);
        }
    }
}

class Solution {//Memoization : O(n^2) time 
    public int minInsertions(String s) {
        int len = s.length();
        int dp[][] = new int[len][len];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        return fun(0,len-1 , s , dp);
    }
    public int fun(int i , int j , String s , int dp[][]){
        //base case
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = fun(i+1 , j - 1, s , dp);
        }else{
            int left = 1 + fun(i , j - 1 , s , dp);
            int right = 1 + fun(i+1 , j , s ,dp);
            return dp[i][j] = Math.min(left , right);
        }
    }
}
