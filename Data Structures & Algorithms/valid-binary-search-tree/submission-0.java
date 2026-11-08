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
    public boolean isValidBST(TreeNode root) {
        //RECURSIVE:
        // return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        //INORDER
        List<Integer> inOrder = new ArrayList<>();
        helper(root, inOrder);
        boolean isBST=true;
        int prev = inOrder.get(0);
        for(int i = 1; i<inOrder.size() ; i++){
            if(prev>=inOrder.get(i))
                isBST=false;
            prev=inOrder.get(i);
        }
        return isBST;
    }

    private boolean isBST(TreeNode root, long minVal, long maxVal){
        if(root==null)
            return true;
        if(minVal>=root.val || root.val >=maxVal){
            return false;
        }
        return isBST(root.left, minVal, root.val) && isBST(root.right, root.val, maxVal);
    }

    void helper(TreeNode node, List<Integer> inOrder){
        if(node==null)
            return;
        helper(node.left, inOrder);
        inOrder.add(node.val);
        helper(node.right,inOrder);
    }
}
