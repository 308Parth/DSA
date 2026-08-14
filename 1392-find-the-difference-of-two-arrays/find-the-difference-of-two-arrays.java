class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> arr = new ArrayList<>();

        arr.add(new ArrayList<>());
        arr.add(new ArrayList<>());

        Set<Integer> set1 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        int[] num1 = new int[set1.size()];

        int i = 0;
        for (int num : set1) {
            num1[i++] = num;
        }

        Set<Integer> set2 = new HashSet<>();

        for (int num : nums2) {
            set2.add(num);
        }

        int[] num2 = new int[set2.size()];

        i = 0;
        for (int num : set2) {
            num2[i++] = num;
        }

        // Elements in nums1 but not in nums2
        for (i = 0; i < num1.length; i++) {
            boolean found = false;

            for (int j = 0; j < num2.length; j++) {
                if (num1[i] == num2[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                arr.get(0).add(num1[i]);
            }
        }

        // Elements in nums2 but not in nums1
        for (i = 0; i < num2.length; i++) {
            boolean found = false;

            for (int j = 0; j < num1.length; j++) {
                if (num2[i] == num1[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                arr.get(1).add(num2[i]);
            }
        }

        return arr;
    }
}