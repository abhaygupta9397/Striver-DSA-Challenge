/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int length = 1;
        ListNode dummy = head;

        while(dummy.next != null){
            dummy = dummy.next;
            length++;
        }
        int pos = k % length;
        if(pos == 0) return head;

        ListNode cur = head;
        for(int i = 0; i < length - pos - 1; i++)
        cur = cur.next;

        ListNode newHead = cur.next;
        cur.next = null;
        dummy.next = head;

        return newHead;
    }
}