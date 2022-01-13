class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int index = -1;
        
        int val = 0;
        
        int min = 0;
        
        
        for(int i=0;i<gas.length;i++){
            
        
            int sum = val - cost[i] + gas[i];
            
            if(sum<=min){
                index = i;
                min = sum;
            }
            
            val = sum;
            
        }
        
        if(val<0){
            return -1;
        }
        
        return (index+1)%gas.length;
        
    }
}