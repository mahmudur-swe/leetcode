class Solution {

    int[][][] dp;
    boolean[][][] visited;
    public int maxProfit(int[] prices) {
        int transactionCount = 0;

        dp = new int[prices.length+1][4][2];
      

         for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return maxPro(prices,0,0,0);
    }

    public int maxPro(int[] prices,int pos,int buy,int transactionCount){

        if(pos==prices.length || transactionCount==4){
            return 0;
        }

        if(dp[pos][transactionCount][buy]!=-1){
            return dp[pos][transactionCount][buy];
        }
        
        int ans = 0;

        int maxVal = maxPro(prices,pos+1,buy,transactionCount);

        if(buy==1){

            ans = prices[pos] + maxPro(prices,pos+1, 0,transactionCount+1);

        
        }else{
            ans = maxPro(prices,pos+1,1,transactionCount+1) - prices[pos];

        }

        ans = Math.max(ans,maxVal);


       // visited[pos][transactionCount][buy] = true;

        return dp[pos][transactionCount][buy] = ans;


    }
}