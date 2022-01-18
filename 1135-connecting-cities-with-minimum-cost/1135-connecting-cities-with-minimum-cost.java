class Solution {
    
    int[] parent;
    int[] size;
    
    class Edge{
        public int node;
        public int dest;
        public int cost;
        public Edge(int node,int dest,int cost){
            this.node = node;
            this.dest = dest;
            this.cost = cost;
        };
    }
    
    private int find(int A){
        
        int root = A;
        
        while(parent[root]!=root){
            root = parent[root];
        }
        
        while(A!=root){
            int tmp = parent[A];
            parent[A] = root;
            A = tmp;
            
        }
        
        return root;
        
    }
    
    public int minimumCost(int n, int[][] connections) {
        
//         Map<Integer,List<Edge>> map = new HashMap();
        
//         Map<String,Boolean> isInserted = new HashMap();
        
//        boolean[] isVisited = new boolean[n+1];
        
        parent = new int[n+1];
        size = new int[n+1];
        
        for(int i=0;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        int cost = 0;
        int totalVisited = n;
        
        //totalVisited = 2;
        
        PriorityQueue<Edge> pq = new PriorityQueue(new Comparator<Edge>() {
    public int compare(Edge edge1, Edge edge2) {
        
        return edge1.cost - edge2.cost;
    }
});
        // int max = Integer.MAX_VALUE;
        // int index1 = 1;
        // int index2 = 2;
        
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        
        for(int i=0;i<connections.length;i++){
            
            //pq.add(new Edge(connections[i][0],connections[i][1],connections[i][2]));
            int rootA = find(connections[i][0]);
            
            int rootB = find(connections[i][1]);
            
            if(rootA!=rootB){
                
                cost += connections[i][2];
                
                if(--totalVisited == 1){
                    return cost;
                }
                
                if(size[rootA]>size[rootB]){
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                }else{
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }
                
                
            }
            
        }
        

        
        
        
        return -1;
        
    }
}