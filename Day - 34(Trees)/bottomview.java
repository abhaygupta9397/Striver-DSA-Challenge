class Pair{
    int level;
    int value;
    
    Pair(int level , int value){
        this.level = level;
        this.value = value;
    }
}
class Solution {
    HashMap<Integer, Pair> map = new HashMap<>();
    int minHD = 0;
    int maxHD = 0;
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        dfs(root , 0 , 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int hd = minHD; hd <= maxHD; hd++){
            ans.add(map.get(hd).value);
        }
        return ans;
    }
    public void dfs(Node node , int hd , int level){
        if(node == null) return;
        
        if(!map.containsKey(hd) || level >= map.get(hd).level){
            map.put(hd , new Pair(level , node.data));
        }
        
        minHD = Math.min(minHD , hd);
        maxHD = Math.max(maxHD , hd);
        
        dfs(node.left , hd-1, level+1);
        dfs(node.right , hd+1 , level + 1);
    }
}
