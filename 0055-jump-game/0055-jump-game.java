class Solution {
    public boolean canJump(int[] nums) {
        
        
        if(nums.length == 1){
            return true;
        }

        int maxReachPos = 0;

        for(int i = 0;i<nums.length-1;i++){

            
        
            maxReachPos = Math.max(maxReachPos,i+nums[i]);

            if(maxReachPos>=nums.length-1){
                return true;
            }

            if(maxReachPos<=i){
                return false;
            }


        }

        return false;


    }



}