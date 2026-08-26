class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int targetIdx = 0; // Pointer for target array
        for (int num = 1; num <= n; num++) {
            // Stop if we have matched all target elements
            if (targetIdx == target.length) {
                break;
            }
            // Always push the current stream number
            list.add("Push");
            if (num == target[targetIdx]) {
                // If matched, move to next target element
                targetIdx++;
            } else {
                // If not matched, discard it with Pop
                list.add("Pop");
            }
        }
        return list;
        
    }
}