package algorithm.Day02JZ18Mirror;

import algorithm.Day02JZ18Mirror.*;
import algorithm.Day02JZ18Mirror.ozzyyang.*;
import algorithm.Day02JZ18Mirror.qingchen.*;

public class TestClass {
     /**
     * 初始化一棵树:{1,2,3,4,5,#,6,#,#,7}
     *              1
      *          2     3
      *        4   5     6
      *          7
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
        TreeNode root = TestClass.init();
        TreeNode.visitBiTree(root);
        System.out.println();

//        MirrorOY.mirror(root);
        MirrorQC.Mirror(root);
        TreeNode.visitBiTree(root);
    }
}