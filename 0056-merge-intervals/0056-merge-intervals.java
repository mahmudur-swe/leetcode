class Solution {
    public int[][] merge(int[][] intervals) {

        int pos = 0;

      
        java.util.Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));

        for(int i=1;i<intervals.length;i++){
            if(isMergeAble(intervals[pos],intervals[i]) || isMergeAble(intervals[i],intervals[pos]))
                intervals[pos] = merge(intervals[pos],intervals[i]);
            else{
                intervals[++pos] = intervals[i];
            }
        }

        int[][] ans = new int[pos+1][2];

        for(int i=0;i<=pos;i++){
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }

        return ans;
        
        
    }


    private boolean isMergeAble(int[]range1, int[] range2){


        return ((range1[0] >= range2[0] && range1[0] <= range2[1]) ||  (range1[1] >= range2[0] && range1[1] <= range2[1]));
        
    }

    private int[] merge(int[]range1, int[] range2){

        int[] ans = new int[2];

        ans[0] = Math.min(range1[0],range2[0]);

        ans[1] = Math.max(range1[1],range2[1]);

        return ans;
        
    }
}