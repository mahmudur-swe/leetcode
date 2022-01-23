class Solution {
    
    List<Integer> ans = new ArrayList();
    
    public List<Integer> sequentialDigits(int low, int high) {
        
        String max = "123456789";
        
        
        for(int i=0;i<max.length();i++){
            for(int j=i+1;j<max.length();j++){
                
                int val = Integer.parseInt(max.substring(i,j+1));
                
                if(val>=low && val<=high){
                    ans.add(val);
                }
                
            }
            
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    

}