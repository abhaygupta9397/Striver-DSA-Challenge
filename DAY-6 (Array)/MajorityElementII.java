class Solution {//Moore Voting algorithm
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for(int x : nums){
            if(num1 == x){
                count1++;
            } else if(num2 == x){
                count2++;
            }
            else if(count1 == 0 && num1 != x){
               count1 = 1; num1 = x;
            }else if(count2 == 0 && num2 != x){
                count2 = 1; num2 = x;
            }else{
                count1--;
                count2--;
            }
        }
        //now we just got candidates we have to get confirmation first
        count1 = 0; count2 = 0;
        for(int x : nums){
            if(x == num1)count1++;
            else if(x == num2)count2++;
        }
        if(count1 > n / 3)ans.add(num1);
        if(count2 > n / 3)ans.add(num2);
        return ans;
    }
}
