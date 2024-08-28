class Solution {
    public int findMin(int[] nums) {
        int ans =0;
        int n = nums.length;
        if(nums[n-1]>nums[0]){
            return nums[0];
        }

        int start = 0;
        int end = n-1;
        int mid = (start+end)/2;

        int startValue = nums[0];
        int endValue = nums[n-1];

        while(start<end){

            mid = (start+end)/2;

            if(nums[mid] > endValue ){
                start = mid+1;
                startValue = nums[mid];
            }else if(nums[mid] <= startValue ){
                end = mid;
                endValue = nums[mid];
            }else{
                start = mid;
            }
        }



        return nums[start];
    }
}