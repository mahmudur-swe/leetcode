class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;

        int m = nums1.length;
        int n = nums2.length;

        int evenPastValue = 0;
        double evenCount = 1.00 + 1.0*((1+ m + n) % 2);

        int midPoint = (m + n) / 2;

        while (i + j <= (m + n) / 2) {

            if (i + j == midPoint) {
                if (i == m) {
                    return (evenPastValue + nums2[j]) / evenCount;
                } else if (j == n) {
                    return (evenPastValue + nums1[i]) / evenCount;
                } else if (nums1[i] <= nums2[j]) {
                    return (evenPastValue + nums1[i]) / evenCount;
                } else {
                    return (evenPastValue + nums2[j]) / evenCount;
                }

            } else {

                if ((m + n) % 2 == 0 && (i + j) == (m + n) / 2 - 1) {

                    if (i == m) {
                        evenPastValue = nums2[j];
                        j++;
                    } else if (j == n) {
                        evenPastValue = nums1[i];
                        i++;
                    } else if (nums1[i] <= nums2[j]) {
                        evenPastValue = nums1[i];
                        i++;
                    } else {
                        evenPastValue = nums2[j];
                        j++;
                    }

                } else {

                    if (i == m) {
                        j++;
                    } else if (j == n) {
                        i++;
                    } else if (nums1[i] <= nums2[j]) {
                        i++;
                    } else {
                        j++;
                    }
                }

            }

        }

        return 0;
    }

   
}