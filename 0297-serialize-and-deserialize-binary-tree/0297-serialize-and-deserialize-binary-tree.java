public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    // Deserialize
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");

        Queue<String> q = new LinkedList<>();

        for (String s : arr) {
            q.offer(s);
        }

        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q) {

        String val = q.poll();

        if (val.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = deserializeHelper(q);
        root.right = deserializeHelper(q);

        return root;
    }
}