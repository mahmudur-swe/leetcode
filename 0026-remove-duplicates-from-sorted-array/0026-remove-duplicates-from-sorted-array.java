class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length <=1){
            return nums.length;
        }

        int k = 1;
        int val = nums[0];


        for(int i=1;i<nums.length;i++){

            if(val != nums[i]){
                nums[k++] = nums[i];
                val = nums[i];
              
            }

        

        }


        return k;
    }
}