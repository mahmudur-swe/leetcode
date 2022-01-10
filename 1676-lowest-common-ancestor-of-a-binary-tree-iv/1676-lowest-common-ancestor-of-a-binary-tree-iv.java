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
    Set<Integer> set = new HashSet();
        
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for(TreeNode node:nodes){
            set.add(node.val);
        }
        
        return lowestCommonAncestor(root);
    }
    
     public TreeNode lowestCommonAncestor(TreeNode root) {
        
        if(root == null){
            return null;
        }
        
        if(set.contains(root.val)){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left);
        TreeNode right = lowestCommonAncestor(root.right);
        
        if(left!=null && right!=null){
            return root;
        }else if(left!=null){
            return left;
        }
        return right;
        
    }
}