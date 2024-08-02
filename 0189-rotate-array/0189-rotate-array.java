class Solution {
    public void rotate(int[] nums, int k) {


    int length = nums.length;

    int start = 0;

     while(true){

        if(length <= 1){
            return;
        }
        
        k = k % length;

        if(k==0){
            return;
        }
  

        int tmp;

        for(int i=start;i<(nums.length - k) ; i=i+k){

            int j = nums.length - k;
            
            if(i+k>nums.length){
                break;
            }
            
            for(int v=0; v < k;v++){
                tmp = nums[i+v];
                nums[i+v] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }

       // if(nums.length % 2==0 || k % 2 == 0){
         //   return;
        //}
   
        int newlength = length % k;

        start = start + (length - newlength);
        length = newlength;
        

    }
    }
}