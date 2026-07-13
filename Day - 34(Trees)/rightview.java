
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        fun(root , ans, 0);
        return ans;
    }
    public void fun(TreeNode root , List<Integer> ans, int depth){
        if(root == null) return;
            if(ans.size() == depth){
                ans.add(root.val);
            }
                fun(root.right,ans,depth+1);
                fun(root.left,ans,depth+1);
    }
}