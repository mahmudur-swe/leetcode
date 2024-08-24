class Solution {

    int[][] dp;
    public int rob(int[] nums) {

        dp = new int[nums.length][2];


        for(int i=0;i<nums.length;i++){
            dp[i][0] = dp[i][1] = -1;
        }

        return rob(nums,0,1);
        
    }

    public int rob(int[] nums,int pos,int with) {

        if(pos==nums.length){
            return 0;
        }

        if(dp[pos][with]!=-1){
            return dp[pos][with];
        }

        int ans = rob(nums,pos+1,1);

        if(with==1){
            int ans1 = nums[pos] + rob(nums,pos+1,0);
        

            ans = Math.max(ans,ans1);

        }else{
            int ans3 = rob(nums,pos+1,0);
         

            ans = Math.max(ans,ans3);
        }

        return dp[pos][with] = ans;


        
    }
}