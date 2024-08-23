class Solution {

    List<List<Integer>> ans = new ArrayList();

    boolean[][][] dp;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dp = new boolean[target+1][candidates.length][2];

        combinationSum(candidates, target , 0 , new ArrayList(),false);


        return ans;
    }


    public void combinationSum(int[] candidates, int target,int pos,List<Integer> values, boolean with) {
        
        if(pos>=candidates.length){
            return;
        }

        if(target<0){
            return;
        }


        if(target==0){
             if(ans.contains(values)==false){
               ans.add(values);
            }


        if(with){
            if(dp[target][pos][0] == true){
                return;
            }
        }else{
            if(dp[target][pos][1] == true){
                return;
            }
        }
        }



        if(with){
            dp[target][pos][0] = true;
        }else{
            dp[target][pos][1] = true;
        }

        List<Integer> res2 = new ArrayList();

        res2.addAll(values);

        combinationSum(candidates, target, pos+1, res2, false);
      
        res2.add(candidates[pos]);

        combinationSum(candidates, target - candidates[pos], pos, res2,true);


    }
}