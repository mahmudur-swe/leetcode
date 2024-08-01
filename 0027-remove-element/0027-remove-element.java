class Solution {
    public int removeElement(int[] nums, int val) {
        
        int length = nums.length;
        int k =0;

        for(int i=0;i<length;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;

    }
}