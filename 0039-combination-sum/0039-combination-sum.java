class Solution {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        calc(0,arr,candidates,target,list);
        return list;   
    }
    public void calc(int ind,List<Integer> arr,int[] cad,int tar,List<List<Integer>> list)
    {
        if(ind==cad.length)
        {
            if(tar==0)
            {
                list.add(new ArrayList<>(arr));
            }
                return;
        }
        if(cad[ind]<=tar)
        {
            arr.add(cad[ind]);
            calc(ind,arr,cad,tar-cad[ind],list);
            arr.remove(arr.size()-1);
        }
        calc(ind+1,arr,cad,tar,list);
    }
}