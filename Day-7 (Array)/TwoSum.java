class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                int ans[] = new int[2];
                ans[0] = map.get(need);
                ans[1] = i;
                return ans;
            }else{
                map.put(nums[i] , i);
            }
        }
        return new int[2];
    }
}
