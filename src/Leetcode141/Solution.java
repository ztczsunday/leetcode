package Leetcode141;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        Set<ListNode> listNodes=new HashSet<>();
        listNodes.add(head);
        while (head.next!=null){
            if (listNodes.contains(head.next)){
                return true;
            }
            head=head.next;
            listNodes.add(head);
        }
        return false;
    }
}