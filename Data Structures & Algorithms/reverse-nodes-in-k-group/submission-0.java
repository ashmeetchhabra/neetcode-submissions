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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode nodeBeforeGroup = dummy;

        while(true){
            // Need: 1.nodeBeforeGroup, 2.firstNodeOfGroup, 3.lastNodeOfGroup, 4.firstNodeOfNextGroup
            //Step1: Find lastNodeOfGroup
            ListNode lastNodeOfGroup = nodeBeforeGroup;
            for(int i = 0; i < k && lastNodeOfGroup!=null; i++){
                lastNodeOfGroup=lastNodeOfGroup.next;
            }
            if(lastNodeOfGroup==null)
                break;

            //Step2: Find remaining values
            ListNode firstNodeOfGroup = nodeBeforeGroup.next;
            ListNode firstNodeOfNextGroup = lastNodeOfGroup.next;

            //Step3: Reverse k group
            ListNode prev =firstNodeOfNextGroup;
            ListNode curr = firstNodeOfGroup;
            while(curr!=firstNodeOfNextGroup){
                ListNode nextNode = curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextNode;
            }

            //Step4: reconnect the kth group to the list
            nodeBeforeGroup.next = lastNodeOfGroup;
            nodeBeforeGroup= firstNodeOfGroup;
        }
        return dummy.next;
    }
}
