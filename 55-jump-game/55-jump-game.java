class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums.length==1){
            return true;
        }
        
        if(nums[0]==0){
            return false;
        }
        
        if(nums[0]>=nums.length-1){
            return true;
        }
        
        int maxPos = 0;
        
        for(int i=0;i<nums.length;i++){
            
            maxPos = Math.max(maxPos,i+nums[i]);
            
            if(maxPos>=nums.length-1){
                return true;
            }
            
            if(maxPos<=i){
                return false;
            }
            
        }
        
        return false;
    }
}