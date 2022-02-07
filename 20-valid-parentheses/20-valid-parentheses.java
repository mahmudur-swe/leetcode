class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(int i=0;i<s.length();i++){
            
            char c = s.charAt(i);
            
            if(isOpening(c)){
                stack.add(c);
            }else{
                
                if(stack.size() == 0){
                    return false;
                }
                if(stack.peek() != getAlter(c)){
                    return false;
                }
                stack.pop();
                
            }
            
        }
        
        return stack.size() == 0; 
       
    }
    
    public boolean isOpening(char c){
        return c == '(' || c == '{' || c == '[' ;
    }
    
    public char getAlter(char c){
        if(c == ')'){
            return '(';
        }  
        
        if(c == '}'){
            return '{';    
        }
        
        if(c == ']'){
            return '[';    
        }
        
        if(c == ')'){
            return '(';    
        }
        
        if(c == '{'){
            return '}';    
        }
        
        if(c == '['){
            return ']';    
        }
        
        return c;
    }
    
    

    
}

/*

Time = O(n)
Space = O(n)

firstBracket = 0
secondBracket = 0
thirdBracket = 0

( , { , [
) , } , ]

*/