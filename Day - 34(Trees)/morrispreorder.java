
class Solution { //Morris
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        
        while (current != null) {
            
            if (current.left == null) {
                // No left child - visit current
                result.add(current.val);
                current = current.right;
            } 
            else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    // Create temporary thread
                    result.add(current.val);
                    predecessor.right = current;
                    current = current.left;
                } 
                else {
                    // Remove thread and visit current
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
        
        return result;
    }
}
