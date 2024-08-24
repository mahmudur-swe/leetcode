class Solution {

    int[] dp;

    public int coinChange(int[] coins, int amount) {


        if(amount ==0 ){
            return 0;
        }

        dp = new int[amount+1];



        for(int i=0;i<=amount;i++){
             dp[i] = amount+1;
        }

        dp[0] = 0;

        for(int j=0;j<coins.length;j++){
            if(coins[j]<=amount){
                dp[coins[j]] = 1;
            } 
        }

        for(int i=0;i<=amount;i++){

            for(int j=0;j<coins.length;j++){

                int val = i - coins[j];

                if(val >= 0){

                    dp[i] = Math.min(dp[i],  1 + dp[val]);
                }

            }
            

        }


       // int val = change(coins,amount,0);


        if(dp[amount] > amount){
            return -1;
        }

        
        return dp[amount];
    }


    /*private int change(int[] coins, int amount,int pos){
        
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

        

        return dp[amount][pos] = Math.min(withOut,with);
        

    }*/
}