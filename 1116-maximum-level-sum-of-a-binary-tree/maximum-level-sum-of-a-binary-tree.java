class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int maxSum = Integer.MIN_VALUE;
        int ansLevel = 1;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int level = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                sum += curr.val;

                if (curr.left != null) que.offer(curr.left);
                if (curr.right != null) que.offer(curr.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                ansLevel = level;
            }

            level++;
        }

        return ansLevel;
    }
}
