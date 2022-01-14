class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] row = new boolean[9][9];
        
        boolean[][] col = new boolean[9][9];
        
        boolean[][] box = new boolean[9][9];
        
        for(int i=0;i<9;i++){
            
            for(int j=0;j<9;j++){
                
                if(board[i][j]!='.'){
                    
                    int val = board[i][j]-'0'-1;
                    if(row[val][i]){
                        return false;
                    }
                    if(col[val][j]){
                        return false;
                    }
                    int b = getBoxIndex(i,j);
                    if(box[val][b]){
                        return false;
                    }
                    row[val][i] = true;
                    
                    col[val][j] = true;
                    
                    box[val][b] = true;
                    
                }
                
            }
            
        }
        
        return true;
        
    }
    
    private int getBoxIndex(int r,int c){
        
        return (r / 3) * 3 + c / 3;
        
    }
}