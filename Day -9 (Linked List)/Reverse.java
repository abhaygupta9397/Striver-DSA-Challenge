class Solution1 {//iterative way 
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode past = null;
        ListNode curr = head;
        ListNode fut = head;
        while(curr != null){
            fut = curr.next; // save the next node
            curr.next = past;
            past = curr;
            curr = fut;
        }
        return past;
    }
}
class Solution {//recursive way
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
