class Solution {
    
    
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        
        String[] spaces = new String[maxWidth+1];
        String space = "";
        for(int i=0;i<=maxWidth;i++){
            spaces[i] = space;
            space += " ";
        }
        
 
        List<String> ans = new ArrayList();
        
        int start = 0;
        int end = 1;
        int curLength = words[0].length();
        
        while(end<=words.length){
            
            
            if(end<words.length && curLength + words[end].length()+1 <= maxWidth){
                curLength = curLength + words[end].length()+1;
                end++;
            }else{
                int wordCount = end - start;
                
                String line = "";
                    
                if(wordCount==1){
                    line = words[start];
                    line += spaces[maxWidth-line.length()];
                }else{
                    
                    int spaceExtra = maxWidth - curLength;
                    
                    int envnSpace = spaceExtra/(wordCount-1);
                    int oddSpace = spaceExtra%(wordCount-1);
                    
                    if(end==words.length){
                        envnSpace = 0;
                        oddSpace = 0;
                    }
                    
                    line = words[start];
                    
                    for(int i=start+1;i<end;i++){
                        
                        if(oddSpace>0){
                          line += spaces[envnSpace+2];  
                        }else{
                           line += spaces[envnSpace+1];   
                        }
                        
                        oddSpace--;
                        line += words[i];
                    }
                    
                    if(end==words.length){
                        line += spaces[maxWidth-line.length()];
                    }
                    
                }
                
                
                ans.add(line);
                
                if(end < words.length){
                    
                    start = end;
                
                    curLength = words[start].length();
                }
 
                end++;
                
                
            }
            
            
            
            
            
        }
        
        return ans;
        
    }
    
    
}