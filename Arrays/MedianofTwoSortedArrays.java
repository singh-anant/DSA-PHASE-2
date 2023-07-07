public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int merged[] = new int[nums1.length + nums2.length];
        int c = 0;
        /*
         * for(int i=0;i<nums1.length;i++){
         * merged[c++]=nums1[i];
         * }
         * for(int i=0;i<nums2.length;i++){
         * merged[c++]=nums2[i];
         * }
         * Arrays.sort(merged);
         */
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (i == n1 - 1) {
                while (j < n2) {
                    merged[c++] = nums2[j++];
                    break;
                }

            } else if (i == n2 - 1) {
                while (i < n1) {
                    merged[c++] = nums1[i++];
                    break;
                }
            }

            if (nums1[i] > nums2[j])
                merged[c++] = nums2[j++];
            else if (nums1[i] < nums2[j])
                merged[c++] = nums1[i++];

        }

        int n = merged.length;
        if (merged.length % 2 != 0) {

            return merged[n / 2];
        } else {

            return (merged[n / 2] + merged[n / 2 - 1]) / 2.0;
        }

    }
}
