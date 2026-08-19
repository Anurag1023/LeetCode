class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // Diameter passing through this node
        max = Math.max(max, left + right);

        // Return height to parent
        return 1 + Math.max(left, right);
    }
}