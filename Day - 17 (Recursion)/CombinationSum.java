class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        fun(0,candidates,target,li,ans);
        return ans;
    }
    public void fun(int i ,int arr[], int target,List<Integer> li,List<List<Integer>> ans){
        if(target < 0 || i >= arr.length)return;
        if(target == 0){
            ans.add(new ArrayList<>(li));
            return;
        }
            li.add(arr[i]); // try 
            fun(i,arr,target-arr[i],li,ans); // explore
            li.remove(li.size()-1); // backtrack

            fun(i+1 , arr , target , li , ans);
    }
}
