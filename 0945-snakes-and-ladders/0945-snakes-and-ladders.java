class Solution {
    
    private static final int INF = 1_000_000_000;
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] minDist = new int[n * n];
        int[] boardOneDim = new int[n * n];
        
        boolean goRight = true;
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (goRight) {
                for (int j = 0; j < n; j++) {
                    minDist[k] = INF;
                    boardOneDim[k] = board[i][j];
                    k++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    minDist[k] = INF;
                    boardOneDim[k] = board[i][j];
                    k++;
                }
            }
            goRight = !goRight;
        }
        
        minDist[0] = 0;
        dfs(minDist, boardOneDim, 0, n * n);
        
        return minDist[n * n - 1] == INF ? -1 : minDist[n * n - 1];
    }
    
    private void dfs(int[] minDist, int[] boardOneDim, int current, int n) {
        if (minDist[current] == INF) {
            return;
        }
        for (int j = current + 1; j < Math.min(n, current + 6 + 1); j++) {
            if (boardOneDim[j] == -1) {
                if (minDist[j] > minDist[current] + 1) {
                    minDist[j] = minDist[current] + 1;
                    dfs(minDist, boardOneDim, j, n);
                }
            } else {
                if (minDist[boardOneDim[j] - 1] > minDist[current] + 1) {
                    minDist[boardOneDim[j] - 1] = minDist[current] + 1;
                    dfs(minDist, boardOneDim, boardOneDim[j] - 1, n);
                }                
             
            }
        }        
    }
    
}