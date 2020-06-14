package algorithm.Day02JZ18Mirror;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * @return 返回叶子节点的值
     */
    @Override
    public String toString() {
        return this.val + "";
    }

    /**
     * 先序遍历二叉树
     * 
     * @param root 二叉树的根节点
     */
    public static void visitBiTree(TreeNode root) {
        if (root == null) {
            System.out.print("");
            return;
        }
        System.out.print(root.toString() + " ");
        if (root.left != null) {
            visitBiTree(root.left);
        }
        if (root.right != null) {
            visitBiTree(root.right);
        }
    }
}