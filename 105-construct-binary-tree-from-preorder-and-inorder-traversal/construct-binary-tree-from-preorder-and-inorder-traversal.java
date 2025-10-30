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
        HashMap<Integer,Integer> hash=new HashMap<>();
        int n=preorder.length-1;
        int m=inorder.length-1;

        for(int i=0;i<inorder.length;i++){
            hash.put(inorder[i],i);
        }
        return construct(preorder,inorder,hash,0,n,0,m);

    }
    TreeNode construct(int[] preorder, int[] inorder,HashMap<Integer,Integer> hash,int preSt,int preN,int inSt,int inN){
        if(preN<preSt){
            return null;
        }

        int val=preorder[preSt];
        int Index=hash.get(val);
        TreeNode root=new TreeNode(val);
        root.left=construct(preorder,inorder,hash,preSt+1,preSt+(Index-inSt),inSt,Index-1);
        root.right=construct(preorder,inorder,hash,preSt+(Index-inSt)+1,preN,Index+1,inN);
        return root;
    }
}