class Solution {
    
    public static class Node{
        long sum = 0;
        long propagate = 0;
        public Node(){}
    }
    
    public int[] getModifiedArray(int length, int[][] updates) {
        
        Node[] nodes = new Node[length*4];
        
        for(int i=0;i<updates.length;i++){
            updateValue(nodes,0, 0, length-1, updates[i][0],updates[i][1],updates[i][2]);
        }
        
        int[] ans = new int[length];
        
        for(int i=0;i<length;i++){
            ans[i] = (int) query(nodes,0,0,length-1,i,i,0);
        }
        return ans;
        
    }
    
    public void updateValue(Node[] node,int pos,int b,int e,int i,int j,int value){
        
        if(e<i || b>j){
            return;
        }
        
            
        if(pos>=node.length){
            return;
        }
       
        if(node[pos] == null)
            node[pos] = new Node();
        
        if(b==e){
            
            node[pos].sum += value;
            //System.out.println(pos + " " + b + " " + e + " " + node[pos].sum + " " + value);
            return;
        }
        
        if(b>=i && e<=j ){
            
            node[pos].sum += ((e-b+1)*(value));
            
            node[pos].propagate += value;
            
            // System.out.println(pos + " " + b + " " + e + " " + node[pos].sum + " " +    node[pos].propagate  + " " + value);
            
            return;
        }
        
        int mid = (b+e)/2;
        
        updateValue(node,pos*2+1,b,mid,i,j,value);
        
        updateValue(node,pos*2+2,mid+1,e,i,j,value);
        
    }
    
    public long query(Node[] node,int pos,int b,int e,int i,int j,long propagate){
        
        if(e<i || b>j){
            return 0;
        }
        
        if(pos>=node.length){
            return 0;
        }
       
        if(node[pos] == null)
            node[pos] = new Node();
        
        if(b==e){
            return node[pos].sum + propagate;
        }
        
        if(b>=i && e<=j){
            return node[pos].sum + (e-b+1) * propagate;
        }
        
        int mid = (b+e)/2;
        
        long p1 = query(node,pos*2+1,b,mid,i,j, node[pos].propagate + propagate);
        long p2 = query(node,pos*2+2,mid+1,e,i,j, node[pos].propagate + propagate);
        
        return p1+p2;
        
    }
}