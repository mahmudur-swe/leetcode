class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String,Integer> counter = new HashMap();
        
        for(String ss:cpdomains){
            int count = 0;
            String s="";
            for(int i=0;i<ss.length();i++){
                
                if(ss.charAt(i)==' '){
                    s = ss.substring(i+1);
                    break;
                }
                
                count = (count*10) + (ss.charAt(i)-'0');
                
            }
            
            //System.out.println()
            
            String tmp = "";
            
            for(int i=s.length()-1;i>=0;i--){
                
                if(s.charAt(i) == '.'){
                    int cnt = counter.getOrDefault(tmp,0);
                    counter.put(tmp,cnt+count);
                }
                
                tmp = s.charAt(i)+tmp;
                
                if(i==0){
                    int cnt = counter.getOrDefault(tmp,0);
                    counter.put(tmp,cnt+count);
                }
            }
            
        }
        List<String> ans = new ArrayList();
        for(Map.Entry<String,Integer> entry:counter.entrySet()){
            ans.add(String.format("%s %s",entry.getValue(),entry.getKey()));
        }
        return ans;
    }
}