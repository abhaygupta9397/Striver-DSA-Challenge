class Solution {//O(n)time and O(n)space here
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums)set.add(x);
int ans = 0;
        for(int x : set){// to avoid the repeated start points
            int count = 0;
            if(!set.contains(x-1)){
                while(set.contains(x++))count++;
            }
            ans = ans < count ? count : ans;
        }
        return ans;
    }
}