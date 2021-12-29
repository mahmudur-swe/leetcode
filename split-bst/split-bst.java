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
    public TreeNode[] splitBST(TreeNode root, int target) {

        TreeNode lower = null;
        TreeNode upper = null;
        
        if(root==null){
            return new TreeNode[]{null,null};
        }
        
        TreeNode previous = null;
        
        while(root!=null){
            
            if(root.val<=target){
                
          
                
                TreeNode right = root.right;
                
                TreeNode tmp = root;
            
                tmp.right = null;
                
                lower = merge(lower,tmp);
                
                
                if(previous != null){
                    previous.left = right;
                }
                
                root = right;

                
            } else{
                
                if(upper == null){
                    upper = root;
                }

                 previous = root;
    
                 root = root.left;
                
            }
            
            
        } 
        
        return new TreeNode[]{lower,upper};
        
    }
    
    TreeNode merge(TreeNode node1,TreeNode node2){
        
       
        if(node1==null){
            return node2;
        }
        
        if(node2==null){
            return node1;
        }
        
       
        
        TreeNode head = node1;
        
        while(node1.right!=null){
            
            node1 = node1.right;
            
            
        }
        
        node1.right = node2;
        
        return head;
        
    }
}