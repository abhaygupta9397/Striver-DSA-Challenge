class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                ans = i + 1;
            } else if (mp.containsKey(sum - k)) {
                ans = Math.max(ans, i - mp.get(sum - k));
            }

            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }

        return ans;
    }
}
