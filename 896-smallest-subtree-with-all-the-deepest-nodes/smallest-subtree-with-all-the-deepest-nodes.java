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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        // Step 1: Parent map
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        // BFS queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // To store last level nodes
        List<TreeNode> lastLevel = new ArrayList<>();

        // Step 2: BFS to find last level and parents
        while (!queue.isEmpty()) {
            int size = queue.size();
            lastLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                lastLevel.add(curr);

                if (curr.left != null) {
                    parent.put(curr.left, curr);
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    parent.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }

        // Step 3: If only one deepest node
        if (lastLevel.size() == 1) {
            return lastLevel.get(0);
        }

        // Step 4: Move upward until all nodes become same
        Set<TreeNode> set = new HashSet<>(lastLevel);

        while (set.size() > 1) {
            Set<TreeNode> next = new HashSet<>();
            for (TreeNode node : set) {
                next.add(parent.get(node));
            }
            set = next;
        }

        // Step 5: Return the common parent
        return set.iterator().next();
    }
}
