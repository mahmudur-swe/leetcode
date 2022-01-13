class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        if(s.charAt(s.length()-1) == '1'){
            return false;
        }
        
        if(maxJump >= s.length()-1){
            return true;
        }
        
        
        Queue<Integer> pq = new LinkedList();
        
        int lastPos = 0;
        
        for(int i=minJump; i<= maxJump;i++){
            
            if(i==s.length()-1){
                return true;
            }
            
             
            if(i>=s.length()){
                return false;
            }
            
            if(s.charAt(i)=='0'){
                pq.add(i);
            }
            lastPos = i;
        }
        
        while(!pq.isEmpty()){
            
            int x = pq.poll();
            
            for(int i= Math.max(lastPos+1,x+minJump);i<=x+maxJump;i++){
                
               if(i==s.length()-1){
                    return true;
                }
                
                if(i>=s.length()){
                    return false;
                }
                
                if(s.charAt(i)=='0'){
                    pq.add(i);
                }
                
                lastPos = i;
                
            }
            
            
        }
        
        return false;
        
    }
}