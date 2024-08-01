class Solution {
    public int majorityElement(int[] nums) {

        int val = nums[0];
        int fre = 0;

        for(int num:nums){
            
            if(val == num){
                fre++;
            }else{
                fre--;
            }

            if(fre == 0){
                val = num;
                fre = 1;
            }


        }

        return val;

    }
}