package algorithm.Day12JZ23VerifySquenceOfBST;


import algorithm.Day09JZ24FindPath.qingchen.FindPathQC;

import java.util.ArrayList;

public class TestClass {
    /**
     * 初始化一棵树:
     *                33
     *        17              50
     *    13     18       34      58
     *      16      25        51      66
     *                 27
     *
     * @return
     */
    public static TreeNode init() {
        TreeNode root = new TreeNode(33);
        TreeNode node1 = new TreeNode(17);
        TreeNode node2 = new TreeNode(50);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(13);
        TreeNode node4 = new TreeNode(18);
        node1.left=node3;
        node1.right=node4;
        TreeNode node5 = new TreeNode(16);
        node3.right = node5;
        TreeNode node6 = new TreeNode(25);
        node4.right = node6;
        TreeNode node7 = new TreeNode(27);
        node6.right = node7;
        TreeNode node8 = new TreeNode(34);
        TreeNode node9 = new TreeNode(58);
        node2.left = node8;
        node2.right=node9;
        TreeNode node10 = new TreeNode(51);
        TreeNode node11 = new TreeNode(66);
        node9.left = node10;
        node9.right = node11;
        return root;
    }

    public static TreeNode init2(){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(13);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(8);
        n1.left = n3;
        n1.right = n4;

        return root;
    }

    public static TreeNode init3(){
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        root.left = n1;
        TreeNode n2 = new TreeNode(3);
        n1.left = n2;
        TreeNode n3 = new TreeNode(2);
        n2.left = n3;
        TreeNode n4 = new TreeNode(1);
        n3.left = n4;
        return root;
    }

    public static TreeNode init4(){
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(11);
        n1.left = n3;
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(2);
        n3.left =n4;
        n3.right = n5;
        TreeNode n6 = new TreeNode(13);
        TreeNode n7 = new TreeNode(4);
        n2.left = n6;
        n2.right = n7;
        TreeNode n8 = new TreeNode(5);
        TreeNode n9 = new TreeNode(1);
        n7.left = n8;
        n7.right = n9;
        return root;
    }

    public static void main(String[] args) {

    }
}