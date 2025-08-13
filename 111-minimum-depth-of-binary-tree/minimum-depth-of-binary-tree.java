class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // Empty tree
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; // Start at root level

        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes in current level

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // If it's a leaf, return depth
                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                // Add children to queue
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            depth++; // Move to next level
        }

        return depth;
    }
}
