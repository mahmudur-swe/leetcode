/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasAncestor(root,p,q);

        if(ans==null){
            ans = root;
        }

        return ans;

    }



    private boolean hasAncestor(TreeNode root, TreeNode p, TreeNode q){

        if(root==null){
            return false;
        }

        if(root.val == p.val || root.val == q.val){
            //return true;
        }

        if(ans!=null){
            return false;
        }

        boolean LeftHas = hasAncestor(root.left, p, q);
        boolean rightHas = hasAncestor(root.right, p, q);

        if(ans == null){
            if(LeftHas && rightHas){
                ans = root;
            }else if((LeftHas || rightHas) && (root.val == p.val || root.val == q.val)){
                ans = root;
            }
        }

        return LeftHas || rightHas || root.val == p.val || root.val == q.val;
    }  

}