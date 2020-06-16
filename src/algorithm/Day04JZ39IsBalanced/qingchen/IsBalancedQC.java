package algorithm.Day04JZ39IsBalanced.qingchen;

import algorithm.Day04JZ39IsBalanced.TreeNode;

/**
 * @author Created by ChenJiaQiang on 2020/6/15
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树。
 */
public class IsBalancedQC {
    /**
     * 我的思路：① 跟Day01的差不多，分别遍历左右子树，记录遍历的次数，再相减，判断是否大于1。
     *
     * @param root
     * @return
     */
    public static boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root) != -1;
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        if (left == -1) return -1;
        int right = TreeDepth(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }
}
