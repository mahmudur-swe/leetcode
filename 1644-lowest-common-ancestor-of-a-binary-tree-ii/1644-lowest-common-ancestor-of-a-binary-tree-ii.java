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
    boolean isFoundP;
    boolean isFoundQ;
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        root = getAns(root,p,q);
        
        if(isFoundP && isFoundQ){
            return root;
        }
        return null;
        
    }
    
    
    public TreeNode getAns(TreeNode root, TreeNode p, TreeNode q) {
        
        
        if(root == null){
            return null;
        }
        
        if(root.val == p.val){
            isFoundP = true;    
        }
        
        
        if(root.val == q.val){
            isFoundQ = true;
            
        }
        
        TreeNode left = getAns(root.left,p,q);
        TreeNode right = getAns(root.right,p,q);
        
        if((left!=null && right!=null) || (root.val == p.val || root.val == q.val)){
            return root;
        }else if(left!=null){
            return left;
        }
        return right;
        
    }
}