class Solution {
    public int minTaps(int n, int[] ranges) {
        
        Stack<Pair<Integer,Integer>> coveredArea = new Stack();
        
        
        Map<Integer,Integer> start = new HashMap();
        
        for(int i=0;i<ranges.length;i++){
            
            if(ranges[i]==0){
                continue;
            }
            
            int min = Math.max(0,i-ranges[i]);
            
            int max = Math.min(n,i+ranges[i]);
            
        
            
            int next = Math.max(start.getOrDefault(min,0),max);
             
            start.put(min,next);
            
        }
        int ans = 0;
        
        int minPos = 0;
        int maxPos = 0;
        
        int prePos = 0;
        
        for(int i=0;i<=n;i++){
 
            if(i > maxPos){
                return -1;
            }
                       
            int val = start.getOrDefault(i,0);
            
            maxPos = Math.max(val,maxPos);
            //if(val>0)
            //System.out.println(i +" : " + val +" "+ maxPos+" "+minPos);
            
            if(minPos == i){
                minPos = maxPos;
                ans++;
            }
            
        }
        
        
        
        return ans-1;
        
        
        
        
    }
}