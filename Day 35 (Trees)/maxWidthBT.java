
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int width = 0;
    // level -> first node index
    public int widthOfBinaryTree(TreeNode root) {
        fun(root, 0, 0);
        return width;
    }
    public void fun(TreeNode root , int level , int index){
        if(root == null) return;

        if(!map.containsKey(level)){
            //first occurence
            map.put(level , index);
        }

        width = Math.max(width , index - map.get(level) + 1);
        fun(root.left  , level + 1 , 2*index + 1);
        fun(root.right , level + 1 , 2*index + 2);
    }
}
