class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // because it can produce diff perm not comb
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        fun(0,candidates,target,li,ans);
        return ans;
    }
    public void fun(int i , int arr[],int target,List<Integer> li , List<List<Integer>>ans){
        if(target == 0){
            ans.add(new ArrayList<>(li)); return;
        }if(target < 0) return;

        for(int j = i; j < arr.length; j++){
            if(j>i&&arr[j-1]==arr[j])continue;  // can take onces only
            li.add(arr[j]);
            fun(j+1,arr,target-arr[j],li,ans);
            li.remove(li.size()-1);
        }
    }
}