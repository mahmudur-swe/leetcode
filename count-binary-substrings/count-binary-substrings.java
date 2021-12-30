class Solution {
    public int countBinarySubstrings(String s) {
        int count0 = 0;
        int count1 = 0;
        char lastChar = s.charAt(0);
        if(lastChar == '0'){
            count0 = 1;
        }else{
            count1 = 1;
        }
        
        int ans = 0;
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) == lastChar){
                if(s.charAt(i) == '0'){
                    ++count0;
                  
                      if(count0>count1){
                        count1 = 0;
                    }
                }else{
                    ++count1;
                      if(count0<count1){
                        count0 = 0;
                    }
                }
            }else{
                if(lastChar == '0'){
                    count1 = 1;
                }else{
                    count0 = 1;
                }
            }
            
            lastChar = s.charAt(i);
             
            if(Math.min(count0,count1)>0){
                ans++;
             }
        }
        return ans;
       
    }
}