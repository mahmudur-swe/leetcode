class Solution {
    
    
    
    public String countAndSay(int n) {
        
        String s = "1";
        
        for(int i=1;i<n;i++){
            StringBuilder tmp = new StringBuilder();
            //System.out.println(s);
            int cnt = 1;
            
            for(int j=0;j<s.length();j++){
                
                if(j+1 == s.length()){
                    tmp.append(cnt);
                    tmp.append(s.charAt(j));
                    cnt = 1;
                    break;
                }
                
                if(s.charAt(j) == s.charAt(j+1)){
                    ++cnt;
                }else{
                    tmp.append(cnt);
                    tmp.append(s.charAt(j));
                    cnt = 1;
                }
                
            }
            s = tmp.toString();
            
        }
        
        
        return s;
    }

}