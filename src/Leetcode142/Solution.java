package Leetcode142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){
            slow=slow.next;
            if (fast.next!=null){
                fast=fast.next.next;
            }else {
                return null;
            }
            if (slow==fast){
                ListNode prev=head;
                while (prev!=slow){
                    prev=prev.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}