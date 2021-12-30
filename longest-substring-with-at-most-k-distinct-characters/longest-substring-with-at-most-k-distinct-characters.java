class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()<=k){
            return s.length();
        }
        
        int ans = k;
        
        
        Map<Character,Integer> window = new HashMap();
        
        int l = 0;
        int r = 0;
        
        while(r<s.length()){
            
            
            window.put(s.charAt(r),r++);
            
            if(window.size() == k+1){
                
                int id = Collections.min(window.values());
                window.remove(s.charAt(id));
                l = id+1;
                
            }
            
            ans = Math.max(ans,r-l);
            
        }
        return ans;
        
    }
}