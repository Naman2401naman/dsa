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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp=new HashMap<>();
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<descriptions.length;i++){
            int parent=descriptions[i][0];
            int child=descriptions[i][1];
            mp.putIfAbsent(parent,new TreeNode(parent));
            mp.putIfAbsent(child,new TreeNode(child));

            TreeNode p=mp.get(parent);
            TreeNode c=mp.get(child);
            if(descriptions[i][2]==1){
                p.left=c;
            }else{
                p.right=c;
            }
            st.add(child);
        }
        for(int key: mp.keySet()){
            if(!st.contains(key)){
                return mp.get(key);
            }
        }
        return null;
    }
}