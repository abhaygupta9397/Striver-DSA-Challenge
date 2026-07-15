class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    public int height(TreeNode root){
        if(root == null) return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);

        diameter = Math.max(diameter , leftH + rightH);

        return 1 + (Math.max(leftH , rightH));
    }
}