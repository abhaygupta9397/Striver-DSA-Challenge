class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i-1] == nums[i])continue;
            for(int j = i+1; j < n - 2; j++){
                if(j > i+1 && nums[j-1] == nums[j])continue;
                //two pointers takes the charge now
                int l = j+1;
                int r = n-1;
                while(l < r){
                    if((long)nums[i] + nums[j] + nums[l] + nums[r] == target){
                        ans.add(Arrays.asList(nums[i] , nums[j] , nums[l] , nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l-1] == nums[l])l++;
                        while(l < r && nums[r+1] == nums[r])r--;
                    }else if((long)nums[i] + nums[j] + nums[l] + nums[r] < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
return ans;
    }
}
