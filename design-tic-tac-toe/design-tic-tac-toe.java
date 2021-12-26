class TicTacToe {

    int[] rowValue;
    int[] colValue;
    int[] diagonalValue;
    
    int n;
    
    // int[] rowCount;
    // int[] colCount;
    // int[] diagonalCount;
    
    
    public TicTacToe(int n) {
        rowValue = new int[n];
        colValue = new int[n];
        diagonalValue = new int[2];
        this.n = n;
        
        // rowCount = new int[n];
        // colCount = new int[n];
        // diagonalCount = new int[2];
    }
    
    public int move(int row, int col, int player) {
        
        if(player==1){
            rowValue[row] += 1;
            colValue[col] += 1;
            if(row ==  col){
                diagonalValue[0]+=1;
            }
            if(row+col == n-1){
                diagonalValue[1] +=1;
            }
            if(rowValue[row] == n || colValue[col]==n ||  diagonalValue[0]==n ||  diagonalValue[1] == n){
                return 1;
            }
        }else{
            rowValue[row] -= 1;
            colValue[col] -= 1;
            if(row ==  col){
                diagonalValue[0] -= 1;
            }
            if(row+col == n-1){
                diagonalValue[1] -=1;
            }
            if(rowValue[row] == -1*n || colValue[col]== -1*n ||  diagonalValue[0]== -1*n ||  diagonalValue[1] == -1*n){
                return 2;
            }
        }
        
      
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */