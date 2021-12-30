class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length()>s.length()){
            return "";
        }
        
        int[] count = new int[60];
        int[] countS = new int[60];
        
        for(int i=0;i<t.length();i++){
            ++count[t.charAt(i)-'A'];
            ++countS[s.charAt(i)-'A'];
        }
        
        if(checkCount(count,countS)){
            return s.substring(0,t.length());
        }
        
        int startPos = 0;
        
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'A'] == 0 || (count[s.charAt(i)-'A']<countS[s.charAt(i)-'A'])){
                startPos++;
                --countS[s.charAt(i)-'A'];
            }else{
                break;
            }
        }
        
        String ans = null;
        
        for(int i=t.length();i<s.length();i++){
            
            int sChar = s.charAt(i) - 'A';
            
            if(count[sChar] == 0){
                continue;
            }
            
            countS[sChar]++;
            
            //System.out.println(i+" " + s.charAt(startPos) +" " + s.charAt(i) +" " + countS[sChar]);
            
            if(countS[sChar] >= count[sChar]){
                
                if(s.charAt(startPos) == s.charAt(i) && countS[sChar]>count[sChar]){
                    
                    --countS[s.charAt(startPos)-'A'];
                    ++startPos;
                    
                    for(int k=startPos;k<i;k++){
                        
                       //  System.out.println("xx "+ k+" " + s.charAt(startPos) +" " + countS[s.charAt(k)-'A'] +" "+count[s.charAt(k)-'A']);
                        
                        if(count[s.charAt(k)-'A'] == 0 || (count[s.charAt(k)-'A']<countS[s.charAt(k)-'A'])){
                            startPos++;
                            --countS[s.charAt(k)-'A'];
                        }else{
                            break;
                        }
                    }
                    //System.out.println("aa => " + startPos +" "+i);
                }
                
                boolean isFound = checkCount(count,countS);
                
                if(isFound){
                    if(ans == null || ans.length()>i-startPos+1){
                        ans = s.substring(startPos,i+1);
                    }
                    
                    //System.out.println("1=> " + startPos + " " + i +" " + s.substring(startPos,i+1));
                    
                    --countS[s.charAt(startPos)-'A'];
                    
                    ++startPos;
                    
                    for(int k=startPos;k<i;k++){
                        if(count[s.charAt(k)-'A'] == 0 || (count[s.charAt(k)-'A']<countS[s.charAt(k)-'A'])){
                            startPos++;
                            --countS[s.charAt(k)-'A'];
                            //System.out.println("k=> "+ k +" " + s.charAt(k) + " " + countS[s.charAt(k)-'A']);
                        }else{
                            break;
                        }
                    }
                    
                    //System.out.println("2=> " + startPos +" "+i);
                }
            }
            
            
        }
        
        if(ans==null){
            return "";
        }
        
        return ans;
        
    }
    
    private boolean checkCount(int[] count,int[] countS){
        
        for(int i=0;i<count.length;i++){
            if(count[i]>0 && count[i]>countS[i]){
                return false;
            }
        }
        return true;
        
    }
}