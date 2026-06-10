class Solution {//single pass Two pointer solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode fast = head;
        ListNode slow = head;

        while(n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null) return slow.next;
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}