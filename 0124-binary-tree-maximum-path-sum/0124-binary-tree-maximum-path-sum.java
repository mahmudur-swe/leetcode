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

  int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

         if(root==null){
            return 0;
        }
     
        calculateSum(root);
        return ans;
    }

    private int calculateSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = calculateSum(root.left);
        int right = calculateSum(root.right);

  ans = Math.max(ans, Math.max(root.val,Math.max(root.val+left,Math.max(root.val+right,root.val+left+right))));

        return Math.max( root.val, root.val + Math.max(left,right));

    }

}