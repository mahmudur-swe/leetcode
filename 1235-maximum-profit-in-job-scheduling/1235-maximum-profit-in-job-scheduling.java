class Solution {
    
    class Node{
        int start;
        int end;
        int profit;
        public Node(int start,int end,int profit){
            
            this.start = start;
            this.end = end;
            this.profit = profit;
            
        }
    }
    
    Map<Integer,Integer> dp;
    
    
    Map<Integer,List<Node>> map;
    
    List<Node> nodes;
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        dp = new HashMap();
        
        nodes = new ArrayList();
        
        map = new HashMap();
        
        for(int i=0;i<startTime.length;i++){
            nodes.add(new Node(startTime[i],endTime[i],profit[i]));
        }
        
        Collections.sort(nodes,new Comparator<Node>(){
            public int compare(Node node1,Node node2){
                
//                 if(node1.start == node2.start){
                    
//                     if(node1.end == node2.end){
                        
//                         return node2.profit - node1.profit;
//                     }
                    
//                     return node1.end - node2.end;
                    
//                 }
                
                return node1.start-node2.start;
                
            }
        });
        
        int n = nodes.get(nodes.size()-1).start;
        int start = nodes.get(0).start;
        
        
        for(Node node:nodes){
            List<Node> ns = map.getOrDefault(node.start,new ArrayList());
            ns.add(node);
            map.put(node.start,ns);
            
        }
        
        return getAns(start,n);
    }
    
    public int getAns(int pos,int n){
        
        if(pos>n){
            return 0;
        }
        
        if(dp.get(pos)!=null){
            return dp.get(pos);
        }
        
        int x = 0;
        
        if(map.get(pos) != null){
            
            for(Node node:map.get(pos)){
                
                x = Math.max(x, node.profit + getAns(node.end,n));
                
            }
            
        }
        
        Node nxt = getNextNode(pos);
        
        if(pos!=nxt.start)
        {
            x = Math.max(x,getAns(nxt.start,n));
        }
        
        dp.put(pos,x);
        
        return x;
        
    }
    
    private Node getNextNode(int endTime){
        
        int start = 0;
        int end = nodes.size()-1;
        
        while(start<end){
            
            int mid = start + (end-start)/2;
            
            if(nodes.get(mid).start <= endTime){
                start = mid+1;
            }else if(nodes.get(mid).start>endTime){
                end = mid;
            }
            
        }
        
        return nodes.get(end);
        
    }
    
    
}