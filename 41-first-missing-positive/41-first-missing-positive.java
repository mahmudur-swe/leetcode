class Solution {
    
    public int firstMissingPositive(int[] nums) {
        
        int i=0;
        
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i] = -1;
                continue;
            }
            
            if(nums[i] == i+1){
                continue;
            }
            
            int j = nums[i]-1;
            nums[i] = -1;
     
            while(true){
                
                if(j<0 || j>=nums.length || nums[j] == j+1){
                    break;
                }
                
                
                int tmp = nums[j];
                
                nums[j] = j+1;
                
                j = tmp - 1;
                
                
            }
        }
        
        for(i=0;i<nums.length;i++){
            if(nums[i] == -1){
                return i+1;
            }
            //System.out.println(nums[i]);
        }
        
        return nums.length+1;
        
        
    }
}