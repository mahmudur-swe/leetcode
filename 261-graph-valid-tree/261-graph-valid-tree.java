class Solution {
    
    boolean[] isVisited;
    
    private boolean getAns(int p,int v,List<Integer>[] list){
        
        isVisited[v] = true;
        
        //System.out.println(p+" "+v);
        
        for(Integer x:list[v]){
            if(!isVisited[x]){
                if(getAns(v,x,list)){
                    return true;
                }
            }else if(x!=p){
                return true;
            }
        }
        return false;
    }
    
    public boolean validTree(int n, int[][] edges) {
   
        if(n==1){
            return true;
        }
        
        isVisited = new boolean[n];
        
        //Arrays.sort(edges, Comparator.comparingInt(a -> a[0]));
        
        List<Integer>[] list = new List[n];
        
        for(int[] edge:edges){
            
            if(list[edge[0]] ==null){
                list[edge[0]] = new ArrayList();
            }
            
            if(list[edge[1]] ==null){
                list[edge[1]] = new ArrayList();
            }
            
            list[edge[0]].add(edge[1]);
            
            list[edge[1]].add(edge[0]);
            
        }
        
        boolean ans = true;
        
        int startCount = 0;
        
        if(!isVisited[0] && list[0]!=null && list[0].size()>0){   
            if(getAns(-1,0,list)){
                return false;
            }  
        }
        
        
        for(int i=0;i<n;i++){
            
            if(!isVisited[i]){
                return false;
            }
            
        }
        
        
        return true;
        
        
    }
}