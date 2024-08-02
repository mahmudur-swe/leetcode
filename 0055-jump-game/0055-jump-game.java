class Solution {
    public boolean canJump(int[] nums) {
        


        int maxReachPos = 0;

        for(int i = 0;i<nums.length-1;i++){

            
        
            maxReachPos = Math.max(maxReachPos,i+nums[i]);

            if(maxReachPos>=nums.length-1){
                break;
            }

            if(maxReachPos<=i){
                break;
            }


        }

        return maxReachPos>=nums.length-1;


    }



}