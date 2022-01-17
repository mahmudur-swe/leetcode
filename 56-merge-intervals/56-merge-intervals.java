class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length<=1){
            return intervals;
        }
        
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));
  
        int[] last = intervals[0];
        
        List<int[]> ans = new ArrayList();
        
        for(int i=1;i<intervals.length;i++){
            
            if(intervals[i][0]>last[1]){
                ans.add(last);
                last = intervals[i];
            }else{
                last[1] = Math.max(intervals[i][1],last[1]);
            }
        }
        
        ans.add(last);
        
        int[][] result = new int[ans.size()][2];
        
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        
        return result;
    }
}