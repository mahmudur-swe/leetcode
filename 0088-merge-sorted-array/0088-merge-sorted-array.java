class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n==0){
            return;
        }


        for(int i=m+n;i>0;i--){
            
            if(n==0){
                break;
            }
            else if(m==0){
                nums1[i-1] = nums2[n-1];
                n--;
            }else if(nums1[m-1]<=nums2[n-1]){
                nums1[i-1] = nums2[n-1];
                n--;
            }else{
                nums1[i-1] = nums1[m-1];
                m--;
            }
            
        }

    }
}