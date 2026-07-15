
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
           
            List<Integer> li = new LinkedList<>();
            for(int i = q.size(); i > 0; i--){
                 TreeNode node = q.poll();
                 li.add(node.val);
                 if(node.left != null) q.offer(node.left);
                 if(node.right != null) q.offer(node.right);
            }
            ans.add(li);

        }
        return ans;
    }
}
