class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int index = -1;
        
        int val = 0;
        
        int min = 0;
        
        
        for(int i=0;i<gas.length;i++){
            
        
            val += (gas[i] - cost[i]);
            
            if(val<=min){
                index = i;
                min = val;
            }
            
            
        }
        
        if(val<0){
            return -1;
        }
        
        return (index+1)%gas.length;
        
    }
}