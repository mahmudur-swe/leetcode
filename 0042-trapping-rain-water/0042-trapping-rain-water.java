class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;
        int left = 0;
        int right = 0;

        int sum = 0;

        while(i<j){
            
            left = Math.max(left,height[i]);
            right = Math.max(right,height[j]);

            

            if(left<=right){
                sum += left - height[i];
                i++;
                
            }else {
                sum += right - height[j];
                j--;
            }

        }

        return sum;
    }
}