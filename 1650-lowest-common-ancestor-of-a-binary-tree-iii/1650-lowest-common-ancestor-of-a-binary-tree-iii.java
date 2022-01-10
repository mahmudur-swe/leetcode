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
        
        List<Node> pathP = new ArrayList();
        List<Node> pathQ = new ArrayList();
        
        while(p!=null){
            pathP.add(p);
            p = p.parent;
        }
        
        while(q!=null){
            if(pathP.contains(q)){
                return q;
            }
            q = q.parent;
        }
        
        return null;
       
    }
}