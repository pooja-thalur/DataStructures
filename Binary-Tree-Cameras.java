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
    int ans = 0;
    HashSet<TreeNode> set = new HashSet();
    public int minCameraCover(TreeNode root) {
        set.add(null);
        dfs(root, null);
        return ans;
    }

    void dfs(TreeNode node, TreeNode parent){
        if(node==null){
            return ;
        }

        dfs(node.left, node);
        dfs(node.right, node);

        if(parent==null && !set.contains(node) || !set.contains(node.left) || !set.contains(node.right)){
            ans++;
            set.add(node);
            set.add(parent);
            set.add(node.left);
            set.add(node.right);
        }

    }
}