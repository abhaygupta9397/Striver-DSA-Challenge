
class Solution {
    int ans = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root , 0);
        return ans;
    }
    public void dfs(TreeNode root , int level){
        if(root == null){
            ans = Math.max(ans , level);
            return;
        }

        dfs(root.left , level + 1);
        dfs(root.right , level + 1);
    }
}