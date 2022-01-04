class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1){
            return new int[]{};
        }
        
        int pos=0;
        
        Arrays.sort(changed);
        
        int[] ans = new int[changed.length/2];
        
        
        int k = 1;
        
        for(int i=0;i<changed.length;i++){
            
            //System.out.println(changed[i] +" " + k);
            
            if(changed[i] == -1){
                continue;
            }
            
            if(k<=i){
                k = i+1;
            }
            
            while(k<changed.length && changed[i]*2!=changed[k]){
                k++;
            }
            
            if(k<changed.length){
                if(pos>=ans.length){
                    return new int[]{};
                }
                changed[k] = -1;
                ans[pos++] = changed[i];
                k++;
            }
            
        }
        
        if(pos == ans.length){
            return ans;
        }
        
        return new int[]{}; 
        
    }
}