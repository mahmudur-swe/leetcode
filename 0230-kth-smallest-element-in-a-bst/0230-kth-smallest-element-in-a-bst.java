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

    int ans = -1;


    public int kthSmallest(TreeNode root, int k) {
        treeCount(root,k);
        return ans;
    }


    public int treeCount(TreeNode root, int k){

        if(k<=0){
            return 0;
        }

        if(root==null){
            return 0;
        }

        if(ans!=-1){
            return 0;
        }
        
        int leftCount = treeCount(root.left,k);

        int rightCount = treeCount(root.right, (k-leftCount-1));

        if(leftCount+1==k){
            ans = root.val;
        }

        return 1+leftCount+rightCount;


    }
}