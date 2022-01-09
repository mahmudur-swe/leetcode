class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }
        
        int index = 0;
        int value = nums[0];
        
        for(int i=1;i<nums.length;++i){
            
            if(value!=nums[i]){
                nums[++index] = nums[i];
                value = nums[i];
            }
            
        }
        
        return index+1;
        
    }
}