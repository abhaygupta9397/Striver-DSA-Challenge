class Solution {//tc : O(n) & sc : O(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int nge[] = new int[10001];

        Stack<Integer> stk = new Stack<>();
        for(int i = n2-1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peek() <= nums2[i])stk.pop();

            nge[nums2[i]] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums2[i]);
        }

        int ans[] = new int[n1];
        
        int i = 0;
        for(int x : nums1){
            ans[i++] = nge[x];
        }

       return ans;
    }
}
