
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        fun(root , ans);
        return ans;
    }
    public void fun(TreeNode root , List<Integer> ans){
        if(root == null) return;

        //go to left
        fun(root.left , ans);
        ans.add(root.val);
        fun(root.right , ans);
    }
}