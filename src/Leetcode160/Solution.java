package Leetcode160;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNode=headA;
        Set<ListNode> listNodes=new HashSet<>();
        while (listNode!=null){
            listNodes.add(listNode);
            listNode=listNode.next;
        }
        listNode=headB;
        while (listNode!=null){
            if (listNodes.contains(listNode)){
                return listNode;
            }
            listNode=listNode.next;
        }
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}