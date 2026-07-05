class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> stk = new Stack<>();
        int  n = arr.length;
       
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = n - 1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peek() >= arr[i]){
                stk.pop();
            }
            if(stk.isEmpty())  ans.addFirst(-1);
            else ans.addFirst(stk.peek());
            
            stk.push(arr[i]);
        }
        
        return ans;
    }
}
