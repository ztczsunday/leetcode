package Leetcode206;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr;
        ListNode prev=null;
        curr=head;
        while (curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}