class Solution {
    public void rotate(int[] nums, int k) {

        int length = nums.length;

        int numsLength = nums.length;

        int start = 0;

        while (true) {

            if (length <= 1) {
                return;
            }

            k = k % length;

            if (k == 0) {
                return;
            }

            int limit = (numsLength - k);
        
            for (int i = start; i < limit; i += k) {

                int j = limit;

                for (int v = 0; v < k; v++) {
                    int tmp = nums[i + v];
                    nums[i + v] = nums[j];
                    nums[j++] = tmp;
                }
            }

            int newlength = length % k;

            start += (length - newlength);

            length = newlength;

        }
    }
}