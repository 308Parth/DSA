class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;
            } 
            else if (c == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right);

        return ans;
    }

    void dfs(String s, int index, int leftRemove, int rightRemove) {

        if (leftRemove == 0 && rightRemove == 0) {

            if (isValid(s)) {
                if (!ans.contains(s)) {
                    ans.add(s);
                }
            }

            return;
        }

        for (int i = index; i < s.length(); i++) {

            // Skip duplicate parentheses
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char c = s.charAt(i);

            // Remove '('
            if (c == '(' && leftRemove > 0) {

                String next = s.substring(0, i) + s.substring(i + 1);

                dfs(next, i, leftRemove - 1, rightRemove);
            }

            // Remove ')'
            if (c == ')' && rightRemove > 0) {

                String next = s.substring(0, i) + s.substring(i + 1);

                dfs(next, i, leftRemove, rightRemove - 1);
            }
        }
    }

    boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } 
            else if (c == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}