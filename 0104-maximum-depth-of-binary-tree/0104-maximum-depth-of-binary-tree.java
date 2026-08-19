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
    public int maxDepth(TreeNode root) {
        return levelOrder(root);
    }

    public int levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int cnt = 0;
        if(root == null) return 0;

        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                temp.add(node.val);

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            cnt++;
        }
        return cnt;
    }
}