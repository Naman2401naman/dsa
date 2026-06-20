class Solution {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        f(root, p, q);

        return ans;
    }

    private int f(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        if(root == null) {
            return 0;
        }

        int left = f(root.left, p, q);

        int right = f(root.right, p, q);

        int self = 0;

        if(root == p || root == q) {
            self = 1;
        }

        int total = left + right + self;

        if(total >= 2 && ans == null) {
            ans = root;
        }

        return total > 0 ? 1 : 0;
    }
}