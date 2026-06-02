class Solution1 {//O(N^2)time & O(1) space
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                ans = Math.max(ans,sum);
            }
        }
        return ans;

    }
}
class Solution {//Kadane Algorithm : Not a Greedy but a DP One Think...
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {

            currSum = Math.max(nums[i], currSum + nums[i]);

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}