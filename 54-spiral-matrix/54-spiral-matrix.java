class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        
        int i= 0;
        int j = 0;
        
        List<Integer> ans = new ArrayList();
        
        ans.add(matrix[0][0]);
        int tmp = -1000;
        matrix[0][0] = tmp;
        
        while(true){
            
            if(dir==0){
                if(j+1 == matrix[0].length || matrix[i][j+1] == tmp){
                    dir = (dir+1)%4;
                    i++;
                }else{
                    j++;
                }
            }else if(dir==1){
                if(i+1 == matrix.length || matrix[i+1][j] == tmp){
                    dir = (dir+1)%4;
                    j--;
                }else{
                    i++;
                }
            }else if(dir==2){
                if(j-1 == -1 || matrix[i][j-1] == tmp){
                    dir = (dir+1)%4;
                    i--;
                }else{
                    j--;
                }
            }else if(dir==3){
                if(i-1 == -1 || matrix[i-1][j] == tmp){
                    dir = (dir+1)%4;
                    j++;
                }else{
                    i--;
                }
            }
            
            if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]==tmp){
                break;
            }
            
            ans.add(matrix[i][j]);
            
            matrix[i][j] = tmp;
            
            
        }
        
        return ans;
    }
}