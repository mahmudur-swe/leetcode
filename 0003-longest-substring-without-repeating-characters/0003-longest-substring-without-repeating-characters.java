class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0){
            return 0;
        }

        int ans  = 0;

        int start = 0;
        int end = 0;
        int[] charPos = new int[200];
        for(int i=0;i<charPos.length;i++){
            charPos[i] = -1;
        }

        while(end<s.length()){
            
            if(charPos[s.charAt(end)]!=-1){
                start = Math.max(charPos[s.charAt(end)]+1,start);
            }

            ans = Math.max(ans,end-start+1);

            charPos[s.charAt(end)] = end;
            end++;
        }


        return ans;
    }
}