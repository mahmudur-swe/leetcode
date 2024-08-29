class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];



        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
                // if(i==1 && j==1){
                //     if(obstacleGrid[0][0]==1){
                //         dp[1][1] = 0;
                //     }else{
                //         dp[1][1] = 1;
                //     }
                    
                // }else{
                //     if(obstacleGrid[i-1][j-1] == 1){
                //         dp[i][j] = 0;
                //     }else{
                //         dp[i][j] += dp[i-1][j];
                //         dp[i][j] += dp[i][j-1];
                //     }
                // }
            }
        }

        return totalPath(obstacleGrid,dp,0,0);



    }

    public int totalPath(int[][] obstacleGrid,int[][] dp,int i,int j){

        if(i==obstacleGrid.length){
            return 0;
        }

        if(j== obstacleGrid[0].length){
            return 0;
        }

         if(obstacleGrid[i][j] == 1){
            return 0;
        }

        if(i==obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            return 1;
        }

       

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int leftSum = totalPath(obstacleGrid,dp,i+1,j);
        int rightSum = totalPath(obstacleGrid,dp,i,j+1);


        return dp[i][j] = leftSum+rightSum;

    }


}