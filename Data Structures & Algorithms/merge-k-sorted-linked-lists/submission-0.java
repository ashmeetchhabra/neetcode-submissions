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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        return mergeListsHelper(lists,0,lists.length-1);
    }

    private ListNode mergeListsHelper(ListNode[] lists, int start, int end){
        if(start==end)
            return lists[start];
        if(start+1 == end)
            return merge2Lists(lists[start], lists[end]);
        int mid = (start+end)/2;
        ListNode left = mergeListsHelper(lists, start, mid);
        ListNode right = mergeListsHelper(lists, mid+1, end);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode returnNode = new ListNode(0);
        ListNode headNode = returnNode;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                returnNode.next= l1;
                l1=l1.next;
            }else{
                returnNode.next=l2;
                l2=l2.next;
            }
            returnNode=returnNode.next;
        }
        returnNode.next= l1!=null ? l1:l2; 
        return headNode.next;
    }
}
