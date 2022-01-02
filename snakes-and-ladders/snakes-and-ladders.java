class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int[][] dp = new int[board.length+1][board.length+1];
        int[][] dp1 = new int[board.length+1][board.length+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j] = 100000;
                dp1[i][j] = 100000;
                
            }
        }
        
        dp[board.length-1][0] = 0;
        dp1[board.length-1][0] = 0;
        
        int x = 1;
          for(int i=1;i<=board.length*board.length-1;i++){
              
                int[] cur = getPos(board.length,i);
              
               if(board[cur[0]][cur[1]]!=-1){
                   
                   if(i>board[cur[0]][cur[1]]){
                       x++;
                   }
                   
               }
              
              
          }
        
        
        
        while(x>=0){
            
            x--;
            
            for(int i=1;i<=board.length*board.length-1;i++){
            
            int[] cur = getPos(board.length,i);
            
            //if(board[cur[0]][cur[1]]!=-1 && dp[cur[0]][cur[1]]<=board.length * board.length){
            // //     int[] nxt =  getPos(board.length,board[cur[0]][cur[1]]);
            // //     dp[nxt[0]][nxt[1]] = Math.min(dp[nxt[0]][nxt[1]],dp[cur[0]][cur[1]]); 
            //      continue;
            //}
            
            //System.out.println("cur " + i +" " + cur[0] +" " + cur[1] + " "+dp[cur[0]][cur[1]]);
            
            for(int j=i+1;j<=i+6 && j<=board.length*board.length;j++){
                
                int[] next = getPos(board.length,j);
                
                //dp[next[0]][next[1]] = Math.min(dp[next[0]][next[1]],1+dp[cur[0]][cur[1]]);
                
                if(board[next[0]][next[1]]!=-1){
                    
                    int[] nxt =  getPos(board.length,board[next[0]][next[1]]);
                    
                   // dp1[nxt[0]][nxt[1]] = Math.min(dp1[nxt[0]][nxt[1]],dp[cur[0]][cur[1]]);
                    
                    if(board[cur[0]][cur[1]]==-1){
                        dp1[nxt[0]][nxt[1]] = Math.min(Math.min(Math.min(dp1[nxt[0]][nxt[1]],1+dp[cur[0]][cur[1]]),dp[next[0]][next[1]]),1+dp1[cur[0]][cur[1]]);
                        
                    }else{
                        dp1[nxt[0]][nxt[1]] = Math.min(Math.min(dp1[nxt[0]][nxt[1]],1+dp1[cur[0]][cur[1]]),dp[next[0]][next[1]]);
                    }
                    
                   
                    
                }else{
                    
                     if(board[cur[0]][cur[1]] == -1){
                        dp[next[0]][next[1]] = Math.min(Math.min(dp[next[0]][next[1]],1+dp[cur[0]][cur[1]]),1+dp1[cur[0]][cur[1]]);
                    }else{
                         dp[next[0]][next[1]] = Math.min(dp[next[0]][next[1]],1+dp1[cur[0]][cur[1]]);
                    }
                    
                    
                    
                }
                
                //System.out.println("next " + j +" " + next[0] +" " + next[1] + " "+dp[next[0]][next[1]]);
                
                //System.out.println()
                
            }
        }
        }
        
  
        
        int ans = -1;
        
        if(board.length%2==0){
            ans = Math.min(dp[0][0],dp1[0][0]);
        }else{
            ans = Math.min(dp[0][board.length-1],dp1[0][board.length-1]);
        }
        
        if(ans>board.length * board.length){
            return -1;
        }
        
        return ans;
      
    }
    
    
    private int[] getPos(int n,int cur){
   
        int i = (n - (cur-1)/n)-1;
        
        int j = cur%n;
        
        if(n%2==0){
            if(i%2 == 1){
                j = (cur-1)%n;
            }else{
                j = n - (cur-1)%n-1;
            }
        }else{
            if(i%2==0){
                j = (cur-1)%n;
            }else{
                j = n - (cur-1)%n-1;
            }
        }
        return new int[]{i,j};
    }
    
    
    
    
}