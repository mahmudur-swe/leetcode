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
    int pos;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0){
            return null;
        }
        
        Map<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        int n = postorder.length;
           
        return createNode(map,postorder,0,n-1,n-1);
    }
    
  
    
    private TreeNode createNode(Map<Integer,Integer> map,int[] postOrder,int l1,int l2,int pos){
        
        
        if(l1>l2){
            return null;
        }
        
        if(pos<0){
            return null;
        }
        
        TreeNode root = new TreeNode(postOrder[pos]);
        
        //System.out.println(l1 + " " + l2 + " " + postOrder[pos] + " " +map.get(postOrder[pos]) + " " + pos);
        
        if(l1 == l2){
            return root;
        }
        
      
        int center = map.get(postOrder[pos]);
        
        int rDistance = l2-center;
        
        int lDistance = center - l1;
        
        TreeNode right = createNode(map,postOrder,center+1,l2,pos-1);
        
        TreeNode left = createNode(map,postOrder,l1,center-1,pos-rDistance-1);
        
        root.left = left;
        root.right = right;

        
        return root;
        
        
    }
}