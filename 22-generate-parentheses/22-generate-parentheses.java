class Solution {
    
    List<String> ans = new ArrayList();
    
    public List<String> generateParenthesis(int n) {
        getAns(new StringBuilder(),n,n);
        return ans;
    }
    
    private void getAns(StringBuilder s,int f,int b){
        
        if(b<f){
            return;
        }
        
        if(f<0 || b<0){
            return;
        }
        
        if(f==0 && b ==0){
            ans.add(s.toString());
            return;
        }
        
        if(f>0){
            
            s.append('(');
            getAns(s,f-1,b);
            //s.append(')');
            //getAns(s,f-1,b-1);
            //s.deleteCharAt(s.length()-1);
            s.deleteCharAt(s.length()-1);
            
        }
        if(b>0){
            s.append(')');
            getAns(s,f,b-1);
            s.deleteCharAt(s.length()-1);
        }
        
        
    }
}