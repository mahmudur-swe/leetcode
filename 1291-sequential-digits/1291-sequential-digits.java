class Solution {
    
    List<Integer> ans = new ArrayList();
    
    public List<Integer> sequentialDigits(int low, int high) {
        
        getList(1,1,2,low,high);
        Collections.sort(ans);
        return ans;
    }
    
    private void getList(int start,int val,int digit,int low,int high){
        

        if(start>9){
            return;
        }
        
        if(val>=low && val<=high){
            ans.add(val);
        }
        
        //System.out.println(start +" " + digit +" "+val);
        
        if(val>high || digit>9){
            getList(start+1,start+1,start+2,low,high);
            return;
        }
        
 
        
        // if(digit>9){
        //     return;
        // }
        
        val = val*10+digit;
        
        getList(start,val,digit+1,low,high);
        
        
    }
}