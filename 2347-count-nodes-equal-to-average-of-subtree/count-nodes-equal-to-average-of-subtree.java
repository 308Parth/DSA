/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        findAverage(root);
        return ans;
    }

    public int[] findAverage(TreeNode node) {

        // if node is null
        if (node == null) {
            return new int[]{0, 0};
        }

        // go to left subtree
        int[] left = findAverage(node.left);

        // go to right subtree
        int[] right = findAverage(node.right);

        // calculate current subtree
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            ans++;
        }

        return new int[]{sum, count};
    }
}