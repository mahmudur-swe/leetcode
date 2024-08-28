class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int [m+1][n+1];

        // for(int i=1;i<m;i++){
        //     matrix[i][0] += matrix[i-1][0]; 
        // }

        // for(int i=1;i<n;i++){
        //     matrix[0][i] += matrix[0][i-1]; 
        // }

        int ans = 0;

        for(int i=1;i<=m;i++){

            for(int j = 1; j<=n; j++){
                
                if(matrix[i-1][j-1] == '0'){
                    sum[i][j] = 0;
                }else{
                    sum[i][j] = 1;
                }
                
                sum[i][j] += (sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] );

               // System.out.printf("%d %d: %d\n",i,j,sum[i][j]);
                
            }
        }

        for(int i=0;i<=m;i++){
            for(int j = 0; j<=n;j++){

                 int k = i+1;
                 int l = j+1;

                 
                 while(k<=m && l<=n){

                    int squareValue = (sum[k][l] - sum[i][l] - sum[k][j] + sum[i][j]);

                    int sumValue = (k-i)*(k-i);

                    //System.out.printf("%d %d: %d %d %d, %d\n",i,j,k,l,squareValue,sumValue);

                    if(squareValue == sumValue){
                        ans = Math.max(ans,squareValue);
                    }else{
                        break;
                    }
                    
                    k++;
                    l++;

                 }

            }
        }



        return ans;
        
    }
}