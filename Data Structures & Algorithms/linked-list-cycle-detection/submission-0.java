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
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        if(head==null)
            return false;
        if(head.next==null)
            return false;

        while(p2.next!=null && p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
                return true;
        }
        return false;
        
    }
}
