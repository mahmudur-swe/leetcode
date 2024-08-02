class Solution {
    public boolean canJump(int[] nums) {
        


        int maxReachPos = 0;

        for(int i = 0;i<nums.length-1;i++){

            if(maxReachPos>=nums.length-1){
                break;
            }

            if(nums[i] == 0 && maxReachPos<=i){
                break;
            }

        
            maxReachPos = Math.max(maxReachPos,i+nums[i]);

            

        }

        return maxReachPos>=nums.length-1;


    }



}