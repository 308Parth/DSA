class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {

        string ans = "";

        // Check each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0][i];

            // Compare with all other strings
            for (int j = 1; j < strs.size(); j++) {

                // If current string is too short
                if (i >= strs[j].length()) {
                    return ans;
                }

                // If characters don't match
                if (strs[j][i] != ch) {
                    return ans;
                }
            }

            // If all strings matched at this position
            ans = ans + ch;
        }

        return ans;
    }
};