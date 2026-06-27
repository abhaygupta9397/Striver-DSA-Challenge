class Solution {
    ArrayList<String> ans;
    int n;
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        n = maze.length;
        ans = new ArrayList<>();
        if(maze[0][0]==0)return ans;
        helper(0,0,maze,new StringBuilder(""));
        return ans;
    }
    
    public void helper(int i,int j,int[][] maze,StringBuilder sb){
        if(i==n-1 && j==n-1){
            ans.add(sb.toString());
            return;
        }
        maze[i][j] = -1;
        int y[] = {1,0,0,-1};
        int x[] = {0,-1,1,0};
        char mov[] = {'D','L','R','U'};
        for(int k=0;k<4;k++){
            int nexti = i+y[k],nextj = j+x[k];
            if(nexti>=0 && nextj>=0 && nexti < n && nextj<n && maze[nexti][nextj]==1){
                sb.append(mov[k]);
                helper(nexti,nextj,maze,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        maze[i][j] = 1;
    }
}
