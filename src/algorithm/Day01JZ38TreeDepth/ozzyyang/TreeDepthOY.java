package algorithm.Day01JZ38TreeDepth.ozzyyang;

import algorithm.Day01JZ38TreeDepth.TreeNode;

/**
 * @author Created by OzzyYang on 2020/6/12 牛客网，剑指offer，JZ38，二叉树的深度 题目描述：
 *         输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class TreeDepthOY {
    /**
     * @param root 根节点
     * @return 根节点为root的二叉树的深度
     */
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }
}
