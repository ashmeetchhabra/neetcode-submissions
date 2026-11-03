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
    public int maxDepth(TreeNode root) {
        //RECURSIVE:
        // if(root==null)
        //     return 0;
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // return Math.max(left,right)+1;

        //ITERATIVE:
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height=0;

        while(true){
            int currLevel= q.size();
            //breaking condition
            if(currLevel==0)
                return height;

            while(currLevel>0){
                TreeNode node = q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                currLevel--;
            }
            height++;
        }        
    }
}
