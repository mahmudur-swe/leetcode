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
    
    public int maxAncestorDiff(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        ans = 0;
        maxAncestorDiff(root,root.val,root.val);
        return ans;
    }
    
    public void maxAncestorDiff(TreeNode root,int max,int min) {
        
        ans = Math.max(ans,Math.abs(max-min));
        
        if(root==null){
            return;
        }
        
        
        maxAncestorDiff(root.left,Math.max(max,root.val),Math.min(min,root.val));
        
        maxAncestorDiff(root.right,Math.max(max,root.val),Math.min(min,root.val));
        
        
        
    }
}