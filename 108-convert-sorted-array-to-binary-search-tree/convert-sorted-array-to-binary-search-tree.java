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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray(nums,0,nums.length-1);
    }
    TreeNode sortedArray(int[] nums ,int n,int first){
       if(n>first){
        return null;
       }
       int mid=n+(first-n)/2;
       TreeNode root=new TreeNode(nums[mid]);
       root.left=sortedArray(nums,n,mid-1);
       root.right=sortedArray(nums,mid+1,first);
       return root;
    }
}