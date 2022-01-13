class Solution {
    
    public double myPow(double x, int n) {
        
        if(x==0){
            return 0;
        }
        
        if(n==0){
            return 1;
        }
        
        if(n==1){
            return x;
        }
        
        if(n==-1){
            return 1/x;
        }
        
        double ans = 1.0;
        boolean isEnv = false;
        if(n<0){
            isEnv = true;
        }
            
        while(n!=0){
        
             if(n%2==1 || n%2==-1){
                ans = ans*x;
            }
            
            x = (x*x);
            
            n = n/2;
        }
        
        if(isEnv){
            ans = 1/ans;
        }

        
        return ans;
    }
}