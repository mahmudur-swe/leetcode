class Solution {

    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target , 0 , new ArrayList());
        return ans;
    }


    public void combinationSum(int[] candidates, int target,int pos,List<Integer> values) {
        
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
        }

        List<Integer> res2 = new ArrayList();

        res2.addAll(values);

        combinationSum(candidates, target, pos+1, res2);

        res2.add(candidates[pos]);

        combinationSum(candidates, target - candidates[pos], pos, res2);


    }
}