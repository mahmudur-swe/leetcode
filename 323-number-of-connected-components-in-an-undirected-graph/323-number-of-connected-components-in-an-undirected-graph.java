class Solution {
    
    boolean[] isVisited;
    List<Integer>[] graph;
    
    public void dfs(int node){
        
        isVisited[node] = true;
        
        
        for(int val:graph[node]){
            if(!isVisited[val]){
                dfs(val);
            }
        }
        
    }
    
    
    public int countComponents(int n, int[][] edges) {
        
        
        graph  = new List[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }
        
        for(int[] edge:edges){
            
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            
        }
        
        isVisited = new boolean[n];
        
        int ans =0;
        
        for(int i=0;i<n;i++){
            
            if(!isVisited[i] ){
                
                dfs(i);
                
                ans++;
            }
            
        }
        
        
        return ans;
        
    }
}