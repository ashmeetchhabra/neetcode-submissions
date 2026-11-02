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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode();
        ListNode curr= dummy;
        int carry=0;

        while(l1!=null || l2!=null || carry!=0){
            int v1=0;
            int v2=0;
            if(l1!=null)
                v1=l1.val;
            if(l2!=null)
                v2=l2.val;
            
            //Compute New Value
            int newValue = v1+v2+carry;
            carry = newValue/10;
            newValue=newValue%10;
            curr.next = new ListNode(newValue);

            //Shift Pointers
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}
