class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] sum = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int val = matrix[i-1][j-1] == '1'? 1:0;
                
                sum[i][j] = val + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
                
                //System.out.println(i+ " " + j + " "+ sum[i][j]);
                
            }
        }
        
        int ans = 0;
        
        for(int i=1;i<=m;i++){
            
            for(int j=1;j<=n;j++){
               
                int x = i;
                int y = j;
                
                while(x<=m && y<=n){
                    
                    int square = sum[x][y] - sum[i-1][y] - sum[x][j-1] + sum[i-1][j-1];
                    
                    int l = x-i+1;
                    int h = y-j+1;
                    
                    // System.out.println(i + " " + j + " " + x + " "+ y + " " + square);
                    // System.out.println(sum[x][y]+" " + sum[i][y] + " " + sum[x][j] + " "+sum[i-1][j-1]);
                    
                    if(l*h == square){
                        ans = Math.max(ans,square);
                    }else{
                        break;
                    }
                    
                    x++;
                    y++;
                    
                }
                
                
            }
        }
        return ans;
    }
}