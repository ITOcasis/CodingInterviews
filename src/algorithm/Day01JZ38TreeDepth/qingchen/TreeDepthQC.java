package algorithm.Day01JZ38TreeDepth.qingchen;

import algorithm.Day01JZ38TreeDepth.TreeNode;

/**
 * @author Created by ChenJiaQiang on 2020/6/12 14:13 牛客网，剑指offer，JZ38，二叉树的深度
 *         题目描述： 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepthQC {

    /**
     * 我的思路：分别遍历左右子树，同时记录遍历的次数，返回其中的最大值
     *
     * @param root
     * @return
     */
    public static int TreeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

}
