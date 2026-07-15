


class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        fun(root , new ArrayList<Integer>() , allPaths);
        return allPaths;
    }
    public void fun(Node root , List<Integer> li , ArrayList<ArrayList<Integer>> allPaths){
        if(root == null){
            return;
        }
        
        li.add(root.data);
        
        if(root.left == null && root.right == null){
             allPaths.add(new ArrayList<>(li));
        }else{
             fun(root.left , li , allPaths);
             fun(root.right , li , allPaths);
        }
        
        li.remove(li.size()-1);
    }
}