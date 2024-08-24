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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        int size  = queue.size();

        List<List<Integer>> ans = new ArrayList();

        List<Integer> internal = new ArrayList();

        while(size>0){

            int newSize = 0;

            for(int i=0;i<size;i++){

                TreeNode node = queue.remove();

                if(node!=null){
                    internal.add(node.val);
                    if( node.left!=null){
                        queue.add(node.left);
                        newSize++;
                    }

                    if( node.right!=null){
                        queue.add(node.right);
                        newSize++;
                    }
                }


            }
            if(internal.size()>0){
                 ans.add(internal);
            }
           

            internal = new ArrayList();

            size = newSize;

        }

        return ans;




    }
}