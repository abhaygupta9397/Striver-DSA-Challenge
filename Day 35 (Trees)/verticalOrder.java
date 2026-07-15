
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>(); // [column, row, value]
        dfs(root, 0, 0, nodes);
        
        // Sort: column asc -> row asc -> value asc
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < nodes.size()) {
            List<Integer> col = new ArrayList<>();
            int currCol = nodes.get(i)[0];
            while (i < nodes.size() && nodes.get(i)[0] == currCol) {
                col.add(nodes.get(i++)[2]);
            }
            ans.add(col);
        }
        return ans;
    }
    
    private void dfs(TreeNode node, int col, int row, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, col - 1, row + 1, nodes);
        dfs(node.right, col + 1, row + 1, nodes);
    }
}