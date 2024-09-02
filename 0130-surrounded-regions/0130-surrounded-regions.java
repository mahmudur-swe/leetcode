class Solution {
    int m;
    int n;
    

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;


        for(int j=0;j<n;j++){
            if(board[0][j] == 'O'){
                connect(board,0,j);
            }
            if(board[m-1][j] == 'O' ){
                connect(board,m-1,j);
            }
        }


        for(int i=0;i<m;i++){
            if(board[i][0] == 'O' ){
                connect(board,i,0);
            }
             if(board[i][n-1] == 'O' ){
                connect(board,i,n-1);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }

            }
        }

       

        
    }

    private void connect(char[][] board, int i,int j){

        if(i<0 || i == m || j<0 || j== n){
            return;
        }

        if(board[i][j] == 'X'){
            return;
        }


         if(board[i][j] == '#'){
            return;
        }

        board[i][j] = '#';


        connect(board,i+1,j);
        connect(board,i-1,j);
        connect(board,i,j+1);
        connect(board,i,j-1);

    }
}