package algorithm.Day02JZ18Mirror.ozzyyang;

import algorithm.Day02JZ18Mirror.TreeNode;

public class MirrorOY {
    /**
     * 使用递归算法对源二叉树进行遍历，同时交换左右孩子节点，将源二叉树转换为其对应的镜面二叉树
     * @param root 二叉树的根节点
     */
    public static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode nodeTemp = null;
        nodeTemp = root.left;
        root.left = root.right;
        root.right = nodeTemp;
        if (root.left != null) {
            MirrorOY.mirror(root.left);
        }
        if (root.right != null) {
            MirrorOY.mirror(root.right);
        }
    }
}