/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //RECURSIVE:
        // if(p==null && q==null)
        //     return true;
        // if(p==null || q == null || p.val!=q.val)
        //     return false;
        
        // return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));

        //ITERATIVE:
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(p);
        qu.add(q);
        while(!qu.isEmpty()){
            TreeNode node1 = qu.poll();
            TreeNode node2= qu.poll();

            if(node1==null && node2==null)
                continue;
            else if(node1==null || node2==null || node1.val!=node2.val)
                return false;
            
            //add the left and right child in the queue
            qu.add(node1.left);
            qu.add(node2.left);

            qu.add(node1.right);
            qu.add(node2.right);
        }
        return true;
    }
}
