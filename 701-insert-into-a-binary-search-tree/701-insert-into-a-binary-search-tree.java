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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root==null){
            return newNode;
        }
        TreeNode head = root;
        while(root!=null){
            if(root.val>val){
                
                if(root.left==null){
                    root.left = newNode;
                    break;
                }
                root = root.left;
                
            }else{
                
                if(root.right==null){
                    root.right = newNode;
                    break;
                }
                root = root.right;
                
            }
            
        }
        
        
        return head;
    }
}