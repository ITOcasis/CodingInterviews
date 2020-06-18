package algorithm.Day07JZ57GetNext;

import algorithm.Day07JZ57GetNext.qingchen.GetNextQC;

public class TestClass {
     /**
     * 初始化一棵树:{1,2,3,4,5,#,6,#,#,7}
     *              1
      *          2     3
      *        4   5     6
      *          7
     * @return
     */
    public static TreeLinkNode init() {
        TreeLinkNode root = new TreeLinkNode(8);

        TreeLinkNode node1 = new TreeLinkNode(6);
        TreeLinkNode node2 = new TreeLinkNode(10);

        TreeLinkNode node3 = new TreeLinkNode(5);
        TreeLinkNode node4 = new TreeLinkNode(7);

        TreeLinkNode node5 = new TreeLinkNode(9);
        TreeLinkNode node6 = new TreeLinkNode(11);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;
        node1.next = root;

        node2.left = node5;
        node2.right = node6;
        node2.next = root;

        node3.next = node1;
        node4.next = node1;

        node5.next = node2;
        node6.next = node2;
        return root;
    }

    public static void main(String[] args) {
        TreeLinkNode init = init();
        System.out.println(GetNextQC.GetNext(init.left).val);
    }
}