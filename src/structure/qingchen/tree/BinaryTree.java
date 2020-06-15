package structure.qingchen.tree;

import java.util.Stack;

/**
 * @author Created by ChenJiaQiang on 2020/6/15 15:25
 */
public class BinaryTree {

    public static class TreeNode<T> {
        T val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(T val) {
            this.val = val;
        }
    }

    /**
     * 初始化一棵树:
     *              A
     *          B      C
     *        D   E  F  G
     *
     * @return
     */
    public static TreeNode init() {
        TreeNode root = new TreeNode("A");
        TreeNode node1 = new TreeNode("B");
        TreeNode node2 = new TreeNode("C");
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode("D");
        TreeNode node4 = new TreeNode("E");
        node1.left=node3;
        node1.right=node4;
        TreeNode node5 = new TreeNode("F");
        TreeNode node6 = new TreeNode("G");
        node2.left=node5;
        node2.right=node6;
        return root;
    }

    /**
     * 前序遍历（递归）
     * @param root
     */
    public static void preOrder(TreeNode root){
        if (root==null)return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历（递归）
     * @param root
     */
    public static void inOrder(TreeNode root){
        if (root==null)return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    /**
     * 后序遍历（递归）
     * @param root
     */
    public static void postOrder(TreeNode root){
        if (root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    /**
     * 前序遍历（非递归）
     *
     * @param root
     */
    public static void preOrderNonRe(TreeNode root){
        // 因为遍历完中间节点之后，需要找到其左右节点，所以用一个栈进行暂存
        Stack<TreeNode> stack = new Stack<>();
        // 当前遍历的节点
        TreeNode cur = root;
        // 遍历结束的条件是：左右子树为空，并且栈也为空。所以只要不同时满足，就应该遍历。
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                // 打印当前节点（即：中间节点）
                System.out.print(cur.val);
                // 为了打印之后，能够再找到改节点的右子树，暂存该节点
                stack.push(cur);
                // 然后再是其左子树
                cur = cur.left;
            }
            // 进行到此，说明左子树已经为空，开始遍历右子树
            if (!stack.isEmpty()){
                // 弹出栈顶元素
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 中序遍历（非递归）
     * 根先序遍历类似，只是等到弹出栈的时候，再打印。
     * @param root
     */
    public static void inOrderNonRe(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()){
                cur = stack.pop();
                System.out.print(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历（非递归）
     * @param root
     */
    public static void postOrderNonRe(TreeNode root){

    }


    public static void main(String[] args) {
        inOrder(init());
        System.out.println();
        inOrderNonRe(init());
    }
}
