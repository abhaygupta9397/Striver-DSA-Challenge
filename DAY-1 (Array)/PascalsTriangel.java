class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> li = new ArrayList<>();
        li.add(1);
        ans.add(li);

        for(int r = 1; r < numRows; r++){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for(int i = 1; i < ans.get(r-1).size(); i++){
                int sum = ans.get(r-1).get(i-1) + ans.get(r-1).get(i);
                l.add(sum);
            }
            l.add(1);
            ans.add(l);
        }
        return ans;
    }
}