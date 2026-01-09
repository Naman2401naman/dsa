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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<TreeNode> lastLine=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            lastLine=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                lastLine.add(curr);
                 if (curr.left != null) {
                    parent.put(curr.left, curr);
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    parent.put(curr.right, curr);
                    queue.offer(curr.right);
                }
            }
        }
        if (lastLine.size() == 1) {
            return lastLine.get(0);
        }
        Set<TreeNode> set=new HashSet<>(lastLine);
        while(set.size()>1){
            Set<TreeNode> next = new HashSet<>();
            for(TreeNode node:set){
                next.add(parent.get(node));
            }
            set=next;
        }
        return set.iterator().next();
    }
}