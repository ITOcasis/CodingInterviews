package algorithm.Day06JZ22PrintFromTopToBottom;

import algorithm.Day05JZ58IsSymmetrical.qingchen.IsSymmetricalQC;
import algorithm.Day06JZ22PrintFromTopToBottom.qingchen.PrintFromTopToBottomQC;

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

    public static TreeNode init2() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        node1.right = node3;
        node2.right = node3;
        return root;
    }


    public static void main(String[] args) {
        System.out.println(PrintFromTopToBottomQC.PrintFromTopToBottom(init()));
    }
}