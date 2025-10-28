/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        // 1. Handle the special edge case for depth == 1
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        // 2. Handle the null root case
        if (root == null) {
            return null; // Fixed this return
        }

        // 3. Set up BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // 'currentDepth' tracks the level of the nodes we are about to process
        int currentDepth = 1;

        // Loop *until* we reach the level *before* the target depth
        while (currentDepth < depth - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add children to the queue for the next level
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // We have finished processing the level
            currentDepth++;
        }
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left=parent.left;
            newRight.right=parent.right;
            parent.left=newLeft;
            parent.right=newRight;
        }
        return root;
    }
}