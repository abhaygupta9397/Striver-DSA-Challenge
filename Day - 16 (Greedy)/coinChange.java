class Solution {

    int[][] dp;

    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = fun(0, amount, coins);

        return ans != Integer.MAX_VALUE / 2 ? ans : -1;
    }

    public int fun(int i, int amt, int[] coins) {

        if(i >= coins.length || amt < 0)
            return Integer.MAX_VALUE / 2;

        if(amt == 0)
            return 0;

        if(dp[i][amt] != -1)
            return dp[i][amt];

        int skip = fun(i + 1, amt, coins);

        int consider = 1 + fun(i, amt - coins[i], coins);

        return dp[i][amt] = Math.min(consider, skip);
    }
}
