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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        int n=preorder.length-1;
        int m=inorder.length-1;
        TreeNode root=construct(preorder,inorder,indexMap,0,n,0,m);
        return root;
    }
    static TreeNode construct(int[] preorder, int[] inorder, HashMap<Integer,Integer> indexMap,int preIndst,int preIndend,int inIndst,int inIndend){
        // base condition
        if(preIndst>preIndend || inIndst>inIndend){
            return null;
        }
        int rootData=preorder[preIndst];
        int rootIndex=indexMap.get(rootData);
        TreeNode root=new TreeNode(rootData);
        int leftree=rootIndex-inIndst;
        int rightree=inIndend-rootIndex;
        root.left=construct(preorder,inorder,indexMap,preIndst+1,preIndst+leftree,inIndst,rootIndex-1);
        root.right=construct(preorder,inorder,indexMap,preIndst+leftree+1,preIndst+leftree+rightree,rootIndex+1,inIndend);
        return root;
    }
}