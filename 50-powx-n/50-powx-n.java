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
        double next = 1.0*Math.abs(x);
        
        boolean isPos = true;
        boolean isEnv = false;
        
        if(n<0){
            isEnv = true;
        }
        
        if(x<0 && n%2==0){
            isPos = true;
        }
        
        //System.out.println(-13%2);
        
        if(x<0 && (n%2==1 || n%2==-1)){
            isPos = false;
        }
        
        // if(n==Integer.MIN_VALUE){
        //     n = n/2;
        //     next = next*next;
        // }
        
        //n = Math.abs(n);
        
        while(n!=0){
        
             if(n%2==1 || n%2==-1){
                ans = ans*next;
            }
            
            next = (next*next);
            
            n = n/2;
        }
        
        if(isEnv){
            ans = 1/ans;
        }
        
        if(!isPos){
            ans = -ans;
        }
        
        
        return ans;
    }
}