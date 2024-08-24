class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

           for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = 200*n*m+1;
            }
        }


        visited[0][0] = grid[0][0];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i+1<m){
                    visited[i+1][j] = Math.min(grid[i+1][j]+visited[i][j],visited[i+1][j]);
                }
                if(j+1<n){
                    visited[i][j+1] = Math.min(grid[i][j+1]+visited[i][j],visited[i][j+1]);
                }
            }
        }

        return visited[m-1][n-1];



        
    }
}