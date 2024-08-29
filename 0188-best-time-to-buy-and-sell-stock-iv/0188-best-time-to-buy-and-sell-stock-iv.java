class Solution {

    int total = 0;
    int[][][] dp;

    
    public int maxProfit(int k, int[] prices) {

        dp = new int[prices.length][k*2][2];

        total = k*2;
    

         for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int l = 0; l < dp[i][j].length; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        return maxPro(prices,0,0,0);
        
    }

    public int maxPro(int[] prices,int pos,int buy,int transactionCount){

        if(pos==prices.length || transactionCount==total){
            return 0;
        }

        if(dp[pos][transactionCount][buy]!=-1){
            return dp[pos][transactionCount][buy];
        }
        

        int maxVal = maxPro(prices,pos+1,buy,transactionCount);

        if(buy==1){
     
            return dp[pos][transactionCount][buy] = Math.max(prices[pos] + maxPro(prices,pos+1, 0,transactionCount+1),maxVal);
        }else{
      
            return dp[pos][transactionCount][buy] = Math.max( maxPro(prices,pos+1,1,transactionCount+1) - prices[pos],maxVal);
        }

    
        


    }
}