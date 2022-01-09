class Solution {
    public int maxArea(int[] height) {
        int ans =0;
        int l =0;
        int r = height.length-1;
        
        while(l<r){
            
            if(height[l]<height[r]){
                ans = Math.max(ans,(r-l)*height[l++]);
         
            }else{
                ans = Math.max(ans,(r-l)*height[r--]);
            }
            
        }
        
        return ans;
        
    }
}