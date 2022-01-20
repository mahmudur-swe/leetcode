class Solution {
    
    int max;
    
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
    
    //Map<Integer,Integer> dp;
    
    int[] dp;
    
    //Map<Integer,List<Node>> map;
    
    List<Node> nodes;
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        dp = new int[5*10001];
        
        Arrays.fill(dp,-1);
        
        nodes = new ArrayList();
        
        
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
        

        
        return getAns(0);
    }
    
    public int getAns(int pos){
        
        if(pos>=nodes.size()){
            return 0;
        }
        
        if(dp[pos]!=-1){
            return dp[pos];
        }
        
        
        int index = getNextNode(nodes.get(pos).end);
        
        
        int ans = Math.max(getAns(pos+1), nodes.get(pos).profit + getAns(index));
        

        return dp[pos] = ans;
        
        
    }
    
    private int getNextNode(int endTime){
        
        int start = 0;
        int end = nodes.size()-1;
        
        int ans = end+1;
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(nodes.get(mid).start < endTime){
                start = mid+1;
            }else if(nodes.get(mid).start>=endTime){
                end = mid-1;
                ans = mid;
            }
            
        }
        
        return ans;
        
    }
    
    
}