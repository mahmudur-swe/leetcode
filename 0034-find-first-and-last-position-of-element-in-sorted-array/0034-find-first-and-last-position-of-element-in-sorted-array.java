class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];

        ans[0] = lowerBound(nums,target,0,nums.length-1);
        if(ans[0]==-1){
            ans[1] = -1;
        }else{
            ans[1] = upperBoundBound(nums,target,ans[0],nums.length-1);
        }

        return ans;

    }

    private int lowerBound(int[] nums, int target,int start,int end){

        int pos = -1;

        int mid = (start+end)/2;

        while(start<=end){

            mid = (start+end)/2;

            if(nums[mid] == target){
                pos = mid;
                end = mid-1;
            }else if(nums[mid] > target ){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }

        return pos;

    }

    private int upperBoundBound(int[] nums, int target,int start,int end){

        int pos = -1;

        int mid = (start+end)/2;

        while(start<=end){

            mid = (start+end)/2;

            if(nums[mid] == target){
                pos = mid;
                start = mid+1;
            }else if(nums[mid] > target ){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }

        return pos;

    }
}