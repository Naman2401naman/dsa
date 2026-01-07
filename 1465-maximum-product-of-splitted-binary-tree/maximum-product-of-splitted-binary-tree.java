class Solution {
    long mod = 1000000007;
    long total = 0;
    long ans = 0;

    public int maxProduct(TreeNode root) {
        chng(root);           // convert tree to subtree sums
        total = root.val;     // total sum of tree
        max(root);            // compute max product
        return (int)(ans % mod);
    }

    void chng(TreeNode root) {
        if (root == null) return;

        chng(root.left);
        chng(root.right);

        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;

        root.val = root.val + leftVal + rightVal;
    }

    void max(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            long part = root.left.val;
            ans = Math.max(ans, part * (total - part));
        }

        if (root.right != null) {
            long part = root.right.val;
            ans = Math.max(ans, part * (total - part));
        }

        max(root.left);
        max(root.right);
    }
}
