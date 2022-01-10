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
        Set<Integer> nodes = new HashSet<>();
        while (p != null) {
            nodes.add(p.val);
            p = p.parent;
        }
        while (q != null) {
            if (nodes.contains(q.val)) return q;
            q = q.parent;
        }
        return q;
    }
}