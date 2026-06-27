class Solution1 {
    int dp[][];
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String st : wordDict){
            set.add(st);
        }
        int n = s.length();
        dp = new int[n+1][n+1];

        return fun(0,1,s, set); 
    }
    public boolean fun(int i , int j , String st , HashSet<String> set){
        //base cases 
        if(i == st.length()) return true;
        if(j > st.length()) return false;

        if(dp[i][j] != 0) return dp[i][j] == 1 ? true : false;


        boolean skip = fun(i , j + 1 , st , set);
        boolean take = set.contains(st.substring(i,j)) && fun(j , j+1 , st , set);

       dp[i][j] = (take || skip) ? 1 : -1;

       return take || skip;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int max_len = 0;
        for(String st : wordDict){
            set.add(st);
            max_len = Math.max(max_len , st.length());
        }

        int n = s.length();
        
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
           for(int j = Math.max(0 , i - max_len); j < i; j++){
               if(dp[j] && set.contains(s.substring(j,i))){
                dp[i] = true;
                break;
               }
           }
        }
        return dp[n]; // the length of the string that is seperable 
    }
}
