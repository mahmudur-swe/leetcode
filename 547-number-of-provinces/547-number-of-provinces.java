class Solution {
    
    boolean[] isVisited;
    int[][] isConnected;
    
    private void traverse(int node){
        
        isVisited[node] = true;
        
        //System.out.println(node);
        
        for(int i=0;i<isConnected.length;i++){
            
            
            if(isConnected[node][i] == 1 && !isVisited[i]){
                
                //System.out.println("val " + val);
                traverse(i);
            }
            
        }
        
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        isVisited = new boolean[isConnected.length];
        this.isConnected = isConnected;
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            
            if(!isVisited[i]){
                //System.out.println("Trave " + i);
                traverse(i);
                ans++;
            }
            
        }
        
        return ans;
        
    }
}