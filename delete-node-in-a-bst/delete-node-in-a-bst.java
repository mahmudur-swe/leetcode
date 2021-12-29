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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode head = root;
        TreeNode previous = root;
        
        boolean isDone = false;
        boolean isLeft = true;
        
        if(root == null){
            return root;
        }
        
        if(root.val == key){
            return merge(root.left,root.right);
        }
        
        while(root!=null){
            
            
            if(root.val == key){
              
                
                if(root.left!=null){
                    
                    //System.out.println("root " + root.val + " left " + root.left.val);
                    
                    if(isLeft){
                        //System.out.println("root " + root.val + " left " + root.left.val);
                        previous.left = root.left;
                    }else{
                        previous.right = root.left;
                    }
                    
                    TreeNode node = merge(root.left.right,root.right);
                    
                    root.left.right = node;
                    
                }else if(root.right!=null){
                                   
                    
                    if(isLeft){
                        //System.out.println("root " + root.val + " left " + root.left.val);
                        previous.left = root.right;
                    }else{
                        previous.right = root.right;
                    }
                    
                    
                    TreeNode node = merge(root.right.left,root.left);
                    
                    root.right.left = node;
                    
                }else{
                    if(isLeft){
                        previous.left = null;
                    }else{
                        previous.right = null;  
                    }
                }
                
                
                break;
            }else if(root.val<key){
                isLeft = false;
                previous = root;
                root = root.right;
            }else{
                isLeft = true;
                previous = root;
                root = root.left;
            }
            
        }
        return head;
        
    }
    
    TreeNode merge(TreeNode node1,TreeNode node2){
        
        if(node1==null){
            return node2;
        }
        
        if(node2==null){
            return node1;
        }
        
        
        
        TreeNode head = node2;
        
        while(node2.left!=null){
            
            node2 = node2.left;
            
        }
        
        node2.left = node1;
        
        return head;
        
    }
}