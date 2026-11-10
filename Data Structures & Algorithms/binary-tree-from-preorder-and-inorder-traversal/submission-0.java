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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderIndexMp = new HashMap<>();
        for(int i = 0; i<inorder.length;i++){
            inorderIndexMp.put(inorder[i],i);
        }    
        return splitBuildTree(preorder, inorderIndexMp, 0, 0, inorder.length-1);    
    }

    private TreeNode splitBuildTree(int[] preorder, Map<Integer,Integer> inorderIndexMp, int rootIndex, int left, int right){
        //build tree
        TreeNode root = new TreeNode(preorder[rootIndex]);
        //mid required to get from where to split in inorder
        int mid = inorderIndexMp.get(preorder[rootIndex]);

        //split left
        if(mid>left)
            root.left =splitBuildTree(preorder, inorderIndexMp, rootIndex+1, left, mid-1);
        //split right
        if(mid<right)
            root.right =splitBuildTree(preorder, inorderIndexMp, rootIndex+mid-left+1, mid+1, right);

        return root;
    }
}
