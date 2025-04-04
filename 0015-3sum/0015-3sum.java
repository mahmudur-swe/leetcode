class Solution {

    // i = 0 to n-2
    // j = i+1 to n - 1
    // k = j + 1 to n-2
    // i + j + k = 0
    // -4 -1 -1 0 1 2
    //  

    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        int length = nums.length;

        int firstPos = 0;

        for(int i=0;i<length;i++){
            if(nums[i]>=0){
                firstPos = i;
                break;
            }
        }

        List<List<Integer>> ans = new ArrayList();

        for(int i=0;i<length-2;i++){

            if(nums[i]>0){
                break;
            }

            if(i>0){
                if(nums[i] == nums[i-1]){
                    continue;
                }
            }

            int lastSum = 1;

            for(int j=i+1;j<length-1;j++){

                int sum = nums[i] + nums[j];

                if(nums[j] == nums[j-1] && sum == lastSum ){
                    continue;
                }

                lastSum = sum;

                if(sum <=0){

                    int index = Arrays.binarySearch(nums, Math.max(firstPos,j+1), length, -1*sum);

                    if(index>=0){
                        
                        List<Integer> result = new ArrayList();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[index]);

                        ans.add(result);
                        
                    }
                }

                


            }



        }

        return ans;


    }
}