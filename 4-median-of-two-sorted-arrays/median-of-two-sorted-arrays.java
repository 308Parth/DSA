
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> v = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Merge both arrays
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                v.add(nums1[i]);
                i++;
            }
            else {
                v.add(nums2[j]);
                j++;
            }
        }

        // Add remaining elements of nums1
        while (i < nums1.length) {
            v.add(nums1[i]);
            i++;
        }

        // Add remaining elements of nums2
        while (j < nums2.length) {
            v.add(nums2[j]);
            j++;
        }

        // Find median
        int a = v.size();
        int l = a / 2;

        if (a % 2 == 0) {
            return (v.get(l) + v.get(l - 1)) / 2.0;
        }
        else {
            return v.get(l);
        }
    }
}
