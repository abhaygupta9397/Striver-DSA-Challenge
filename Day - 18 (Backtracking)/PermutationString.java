class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        fun(nums,li,ans);
        return ans;
    }
    public void fun(int nums[],List<Integer> li , List<List<Integer>>ans){
         if(li.size()==nums.length){
            ans.add(new ArrayList<>(li));
            return;
         }
        for(int j = 0; j < nums.length; j++){
            if(li.contains(nums[j]))continue;
            li.add(nums[j]);
            fun(nums,li,ans);
            li.remove(li.size()-1);
        }
    }
}
