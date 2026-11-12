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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(sb.length()>0)
                sb.append(",");
            if(node==null)
                sb.append("n");
            else{
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty() && i<parts.length){
            TreeNode parent = q.poll();
            //Create Left Child
            if(i<parts.length && !parts[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;

            //Create Right Child
            if(i<parts.length && !parts[i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
