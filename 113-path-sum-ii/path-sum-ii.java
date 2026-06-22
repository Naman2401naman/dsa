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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res=new ArrayList<>();
        get(root,0,targetSum,new ArrayList<>());
        return res;
    }
    void get(TreeNode root,int sum,int target,List<Integer> curr){
        if(root==null){
            return;
        }
        sum+=root.val;
        curr.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                res.add(new ArrayList<>(curr)); 
            }
        }
        get(root.left,sum,target,curr);
        get(root.right,sum,target,curr);
        curr.remove(curr.size()-1);
    }
}