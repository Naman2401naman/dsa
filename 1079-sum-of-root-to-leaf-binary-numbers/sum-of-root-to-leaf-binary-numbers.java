class Solution {

    Stack<Integer> res = new Stack<>();
    int Ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root);
        return Ans;
    }

    private void dfs(TreeNode root) {

        if (root == null)
            return;

        // push current bit
        res.push(root.val);

        // if leaf → calculate binary value
        if (root.left == null && root.right == null) {
            Ans += binary(res);
        }

        // go left and right
        dfs(root.left);
        dfs(root.right);

        // backtrack
        res.pop();
    }

    int binary(Stack<Integer> an) {

        int ans = 0;
        int power = an.size() - 1;

        for (int bit : an) {
            ans += bit * (1 << power);
            power--;
        }

        return ans;
    }
}