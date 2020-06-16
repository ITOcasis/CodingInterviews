package algorithm.Day05JZ58IsSymmetrical;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(){}

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
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("此树无节点！");
            return;
        }

        System.out.print(root.toString() + " ");
        if (root.left != null) {
            preOrderTraversal(root.left);
        }

        if (root.right != null) {
            preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历二叉树
     * 
     * @param root 二叉树的根节点
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.toString() + " ");
            inOrderTraversal(root.right);
        }
    }

    /**
     * 后序遍历二叉树
     * 
     * @param root 二叉树的根节点
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.print(root.toString() + " ");
        }
    }
}