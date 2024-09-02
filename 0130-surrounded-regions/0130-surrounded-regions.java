class Solution {
    int m;
    int n;
    
    boolean[][] visited;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        for(int j=0;j<n;j++){
            if(board[0][j] == 'O' && !visited[0][j]){
                connect(board,0,j);
            }
            if(board[m-1][j] == 'O' && !visited[m-1][j]){
                connect(board,m-1,j);
            }
        }

       

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O' && !visited[i][0]){
                connect(board,i,0);
            }
             if(board[i][n-1] == 'O' && !visited[i][n-1]){
                connect(board,i,n-1);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(!visited[i][j]){
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

        if(visited[i][j]){
            return;
        }

        visited[i][j] = true;


        connect(board,i+1,j);
        connect(board,i-1,j);
        connect(board,i,j+1);
        connect(board,i,j-1);

    }
}