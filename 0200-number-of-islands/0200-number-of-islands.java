class Solution {


    int n;
    int m;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    markasVisited(grid,i,j);
                }
            }
        }
        return ans;
        

        
    }

    private void markasVisited(char[][] grid,int i,int j) {

        if(i<0 || i>=m || j<0 || j>=n){
            return;
        }

        if(grid[i][j] != '1'){
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '2';
        }

        markasVisited(grid,i+1,j);
        markasVisited(grid,i-1,j);
        markasVisited(grid,i,j+1);
        markasVisited(grid,i,j-1);
        
        
    }
}