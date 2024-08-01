class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length <= 2){
            return nums.length;
        }

        int val = nums[0];
        int k = 1;
        int count = 1;

        for(int i=1;i<nums.length;i++){

            if(val != nums[i]){
                nums[k++] = nums[i];
                val = nums[i];
                count = 1;
            }else if(count == 1){
                    count++;
                    nums[k++] = nums[i];
            }

        }

        return k;



    }
}