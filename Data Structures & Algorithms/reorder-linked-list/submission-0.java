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
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        if(head.next==null)
            return;
        
        //Step1: Find the middle of the list
        ListNode p1= head;
        ListNode p2= head;

        while(p2.next!=null && p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Step2: reverse of the second list
        ListNode currNode = p1.next;
        ListNode prevNode = null;
        p1.next=null;

        while(currNode!=null){
            ListNode nextNode = currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }

        //Step3: reorder/merge 2 lists
        p1=head;
        p2=prevNode;

        while(p2!=null){
            ListNode tmp1= p1.next;
            ListNode tmp2 = p2.next;
            p1.next=p2;
            p2.next=tmp1;
            p1=tmp1;
            p2=tmp2;
        }

    }
}
