class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        //size or n same aajaye 
        if (fast == null) {
            return slow.next;
        }

        //abh ek ek step aage badojab tak fast.next != null
        while(fast.next!=null){
            slow = slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}