class Solution {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        
        if(k==0 || nums.length==1){
            return;
        }

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums,int l, int r){
        while(l<r){
            swap(nums,l++,r--);
        }
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}

