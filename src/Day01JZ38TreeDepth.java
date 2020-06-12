/**
 * @author Created by ChenJiaQiang on 2020/6/12 14:13
 * 牛客网，剑指offer，JZ38，二叉树的深度
 * 题目描述：
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Day01JZ38TreeDepth {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 初始化一棵树:{1,2,3,4,5,#,6,#,#,7}
     *
     * @return
     */
    public static TreeNode init() {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node4.left = node5;

        node2.right = node6;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = init();
        System.out.println(TreeDepthQC(root));
    }

    /**
     * 我的思路：分别遍历左右子树，同时记录遍历的次数，返回其中的最大值
     *
     * @param root
     * @return
     */
    public static int TreeDepthQC(TreeNode root) {
        return root == null ? 0 : Math.max(TreeDepthQC(root.left), TreeDepthQC(root.right)) + 1;
    }

}
