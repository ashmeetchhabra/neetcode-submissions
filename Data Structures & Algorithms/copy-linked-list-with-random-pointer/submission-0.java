/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> oldToNewMap = new HashMap<>();
        Node curr= head;

        //Step1: Just copy the nodes
        while(curr!=null){
            Node copy = new Node(curr.val);
            oldToNewMap.put(curr,copy);
            curr=curr.next;
        }

        //Step2: copy the links
        curr=head;
        while(curr!=null){
            Node copy = oldToNewMap.get(curr);
            copy.next = oldToNewMap.get(curr.next);
            copy.random = oldToNewMap.get(curr.random);
            curr=curr.next;
        }
        return oldToNewMap.get(head);
    }
}
