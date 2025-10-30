import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = postorder.length - 1;
        int m = inorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        
        // Initial call uses the full range for both arrays
        return construct(postorder, hash, 0, n, 0, m);
    }

    /**
     * @param postSt  Start index of the current postorder slice
     * @param postEnd End index of the current postorder slice
     * @param inSt    Start index of the current inorder slice
     * @param inEnd   End index of the current inorder slice
     */
    TreeNode construct(int[] postorder, HashMap<Integer, Integer> hash,
                       int postSt, int postEnd, int inSt, int inEnd) {
        
        // Base case: If either slice is empty
        if (postSt > postEnd || inSt > inEnd) {
            return null;
        }

        // 1. Root is the LAST element in the postorder slice
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);

        // 2. Find root's position in the inorder slice
        int rootIndex = hash.get(val);

        // 3. Calculate the size of the left subtree
        // This is the number of nodes between the start of the inorder
        // slice and the root's index.
        int leftTreeSize = rootIndex - inSt;

        // 4. Build the RIGHT subtree first
        // (Postorder is Left -> Right -> Root, so we build in reverse: Root -> Right -> Left)
        root.right = construct(postorder, hash,
                               postSt + leftTreeSize,  // Right-post-start: after left nodes
                               postEnd - 1,            // Right-post-end: before the root
                               rootIndex + 1,          // Right-in-start: after the root
                               inEnd);                 // Right-in-end: original end

        // 5. Build the LEFT subtree
        root.left = construct(postorder, hash,
                              postSt,                   // Left-post-start: original start
                              postSt + leftTreeSize - 1, // Left-post-end: after left nodes
                              inSt,                     // Left-in-start: original start
                              rootIndex - 1);           // Left-in-end: before the root

        return root;
    }
}