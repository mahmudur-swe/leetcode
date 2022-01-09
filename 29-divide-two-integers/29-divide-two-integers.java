class Solution {
    public int divide(int dividend, int divisor) {
 
        if(dividend == divisor){
            return 1;
        }
        
        if(dividend == 0){
            return 0;
        }
        
        if(divisor == 1){
            return dividend;
        }
        
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        
        if(divisor == Integer.MIN_VALUE){
            return 0;
        }
        
        int ans = 0;
        
        int i = 1;
        
        boolean isPos = true;
        
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            isPos = false;
        }
        
        if(dividend == Integer.MIN_VALUE){
            
            dividend += Math.abs(divisor);
            
            if(isPos){
                ans = 1;
            }else{
                ans = -1;
            }
            
        }
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        if(dividend<divisor){
            return ans;
        }
        
        int div = divisor;
        
        while(dividend>=div){
            
            //System.out.println(dividend +" "+ divisor);
            
             
            if(dividend<divisor){
                divisor = div;
                i = 1;
            }
            
            if(isPos){
                ans += i;
            }else{
                ans -= i;
            }
           
            
            dividend -= divisor;
            
            i += i;
            divisor += divisor; 
        
        }
        
        return ans;
        
    }
}