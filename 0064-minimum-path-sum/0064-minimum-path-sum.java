class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
             visited[i][0] = 200*n*m+1;
        }

        for(int j=0;j<=n;j++){
            visited[0][j] = 200*n*m+1;
        }


        visited[1][0] = 0;
        visited[0][1] = 0;

        visited[1][1] = 200*n*m+1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                visited[i][j] = Math.min(grid[i-1][j-1]+visited[i-1][j],grid[i-1][j-1]+visited[i][j-1]);
                //visited[i][j] = Math.min(grid[i-1][j-1]+visited[i][j-1],visited[i][j]);

            }
        }

        return visited[m][n];



        
    }
}