/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    
    public Node lowestCommonAncestor(Node p, Node q) {
        
        Map<Integer,Boolean> pathP = new HashMap();
        
        while(p!=null){
            pathP.put(p.val,true);
            p = p.parent;
        }
        
        while(q!=null){
            if(pathP.get(q.val)!=null){
                return q;
            }
            q = q.parent;
        }
        
        return null;
       
    }
}