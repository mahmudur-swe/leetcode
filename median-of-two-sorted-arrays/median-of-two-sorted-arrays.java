class Solution {
      
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //int[] num = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int length = (nums1.length+nums2.length);
        int index = 0;
        if(length%2==1){
            while (true){
                if (i==nums1.length && j==nums2.length){
                    break;
                }
                if(i<nums1.length && j<nums2.length){
                    if(nums1[i]<=nums2[j]){
                        
                        if(index == length/2){
                            return nums1[i];
                        }
                        i++;
                        
                    }else {
                        if(index == length/2){
                            return nums2[j];
                        }
                        j++;
                    }
                }else if(i<nums1.length){
                    if(index == length/2){
                        return nums1[i];
                    }
                    i++;
                }else {
                    if(index == length/2){
                        return nums2[j];
                    }
                    j++;
                }
                index++;
            }
        }else {
            int preValue = 0;
            while (true){
                if (i==nums1.length && j==nums2.length){
                    break;
                }
                if(i<nums1.length && j<nums2.length){
                    if(nums1[i]<=nums2[j]){
                        if(index == length/2-1){
                            preValue = nums1[i];
                        }
                        else if(index == length/2){
                            return (preValue+nums1[i])/2.0;
                        }
                        i++;

                    }else {
                        if(index == length/2-1){
                            preValue = nums2[j];
                        }
                        else if(index == length/2){
                            return (preValue+nums2[j])/2.0;
                        }
                        j++;
                    }
                }else if(i<nums1.length){
                    if(index == length/2-1){
                        preValue = nums1[i];
                    }
                    else if(index == length/2){
                        return (preValue+nums1[i])/2.0;
                    }
                    i++;
                }else {
                    if(index == length/2-1){
                        preValue = nums2[j];
                    }
                    else if(index == length/2){
                        return (preValue+nums2[j])/2.0;
                    }
                    j++;
                }
                index++;
            }
        }
        return 0;
    }
}