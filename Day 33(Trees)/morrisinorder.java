
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        
        while (current != null) {
            
            if (current.left == null) {
                // No left child - visit current
                result.add(current.val);
                current = current.right;
            } 
            else {
                // Find the inorder predecessor (rightmost node in left subtree)
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    // Create temporary thread
                    predecessor.right = current;
                    current = current.left;
                } 
                else {
                    // Remove thread and visit current
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        
        return result;
    }
}