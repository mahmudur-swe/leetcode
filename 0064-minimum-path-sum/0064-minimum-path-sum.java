class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] sum = new int[grid.length+1][grid[0].length+1];
        
        Arrays.stream(sum).forEach(a -> Arrays.fill(a,-1));
        
        return getAns(grid,0,0,sum);
    }
    
    public int getAns(int[][] grid,int x,int y,int[][] sum){
        
        if(x>=grid.length){
            return Integer.MAX_VALUE;
        }
        
        if(y>=grid[0].length){
            return Integer.MAX_VALUE;
        }
           
        if(sum[x][y]!=-1){
            return sum[x][y];
        }
        
        if(x == grid.length-1 && y==grid[0].length-1){
            return grid[x][y];
        }
        
        int ans1 = getAns(grid,x+1,y,sum);
        int ans2 = getAns(grid,x,y+1,sum);
           
        return sum[x][y] = grid[x][y] + Math.min(ans1,ans2);
        
    }
}