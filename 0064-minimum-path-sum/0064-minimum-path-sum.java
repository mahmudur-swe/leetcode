class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            sum[i][0] = Integer.MAX_VALUE;
        }
        for(int i=0;i<=n;i++){
            sum[0][i] = Integer.MAX_VALUE;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1){
                    sum[i][j] = grid[i-1][j-1];
                }else{
                    sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i-1][j-1];
                }
           
            }
        }
        
        return sum[m][n];
        
        
    }
}