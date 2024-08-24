class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int res = 1;
        int i = 1;
        while(n/5>=1)
        
        {
            
            ans += n/5;
            
            n = n/5;

        }

    

        return ans;
    }
}