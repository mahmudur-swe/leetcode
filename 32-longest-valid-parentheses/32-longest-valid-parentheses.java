class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> open = new Stack();
        
        Stack<Integer> close = new Stack();
        
        Stack<Integer> valid = new Stack();
        
        int result = 0;
        
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == '('){
                
                open.add(i);
                
            }else{
                
                if(open.size() > 0){
                    
                    int curStart = open.pop();
                    int curEnd = i;
                    
                    //System.out.println("In "+ curStart +" "+curEnd);
                    
                    if(valid.size()>0){
                        
                        while(true && valid.size()>0){
                            
                            int lastEnd = valid.pop();
                            int lastStart = valid.pop();
                            
                            //System.out.println("last "+ lastStart +" "+lastEnd);
                            
                            if(lastStart>curStart && lastEnd<curEnd){
                                
                                
                            }else if(lastEnd == curStart-1){
                                curStart = lastStart;
                            }else{
                                valid.add(lastStart);
                                valid.add(lastEnd);
                                break;
                            }
                            
                        }
                        
                        valid.add(curStart);
                        valid.add(curEnd);
                        
                        
                        
                    }else{
                        
                        valid.add(curStart);
                        valid.add(curEnd);
                        
                        
                    }
                    
                    
                    //System.out.println("P "+ curStart +" "+curEnd);
                    
                    
                    result = Math.max(curEnd-curStart+1,result);
                    
                    
                }
                
            }
            
            
        }
        
        return result;
    }
}