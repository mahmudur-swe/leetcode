class Solution {
    
    boolean[] isTraveled;
    int[] dp;
    
    Set<Integer> sourceBus = new HashSet();
    
    Set<Integer> targetBus = new HashSet();
    
    int[][] routes;
    
    List<List<Integer>> graph = new ArrayList();
    
            
    int ans = -1;
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target){
            return 0;
        }
        
        isTraveled = new boolean[routes.length+1];
        dp = new int[routes.length+1];   
        Arrays.fill(dp,-1);
        
        this.routes = routes;
        
        for(int i=0;i<routes.length;i++){
            
            graph.add(new ArrayList());
            
            Arrays.sort(routes[i]);
            
            if(Arrays.binarySearch(routes[i],source)>=0){
                sourceBus.add(i);
            }
            
            if(Arrays.binarySearch(routes[i],target)>=0){    
                targetBus.add(i);
            }
            
        }
        
      for (int i = 0; i < routes.length; ++i)
            for (int j = i+1; j < routes.length; ++j)
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

        
        sourceBus.stream().forEach((bus) -> {
            int res = getBusCount(bus);
            if(res>0){
                if(ans == -1){
                    ans = res;
                }else{
                     ans = Math.min(ans,res);
                }
             
            }
        });
        
        
        return ans;
        
    }
    
      public boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) i++; else j++;
        }
        return false;
    }
    
    private int getBusCount(int bus){
        
        if(isTraveled[bus]){
            return 0;
        }
        
        if(dp[bus]>=0){
            return dp[bus];
        }
        
        if(targetBus.contains(bus)){
            return dp[bus] = 1;
        }
        
        isTraveled[bus] = true;
        
        int res = -1;
        
        for(int j=0;j<graph.get(bus).size();j++){
                
                if(!isTraveled[graph.get(bus).get(j)]){
                    
                    //int next = Arrays.binarySearch(routes[j],routes[bus][i]);
                    
                    //if(next>=0)
                    {
                        int val = getBusCount(graph.get(bus).get(j));
                        
                        if(val>0){
                             if(res==-1){
                                res = 1 + val;
                            }else{
                                res = Math.min(res, 1 + val);
                            }
                        }
                    }
                    
                }
                
            }
        
        if(res==-1){
            return dp[bus] = 0;
        }
        
        return dp[bus] = res;
        
        
        
    }
    
}