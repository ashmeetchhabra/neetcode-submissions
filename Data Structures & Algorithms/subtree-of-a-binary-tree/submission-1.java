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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //Way1:
        // if(subRoot==null)
        //     return true;
        // if(root==null)
        //     return false;
        // if(isSameTree(root,subRoot))
        //     return true;
        // return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

        //Way2:
        String rootPreOrder = getPreOrderTraversal(root);
        String subRootPreOrder = getPreOrderTraversal(subRoot);

        return rootPreOrder.contains(subRootPreOrder);
    }

    //Helper for Way1:
    private boolean isSameTree(TreeNode s, TreeNode t){
        if(s==null && t==null)
            return true;
        if(s!=null && t!=null && s.val==t.val)
            return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
        return false;
    }

    //Helper for Way2:
    private String getPreOrderTraversal(TreeNode s){
        if(s==null)
            return "null";
        StringBuilder sb = new StringBuilder("^");
        sb.append(s.val);
        sb.append(getPreOrderTraversal(s.left));
        sb.append(getPreOrderTraversal(s.right));
        return sb.toString();
    }
}
