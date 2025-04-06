class Solution {

    // abcabcbb = i = 0 ;
    // flag to check char already apper or not
    // goto thofh until repeated char found
    // then break start from next pos.
    // Time b c d = n^2
    // Space O(n)

    // start = 0;
    // end = 0;

    // flag[a] = 0;
    // flag [b] = 1, flag c = 2//
    // flag[a] > start
    // srart = flag[a] + 1
    // end = current pos;


    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }


        int start = 0;
        int end = 0;

        int ans = 0;

        int[] flag = new int[500];

        Arrays.fill(flag,-1);

        while(end<s.length()){

            char c = s.charAt(end);

            if(flag[c] != -1 && flag[c]>=start){
                start = flag[c]+1;
            }

            
            flag[c] = end;

            ans = Math.max(ans, end-start+1);

            end++;


        }

        return ans;
        
    }
}