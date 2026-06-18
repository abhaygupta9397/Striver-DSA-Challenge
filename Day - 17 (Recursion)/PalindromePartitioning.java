class Solution {
    int dp[][];
    public List<List<String>> partition(String s) {
        List<List<String>> all = new ArrayList<>();
        List<String> li = new ArrayList<>();
        dp = new int[s.length()][s.length()];

        fun(0, s , li , all);
        return all;
    }
    public void fun(int i , String st , List<String> li , List<List<String>> all){
        if(i == st.length()){
            all.add(new ArrayList<>(li));
            return;
        }

        for(int j = i; j < st.length(); j++){
            if(isPalin(i , j , st)){
                li.add(st.substring(i , j + 1)); // try
                fun(j +  1 , st , li , all);
                li.remove(li.size()-1);
            }
        }
    }

    public boolean isPalin(int i , int j , String st){
        if( j <= i) return true;
        if(dp[i][j] != 0) return dp[i][j] == 1;
        
         dp[i][j] = (st.charAt(i) == st.charAt(j) && isPalin(i + 1 , j - 1 , st)) 
                          ? 1 : -1;
                           return dp[i][j] == 1;
    }
}
