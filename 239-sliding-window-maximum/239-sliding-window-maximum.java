class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayDeque<Integer> pq = new ArrayDeque();
        
        
        int[] ans = new int[nums.length-k+1];
        int pos = 0;
        
        for(int i=0;i<k;i++){
            
            while(pq.size()>0 && nums[pq.getLast()]<nums[i]){
                pq.removeLast();
            }
            
            pq.addLast(i);
            
        }
        
        ans[pos++] = nums[pq.getFirst()];
        
        
        for(int i=k;i<nums.length;i++){
            
            if(nums[i-k] == nums[pq.getFirst()]){
                pq.removeFirst();
            }
            
            
            while(pq.size()>0 && nums[pq.getLast()]<nums[i]){
                pq.removeLast();
            }
            
            
            pq.addLast(i);
                
            ans[pos++] = nums[pq.getFirst()];
            
            
        }
        
        return ans;
        
    }
}