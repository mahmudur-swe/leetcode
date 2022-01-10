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
            pathQ.add(q);
            q = q.parent;
        }
        
        int ps=pathP.size()-1;
        int qs=pathQ.size()-1;
        
        Node ans = null;
        
        while(true){
            
            if(ps< 0 || qs<0){
                return ans;
            }
            
            if(pathP.get(ps--).val == pathQ.get(qs--).val){
                ans = pathP.get(ps+1);
            }else{
                return ans;
            }
            
        }
    }
}