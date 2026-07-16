
class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        
        ans.add(node.data);
        
        // if there is a single node, then root will be added 2 times(here above and during leaf traversal) if we don't return here. 
        if(node.left == null && node.right == null ){
            return ans;
        }

        
        leftT(node.left,ans);
        leafT(node, ans);
        rightT(node.right,stack);
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        
        return ans;
        
    }
    
    void leftT(Node root, ArrayList<Integer> ans ){
        if(root == null) return ;
        
        if(root.left == null && root.right == null ){
            return;
        }
        
        ans.add(root.data);
        
        if(root.left !=null){
            leftT(root.left, ans);
        }else if(root.right != null) {
            leftT(root.right, ans);
        }
        
    }
    
    void leafT(Node root, ArrayList<Integer> ans ){
        if(root == null) return;
        
        if(root.left == null && root.right == null ){
            ans.add(root.data);
            return;
        }
        
        leafT(root.left, ans);
        leafT(root.right, ans);
        
    }
    
    void rightT(Node root, Stack<Integer> stack ){
        if(root == null) return ;
        
        if(root.left == null && root.right == null ){
            return;
        }
        
        stack.add(root.data);
        
        if(root.right !=null){
            rightT(root.right, stack);
        } else if(root.left != null){
            rightT(root.left, stack);
        }
        
    }
    
}
