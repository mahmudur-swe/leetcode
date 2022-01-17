class Solution {
    
    int parent[];
    int size[];
    
    
    private int find(int A){
        
        int root = A;
        
        while(root != parent[root]){
            root = parent[root];
        }
    
//         while( A != root) {
//             int old = parent[A];
//             parent[A] = root;
//             A = old;
            
            
//         }
        
        return root;
        
    }

    
    
    
    public int countComponents(int n, int[][] edges) {
        
        
        parent  = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        int count = 0;
        
        for(int[] edge:edges){
            
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);
            
            if(rootA != rootB){
                
                count++;
                
                if(size[rootA]>size[rootB]){
                    
                    parent[rootB] = rootA;
                    size[rootA] += rootB;
                    
                }else{
                    parent[rootA] = rootB;
                    size[rootB] += rootA;
                 
                }
                
            }
            
            
            
        }
        
        
        
        return n-count;
        
    }
}