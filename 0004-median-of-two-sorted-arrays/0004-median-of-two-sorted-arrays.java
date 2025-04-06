class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

    
        boolean isEven = (n+m)%2 == 0;

        if(n==0){
            
            if(isEven){
                return (nums2[m/2-1] + nums2[m/2])/2.0;
            }else{
                return  nums2[m/2];
            }   
        }

        if(m==0){
            if(isEven){
                return (nums1[n/2-1] + nums1[n/2])/2.0;
            }else{
                return  nums1[n/2];
            }   
        }

        int i = 0;
        int j = 0;

        int pos = 0;

        double ans = 0.0;

        while(pos < n + m){

            if(isEven){

                if(pos == (n + m) / 2 || pos == (n + m) / 2 - 1){

                    if(i<n && j<m){
                        ans += Math.min(nums1[i] , nums2[j]);
                    }else if(i<n){
                        ans += nums1[i];
                    }else{
                        ans += nums2[j];
                    }

                   // System.out.println("Ans " + ans);


                    

                }

            }else{

                if(pos == (n + m) / 2){

                    if(i<n && j<m){
                        ans = Math.min(nums1[i] , nums2[j]);
                    }else if(i<n){
                        ans = nums1[i];
                    }else{
                        ans = nums2[j];
                    }

                }

               

            }

             if(i<n && j<m){
                    if(nums1[i] <= nums2[j]){
                        i++;
                    }else{
                        j++;
                    }
                }else if(i<n){
                    i++;
                }else{
                    j++;
                }

           
            
            pos++;
            


        }


            

            

    return isEven? ans/2.0 : ans;

        
        
    }
}