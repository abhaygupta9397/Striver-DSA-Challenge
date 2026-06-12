class Solution {
    public boolean isPalindrome(ListNode head) {
        //we can use the stack also
        Stack<Integer> stk = new Stack<>();
        ListNode temp = head;
        while(head != null)
        {
            stk.push(head.val);
            head = head.next;
        }
        head = temp;
        while(head != null){
            if(stk.pop() != head.val) return false;
            head = head.next;
        }
        return true;
    }
}