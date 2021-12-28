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
    
    boolean isFound = false;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Stack<TreeNode> targetPath = new Stack();
        
        getPath(root,target,targetPath);
        
        List<Integer> ans = new ArrayList();
        
        int previousVal = -1;
        
        
        
        while(!targetPath.isEmpty() && k>=0){
            
            TreeNode cur = targetPath.pop();
            
            //System.out.println(cur.val);
            
            getAns(cur,k,0,ans,previousVal);
            
            --k;
        }
        
        return ans;
        
    }
    
    private void getAns(TreeNode root,int k,int count,List<Integer> ans,int previousVal){
        
        if(root==null){
            return;
        }
        
        if(root.val==-1){
            return;
        }
            
        if(count>k){
            return;
        }
        
        if(count==k){
            if(root.val!=previousVal){
                ans.add(root.val);
            }
            return;
        }
        
        getAns(root.left,k,count+1,ans,previousVal);
        getAns(root.right,k,count+1,ans,previousVal);
        root.val = -1;
        
        
    }
    
    private void getPath(TreeNode root,TreeNode target,Stack<TreeNode> targetPath){
        
        if(root==null){
            return;
        }
        
        //System.out.println(root.val);
        
        if(isFound){
            return;
        }
        
        targetPath.add(root);
        
        
        if(root.val == target.val){
            isFound = true;
            return;
        }
        
        getPath(root.left,target,targetPath);
        
        if(isFound){
            return;
        }
        
        getPath(root.right,target,targetPath);
        
        if(isFound){
            return;
        }
        
        targetPath.pop();
        
        
    }
}