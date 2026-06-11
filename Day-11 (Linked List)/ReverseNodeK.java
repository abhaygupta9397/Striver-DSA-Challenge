public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy = new ListNode(0);
       ListNode curr = dummy;
       dummy.next = head;

       while(curr != null){
        ListNode start = curr;

        //geting the kth from it
        ListNode kthNode = getKthNode(curr,k);
        if(kthNode == null) break;
        ListNode end = kthNode.next;

        //reverse logic
        kthNode.next = null;
        ListNode reverseHead = reverse(start.next);
        ListNode reverseTail = start.next;

        start.next = reverseHead;
        reverseTail.next = end;
        curr = reverseTail;
       }
       return dummy.next;
    }
    public ListNode getKthNode(ListNode head , int k){
        int count = 0;
        while(count < k && head != null){
            head = head.next;
            count++;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode past = null;
        ListNode fut = head.next;
        ListNode pre = head;
        while(pre != null){
            fut = pre.next;
            pre.next = past;
            past = pre;
            pre = fut;
        }
        return past;
    }
} {
    
}
