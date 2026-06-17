class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][sum+1];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }
        return solve(n-1 , sum , dp , arr);
    }
    public static boolean solve(int i , int target , int dp[][] , int arr[]){
        
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;
        
        if(dp[i][target] != -1) return dp[i][target] == 1;
        
        boolean notTake = solve(i - 1 , target , dp , arr);
        boolean take = false;
        if(arr[i] <= target){
            take = solve(i-1 , target - arr[i],dp, arr);
        }
        
        dp[i][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
}