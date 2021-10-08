package Leetcode92;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        if (left == right) {
            return dummyNode.next;
        }
        ListNode pre = dummyNode;
        right -= left;
        while (left > 1) {
            pre = pre.next;
            left--;
        }
        ListNode curr = pre.next;
        ListNode next;
        while (right > 0) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            right--;
        }
        return dummyNode.next;
    }
}