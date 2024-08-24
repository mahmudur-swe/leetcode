class Solution {

    int[][] dp;

    public int coinChange(int[] coins, int amount) {


        if(amount ==0 ){
            return 0;
        }

        dp = new int[amount+1][coins.length];

        for(int i=0;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                dp[i][j] = -1;
            }
            
        }

        int val = change(coins,amount,0);

        if(val == Integer.MAX_VALUE){
            return -1;
        }

        return val;
    }


    private int change(int[] coins, int amount,int pos){
        
        if(amount == 0){
            return 0;
        }

        if(pos == coins.length){
            return  Integer.MAX_VALUE;
        }


        if(dp[amount][pos]!=-1){
            return dp[amount][pos];
        }

        int withOut = change(coins,amount,pos+1);

        int with = Integer.MAX_VALUE;


        if(amount-coins[pos]>=0){

            int val = change(coins,amount-coins[pos],pos);;

            if(val != Integer.MAX_VALUE){
                with = 1 + val;
            }

        }

        dp[amount][pos] = Math.min(withOut,with);

        return dp[amount][pos];
        

    }
}