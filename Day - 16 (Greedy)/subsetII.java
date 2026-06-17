class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        fun(0,nums , li , all);
        return all;

    }
    public void fun(int i , int nums[] , List<Integer> li , List<List<Integer>> all){
       
            all.add(new ArrayList<>(li));
           
        

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j-1] == nums[j]) continue;

            li.add(nums[j]);
            fun(j+1 , nums , li , all);
            li.remove(li.size()-1);
        }
        
    }
}
