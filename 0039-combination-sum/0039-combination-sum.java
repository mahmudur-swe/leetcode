class Solution {

    List<List<Integer>> ans = new ArrayList();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    
        combinationSum(candidates, target , 0 , new ArrayList());

        return ans;
    }


    public void combinationSum(int[] candidates, int target,int pos,List<Integer> values) {
        
        if(pos == candidates.length){

            if(target==0){
               List<Integer> val = new ArrayList();
                val.addAll(values);
                ans.add(val);
            }
            return;
        }


        if(target - candidates[pos]>=0){
            values.add(candidates[pos]);
            combinationSum(candidates, target - candidates[pos], pos, values);
            values.remove(values.size()-1);
        }

        combinationSum(candidates, target, pos+1, values);

    


    }
}