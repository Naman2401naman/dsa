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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> pathSum = new Stack<>();
        stack.push(root);
        pathSum.push(root.val);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            int tempval=pathSum.pop();

            if(temp.left==null && temp.right==null && tempval==targetSum){
                return true;
            }
            if(temp.right!=null){
                stack.push(temp.right);
                pathSum.push(temp.right.val + tempval);
            }
            if(temp.left!=null){
                stack.push(temp.left);
                pathSum.push(temp.left.val + tempval);
            }
        }
        return false;
    }
}