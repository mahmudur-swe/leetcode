class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1){
            return new int[]{};
        }
        
        int pos=0;
        
        Arrays.sort(changed);
        
        int[] ans = new int[changed.length/2];
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i=0;i<changed.length;i++){
            
            //System.out.println(changed[i] + " " + pq.size());
            
            if(pq.size()==0){
                
                pq.add(changed[i]);
                
            }else if(pq.peek()*2==changed[i]){
                //System.out.println("pq "+pq.peek());
                
                if(pos>=ans.length){
                   return new int[]{};
                }
                
                ans[pos++] = pq.poll();
                
                //System.out.println("pq size "+pq.size());
            }else{
                //System.out.println("pq peek "+pq.peek());
                pq.add(changed[i]);
            }
            
        }
        
        if(pq.size()==0){
            return ans;
        }
        
        return new int[]{}; 
        
    }
}