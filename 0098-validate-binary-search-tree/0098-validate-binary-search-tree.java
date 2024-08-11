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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,99999999999L,-99999999999L );
    }

    public boolean isValidBST(TreeNode root,long max,long min) {
        
        if(root==null){
            return true;
        }

        if(root.val>=max){
            return false;
        }

        if(root.val<=min){
            return false;
        }

        boolean isLeftValid = isValidBST(root.left, root.val, Math.min(min,root.val));

        boolean isRightValid = isValidBST(root.right, Math.max(max,root.val), root.val);

        return isLeftValid && isRightValid;
    }

}