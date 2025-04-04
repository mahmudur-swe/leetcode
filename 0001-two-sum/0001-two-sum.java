class Solution {
    public int[] twoSum(int[] nums, int target) {

        // loop from index i to length-1 of n
        // nested loop from j = index+1 to length
        // if nums[i] + nums[j] = sum 
        // return i, j
        // time c: O(n^2) // space: O(1)

        // sorted array. 
        // loop from i = 0 to lenght
        // then binary search from (i + 1 to length)
        // return ans
        // time complexrity: nlog(n)
        // space complexrity: o(n)

        // map[num] = index
        // 3 target - 3 = map[commpe] = index. 
        // loop gtom i = 0 to n
        // index and co
        // time comple = O(n)
        // space com = O(n)


        int length = nums.length;

        Map<Integer,Integer> map = new HashMap();

        for(int i=0;i<length;i++){
            
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }

            map.put(nums[i],i);


        }


        return new int[]{};
        
    }
}