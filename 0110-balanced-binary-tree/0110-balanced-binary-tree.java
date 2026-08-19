class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int l = height(root.left);
        int r = height(root.right);

        if (Math.abs(l - r) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int l = height(root.left);
        int r = height(root.right);

        return Math.max(l, r) + 1;
    }
}