class Solution {
    public int jump(int[] nums) {
        
        if(nums.length==1){
            return 0;
        }
        
        int jump = 0;
        int maxPos = 1;
        int prePos = 1;
        
        for(int i=1;i<=nums.length;i++){
            
            
            maxPos = Math.max(maxPos,i+nums[i-1]);
            
            if(prePos == i){
                prePos = maxPos;
                jump++;
            }
            
            
            if(prePos >= nums.length){
                return jump;
            }
            else if(maxPos>=nums.length){
                return jump+1;
            }
        }
        
        return jump;
        
    }
}