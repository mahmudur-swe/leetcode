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
    
    private int getBoxIndex(int i,int j){
        
        if(j<3){
            
            if(i<3){
                return 0;
            }else if(i<6){
                return 3;
            }else if(i<9){
                return 6;
            }
            
        }else if(j<6){
            
            if(i<3){
                return 1;
            }else if(i<6){
                return 4;
            }else if(i<9){
                return 7;
            }
            
        }else if(j<9){
            
            if(i<3){
                return 2;
            }else if(i<6){
                return 5;
            }else if(i<9){
                return 8;
            }
            
        }
        
        return 0;
    }
}