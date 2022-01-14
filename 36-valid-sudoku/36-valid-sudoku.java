class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int[][] row = new int[10][10];
        
        int[][] col = new int[10][10];
        
        int[][] box = new int[10][10];
        
        for(int i=0;i<9;i++){
            
            for(int j=0;j<9;j++){
                
                if(board[i][j]!='.'){
                    
                    int val = board[i][j]-'0';
                    if(row[val][i]!=0){
                        return false;
                    }
                    if(col[val][j]!=0){
                        return false;
                    }
                    int b = getBoxIndex(i,j);
                    if(box[val][b]!=0){
                        return false;
                    }
                    row[val][i] = 1;
                    
                    col[val][j] = 1;
                    
                    box[val][b] = 1;
                    
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