class Solution {//Abhay is back
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;

            int l = i + 1;
            int r = n - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    ans.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l-1] == nums[l])l++;
                    while(l < r && nums[r+1] == nums[r])r--;
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}