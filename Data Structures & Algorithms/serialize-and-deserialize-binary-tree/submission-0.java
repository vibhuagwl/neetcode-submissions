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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> values = new ArrayList<>();
        serializeHelper(root, values);
        return String.join(",", values);
    }

    private void serializeHelper(TreeNode node, List<String> value) {
        if (node == null) {
            value.add("N");
            return;
        }
        value.add(String.valueOf(node.val));
        serializeHelper(node.left, value);
        serializeHelper(node.right, value);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int index = 0;
        return deserializehelper(vals);
    }

private int index;
    private TreeNode deserializehelper(String[] values) {
        if (values[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        index++;
        node.left = deserializehelper(values);
        node.right = deserializehelper(values);
        return node;
    }
}
