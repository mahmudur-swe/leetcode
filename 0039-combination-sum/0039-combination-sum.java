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

    
        if(target - candidates[pos] == 0){
            List<Integer> res = new ArrayList();
            res.addAll(values);
            res.add(candidates[pos]);
            if(ans.contains(res)==false){
                ans.add(res);
            }
        }

        List<Integer> res2 = new ArrayList();

        res2.addAll(values);

        combinationSum(candidates, target, pos+1, res2);

        boolean ifAdded = false;

         List<Integer> res3 = new ArrayList();

            res3.addAll(values);
            res3.add(candidates[pos]);

            combinationSum(candidates, target - candidates[pos], pos, res3);

            List<Integer> res4 = new ArrayList();

       

   


    }
}