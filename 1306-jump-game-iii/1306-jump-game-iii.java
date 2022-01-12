class Solution {
    
    
    public boolean canReach(int[] arr, int start) {
        
        if(start<0 || start>=arr.length){
            return false;
        }
        
        //System.out.println(start +" " + arr[start]);
        
        if(arr[start] == 0){
            return true;
        }
        
        if(arr[start] == -1){
            return false;
        }
        
        int move = arr[start];
        
        arr[start] = -1;
        
        return canReach(arr,start+move) || canReach(arr,start-move);
        
        
    }
}