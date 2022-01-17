class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]> ans = new ArrayList();
        
        int[] current = null;
        
        current = intervals[0];
        
        for(int i=1;i<intervals.length;i++){
            
            int[] merge = merge(current,intervals[i]);
            
            if(merge == null){
                //System.out.println("c1 "+current[0]+" " + current[1]);
                ans.add(current);
                current = intervals[i];
                 //System.out.println("c2 "+current[0]+" " + current[1]);
            }else{
                //System.out.println(merge[0]+" "+merge[1]);
                current = merge;
            }
        }
        
        if(current!=null){
            ans.add(current);
        }
        
        int[][] result = new int[ans.size()][2];
        
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        
        return result;
    }
    
    public int[] merge(int[] l1,int[] l2){
        
        if(l2[0]>=l1[0] && l2[0]<=l1[1]){
            l1[0] = Math.min(l1[0],l2[0]);
            l1[1] = Math.max(l1[1],l2[1]);
            return l1;
        }
        
        return null;
    }
    
}