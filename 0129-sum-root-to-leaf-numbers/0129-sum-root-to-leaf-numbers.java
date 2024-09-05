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
    public int sumNumbers(TreeNode root) {
        sum(root,0);
        return ans;
  
    }

    private void sum(TreeNode root, int totalSum){


        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            ans += (totalSum *10 + root.val);
            return;
        }

        if(root.left !=null){
            sum(root.left, totalSum *10 + root.val);
        }

        if(root.right !=null){
            sum(root.right, totalSum *10 + root.val);
        }



    }
}