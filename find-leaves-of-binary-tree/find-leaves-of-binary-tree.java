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
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        
        getAns(root,ans);
        
        return ans;
    }
    
    public int getAns(TreeNode root,List<List<Integer>> ans){
        
        
        if(root==null){
            return 0;
        }
        
        int left = getAns(root.left,ans);
        int right = getAns(root.right,ans);
        
        int index = 1 + Math.max(left,right);
        
        //System.out.println("Index " + index + " " + root.val);
        
        if(ans.size()>=index){
            ans.get(index-1).add(root.val);
        }else{
            ans.add(new ArrayList(Arrays.asList(root.val)));
        }
    
        return index;
        
    }
    
}