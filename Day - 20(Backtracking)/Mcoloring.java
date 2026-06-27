
class Solution {
    boolean isSafe(int node,int v,int edges[][],int color,int vis[]){
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==node && vis[edges[i][1]]==color)
            return false;
            if(edges[i][1]==node && vis[edges[i][0]]==color)
            return false;
        }
        return true;
    }
    boolean solve(int node,int v,int edges[][],int m,int vis[]){
        if(node==v)
        return true;
        for(int i=1;i<=m;i++){
            if(isSafe(node,v,edges,i,vis)){
                vis[node]=i;
                if(solve(node+1,v,edges,m,vis))
                return true;
                vis[node]=0;
            }
        }
        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int vis[]=new int[v];
        return solve(0,v,edges,m,vis);
    }
}