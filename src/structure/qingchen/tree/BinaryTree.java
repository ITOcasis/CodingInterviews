package structure.qingchen.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left=node3;
        node1.right=node4;
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
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
     * 前序遍历-第二种方法（非递归）
     * @param root
     */
    public static void preOrderNonRe2(TreeNode root){
        if (root==null)return;
        // 因为遍历完中间节点之后，需要找到其左右节点，所以用一个栈进行暂存
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (temp!=null){
                System.out.print(temp.val);
                // 因为栈是先进后出，所以为了保证是前序遍历的顺序，先放入右节点
                if (temp.right!=null)stack.push(temp.right);
                if (temp.left!=null)stack.push(temp.left);
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
     * 中序遍历-第二种方法（非递归）
     * @param root
     */
    public static void inOrderNonRe2(TreeNode root){
        if (root==null)return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val);
            cur = cur.right;
        }
    }

    /**
     * 后序遍历（非递归）
     * 后序遍历在决定是否可以输出当前节点的值的时候，需要考虑其左右子树是否都已经遍历完成。
     * 所以需要设置一个lastVisit游标。
     * 若lastVisit等于当前考查节点的右子树，表示该节点的左右子树都已经遍历完成，则可以输出当前节点。
     * 并把lastVisit节点设置成当前节点，将当前游标节点node设置为空，下一轮就可以访问栈顶元素。
     * 否者，需要接着考虑右子树，node = node.right。
     * @param root
     */
    public static void postOrderNonRe(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisit = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            // 查看栈顶元素
            cur = stack.peek();
            // 如果其右子树为空，或者右子树已经访问
            // 则可以直接输出当前节点的值
            if (cur.right==null||cur.right==lastVisit){
                System.out.print(cur.val);
                stack.pop();
                lastVisit = cur;
                cur = null;
            }else {
                // 继续遍历右子树
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历-第二种方法（非递归）
     * @param root
     */
    public static void postOrderNonRe2(TreeNode root){
        if (root==null)return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left!=null)stack1.push(temp.left);
            if (temp.right!=null)stack1.push(temp.right);
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val);
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public static void level(TreeNode root){
        if (root==null)return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t = queue.remove();
            System.out.print(t.val.toString());
            if(t.left!=null) {
                queue.add(t.left);
            }
            if(t.right!=null) {
                queue.add(t.right);
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null)return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                System.out.print(t.val);
                temp.add((int)t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        level(init());
        System.out.println();
        System.out.println(levelOrder(init()).toString());
    }
}
