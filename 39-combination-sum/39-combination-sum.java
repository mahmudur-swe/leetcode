class Solution {
    
    List<List<Integer>> ans = new ArrayList();
    
    HashSet<List> hashSet = new HashSet<>();
        
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        this.candidates = candidates;
        this.target = target;
        
        Arrays.sort(this.candidates);
        
        getAns(new LinkedList(),0,0);
        
        return ans;
    }
    
    private void getAns(LinkedList<Integer> res,int sum,int pos){
        
        if(target == sum){
            
            ArrayList<Integer> r = new ArrayList(res);
            ans.add(r);
            return;
        }
        if(sum>target){
            return;
        }
        
        for(int i=pos;i<candidates.length;i++){
            if(i>0 && candidates[i-1] == candidates[i]){
                continue;
            }
            if(sum+candidates[i]<=target){
                res.add(candidates[i]);
                getAns(res,sum+candidates[i],i);
                res.removeLast(); 
            }
        }
        
        
        
    }
}