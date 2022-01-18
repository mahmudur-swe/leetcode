class Solution {
    
    class Edge{
        public int node;
        public int cost;
        public Edge(int node,int cost){
            this.node = node;
            this.cost = cost;
        };
    }
    
    public int minimumCost(int n, int[][] connections) {
        
        Map<Integer,List<Edge>> map = new HashMap();
        
        boolean[] isVisited = new boolean[n+1];
        int cost = 0;
        int totalVisited = 0;
        
        totalVisited = 1;
        
    PriorityQueue<Edge> pq = new PriorityQueue(new Comparator<Edge>() {
    public int compare(Edge edge1, Edge edge2) {
        
        return edge1.cost - edge2.cost;
    }
});
        
        for(int i=0;i<connections.length;i++){
            
            List<Edge> list1 = map.getOrDefault(connections[i][0],new ArrayList());
            
            list1.add(new Edge(connections[i][1],connections[i][2]));
            
            map.put(connections[i][0], list1);
            
            
            List<Edge> list2 = map.getOrDefault(connections[i][1],new ArrayList());
            
            list2.add(new Edge(connections[i][0],connections[i][2]));
            
            map.put(connections[i][1], list2);
            
        }
        
        
        pq.addAll(map.get(connections[0][0]));
        isVisited[connections[0][0]] = true;

        while(pq.size()>0){
            
            Edge e = pq.poll();
            
            //System.out.println(e.node +" " + e.cost);
            
            if(isVisited[e.node]){
                continue;
            }
            
            totalVisited++;
            cost+= e.cost;
            
            if(totalVisited==n){
                return cost;
            }
            
            isVisited[e.node] = true;
            
            for(Edge ex:map.get(e.node)){
                if(!isVisited[ex.node]){
                    pq.add(ex);
                }
            }
            
            
        }
        
        return -1;
        
    }
}