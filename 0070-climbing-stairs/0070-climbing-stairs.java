class Solution {

    int ans = 0;

    int[] dp;

    
    public int climbStairs(int n) {
        
        dp = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }

        climbStair(n);

        return dp[n];
    }

    public int climbStair(int n) {

        if(n<0){
            return 0;
        }

        if(n==0){
            ans++;
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int sum = 0;

        if(n-1>=0){
            sum += climbStair(n-1);
        }

        
        if(n-2>=0){
            sum += climbStair(n-2);
        }

        dp[n] = sum;

        return dp[n];

       

    }


    
}