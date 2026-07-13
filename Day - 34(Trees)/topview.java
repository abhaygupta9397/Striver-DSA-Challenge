class Pair{
    int level;
    int value;
    
    Pair(int level , int value){
        this.level = level;
        this.value = value;
    }
}
class Solution {
    int minHD = 0;
    int maxHD = 0;
    
        HashMap<Integer,Pair> map = new HashMap<>();
    public ArrayList<Integer> topView(Node root) {
        // code here
        dfs(root , 0 , 0);
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int hd = minHD ; hd <= maxHD; hd++){
            ans.add(map.get(hd).value);
        }
        return ans;
        
    }
    public void dfs(Node root , int level , int disx){
        if(root == null) return;
        
        if(!map.containsKey(disx) || level < map.get(disx).level){
            map.put(disx , new Pair(level , root.data));
            
        }
        
        minHD = Math.min(minHD , disx);
        maxHD = Math.max(maxHD , disx);
        
        dfs(root.left , level+1 , disx-1);
        dfs(root.right , level+1 , disx+1);
    }
}
