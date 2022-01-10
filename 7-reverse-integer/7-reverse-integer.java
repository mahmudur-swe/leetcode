class Solution {
    public int reverse(int x) {
        
        if(x==0){
            return 0;
        }
        
        if(x== Integer.MAX_VALUE || x == Integer.MIN_VALUE){
            return 0;
        }
        
        int ans = 0;
        
        
        while(x!=0){
            
            
            if(((ans*10)/10 != ans  || (ans*10 + (x%10))/10 != ans)){
                return 0;
            }
            
            
            ans *= 10; ans+=(x%10);
            
            
            x/=10;
        }
        
        return ans;
        
    }
}