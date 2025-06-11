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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList();
        int level = 0;
        while(!queue.isEmpty()){
            List<Integer> levelOrder = new ArrayList();
            int size = queue.size();
            level++;
            while(size-->0){
                TreeNode curNode = queue.poll();
                if(curNode!=null){
                    levelOrder.add(curNode.val);
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }    
            }
            if(!levelOrder.isEmpty()){
                if(level%2==0){
                    Collections.reverse(levelOrder);
                    res.add(levelOrder);
                }
                else{
                    res.add(levelOrder);
                }
            }
            
        }

        return res;
    }
}