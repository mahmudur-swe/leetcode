class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        
        int first = s.charAt(0)-'A';
        int second = -1;
        
        int firstPos = 0;
        int secPos = -1;
    
        
        int ans = 0;
        
        int start = 0;
        
        for(int i=1;i<s.length();i++){
            
            if(first!=s.charAt(i)-'A'){
                second = s.charAt(i)-'A';
                secPos = i;
                break;
            }
            
        }
        if(secPos==-1){
            return s.length();
        }
        
        
        ans = Math.max(ans,secPos-firstPos+1);
        
        for(int i=secPos+1;i<s.length();i++){
            
            int c = s.charAt(i)-'A';
            
            if(c == second){
                
            }else if(c == first){
                
                first = second;
                
                firstPos = secPos;
                
                second = c;
                
                secPos = i;
                
                
            }else{
                
                start = secPos;
                
                first = second;
                
                firstPos = secPos;
                
                second = c;
                
                secPos = i;
                
            }
            
            ans = Math.max(ans,i-start+1);
            
        }
        
        return ans;
        
    }
}