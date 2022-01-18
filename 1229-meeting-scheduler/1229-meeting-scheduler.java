class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        Arrays.sort(slots1,Comparator.comparingInt(a -> a[0]));
        
        Arrays.sort(slots2,Comparator.comparingInt(a -> a[0]));
        
        int i=0;
        int j =0 ;
        
        List<Integer> ans = new ArrayList();
        
        while(i<slots1.length && j<slots2.length){
            
            if((slots1[i][0]>= slots2[j][0] && slots1[i][0]<=slots2[j][1])
              || (slots1[i][1]>= slots2[j][0] && slots1[i][1]<=slots2[j][1])
              || (slots2[j][0]>= slots1[i][0] && slots2[j][0]<=slots1[i][1])
              || (slots2[j][1]>= slots1[i][0] && slots2[j][1]<=slots1[i][1])){
                
                int start = Math.max(slots1[i][0],slots2[j][0]);
                int end = Math.min(slots1[i][1],slots2[j][1]);
                
                if(start+duration<=end){
                    ans.add(start);
                    ans.add(start+duration);
                    break;
                }else{
                    
                    if(slots1[i][1]<slots2[j][1]){
                        i++;
                    }else{
                        j++;
                    }
                    
                }
                
            }else{
                
                if(slots1[i][0]>slots2[j][0]){
                    j++;
                }else{
                    i++;
                }
                
                
            }
            
        }
        
        return ans;
    }
}