class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> add = nums1;
        add.insert(add.end(), nums2.begin(), nums2.end());
        sort(add.begin(), add.end());

        int total = add.size();
        if (total % 2 == 0) {
            // even length
            return (add[total/2 - 1] + add[total/2]) / 2.0;
        } else {
            // odd length
            return add[total/2];
        }
    }
};
