class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        
        int n = nums.length;
        
        forward[0] = nums[0];
        
        backward[n-1] = nums[n-1];
        
        
        for(int i=1;i<n;i++){
            
            forward[i] = nums[i]*forward[i-1];
            
            backward[n-i-1] = nums[n-i-1]*backward[n-i];
            
            //System.out.println("F=> "+ (i+1)+" "+forward[i]);
            
            //System.out.println("B=> "+ (n-i)+" "+backward[n-i-1]);
        }
        
        int[] ans = new int[n];
        
        ans[0] = backward[1];
        ans[n-1] = forward[n-2];
        
        for(int i=1;i<n-1;i++){
            
            ans[i] = forward[i-1]*backward[i+1];
            
        }
        return ans;
    }
}