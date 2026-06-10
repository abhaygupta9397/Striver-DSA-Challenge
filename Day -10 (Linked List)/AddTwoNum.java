class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode save = dummy;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
              ListNode add = new ListNode();
              add.val = (sum % 10);
              carry = sum / 10;
              dummy.next = add;
              dummy = dummy.next;
              l1 = l1.next;
              l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val + carry;
              ListNode add = new ListNode();
              add.val = (sum % 10);
              carry = sum / 10;
              dummy.next = add;
              dummy = dummy.next;
              l1 = l1.next;
        }

        while(l2 != null){
            ListNode add = new ListNode();
            int sum = l2.val + carry;
            add.val = sum % 10;
            carry = sum / 10;
            dummy.next = add;
            dummy = dummy.next;
            l2 = l2.next;
        }

        if(carry != 0){
            ListNode add = new ListNode();
            add.val = carry;
            dummy.next = add;
        }
        return save.next;
    }
}