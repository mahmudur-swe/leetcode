class Solution {
    
    List<List<Integer>> ans = new ArrayList();
    
    HashSet<List> hashSet = new HashSet<>();
        
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        this.candidates = candidates;
        this.target = target;
        
        Arrays.sort(this.candidates);
        
        getAns(new LinkedList(),0);
        
        return ans;
    }
    
    private void getAns(LinkedList<Integer> res,int sum){
        
        if(target == sum){
            
            ArrayList<Integer> r = new ArrayList(res);
            Collections.sort(r);
            
            if(!ans.contains(r)){
                ans.add(r);
            }
            return;
        }
        if(sum>target){
            return;
        }
        
        for(int i=0;i<candidates.length;i++){
            if(i>0 && candidates[i-1] == candidates[i]){
                continue;
            }
            if(sum+candidates[i]<=target){
                res.add(candidates[i]);
                getAns(res,sum+candidates[i]);
                res.removeLast(); 
            }
        }
        
        
        
    }
}