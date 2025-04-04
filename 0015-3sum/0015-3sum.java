class Solution {

    boolean[][] dp;

    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        dp = new boolean[length][length];
        
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList();

        getAns(nums,0,length-1,ans);

        return ans;

    }

    void getAns(int[] nums, int start, int end, List<List<Integer>> ans){

        if(end-start<=1){
            return;
        }

        if(dp[start][end]){
            return;
        }
        
        int sum = nums[start] + nums[end];

        int index = Arrays.binarySearch(nums, start+1, end, sum*-1);

        if(index>=0){
            List<Integer> result = new ArrayList();
            result.add(nums[start]);
            result.add(nums[end]);
            result.add(nums[index]);
            ans.add(result);
        }

        dp[start][end] = true;

        int st = start+1;

        while(nums[st] == nums[st-1] && st<end){
            st++;
        }

        getAns(nums, st,end,ans);

        int en = end - 1;

        while(nums[en] == nums[en+1] && start<en){
            en--;
        }

    
        getAns(nums, start,en,ans);

      


    }





}