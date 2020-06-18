package structure.qingchen.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by ChenJiaQiang on 2020/6/18 14:39
 */
public class BinarySearchTree {
    public static class TreeNode<T> {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

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
        node6.left = new TreeNode(18);
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

    public static TreeNode tree;

    static {
        tree = init();
    }

    /**
     * 二叉查找树-查找（支持重复数据）
     * @param data
     * @return
     */
    public static List<TreeNode> find(int data){
        TreeNode cur = tree;
        List<TreeNode> findData = new ArrayList<>();
        while (cur!=null){
            if (cur.val == data){
                findData.add(cur);
                cur = cur.right;
            }
            if (cur!=null && cur.val<data){
                cur = cur.right;
            }
            if (cur!=null && cur.val>data){
                cur = cur.left;
            }
        }
        return findData;
    }

    /**
     * 二叉查找树-插入（支持重复数据）
     * @return
     */
    public static void insert(int data){
        if (tree == null){
            tree = new TreeNode(data);
        }
        TreeNode cur = tree;
        while (cur!=null){
            if (data>=cur.val){
                if (cur.right == null){
                    cur.right = new TreeNode(data);
                    return;
                }
                cur = cur.right;
            }
            if (data<cur.val){
                if (cur.left == null){
                    cur.left = new TreeNode(data);
                    return;
                }
                cur = cur.left;
            }
        }

    }

    /**
     * 二叉查找树-删除（支持重复数据）
     * @param data
     */
    public static void delete(int data){
        // 当前结点
        TreeNode cur = tree;
        // 上一个结点
        TreeNode lastNode = tree;
        while (cur!=null){
            if (cur.val == data){
                // 没有子结点
                if (cur.left==null && cur.right == null){
                    // 因为不知道 cur 结点是 lastNode 结点的左孩子还是右孩子
                    if (lastNode.left == cur){
                        lastNode.left = null;
                    }else {
                        lastNode.right = null;
                    }
                }else if ((cur.left==null && cur.right != null) || (cur.left!=null && cur.right == null)){
                    // 只有一个子结点
                    if (cur.left!=null){
                        TreeNode temp = cur.left;
                        lastNode.left = temp;
                        cur = temp;
                    }else {
                        TreeNode temp = cur.right;
                        lastNode.right = temp;
                        cur = temp;
                    }
                }else {
                    // 有两个子结点。找到右子树中最小的结点，替换。
                    TreeNode miniNode = cur.right;
                    // 最小结点的父结点
                    TreeNode miniNodeParent = cur;
                    while (miniNode.left!=null){
                        miniNodeParent = miniNode;
                        miniNode = miniNode.left;
                    }
                    // 到这，已经找到了右子树中最小的结点
                    miniNodeParent.left = null;
                    cur.val = miniNode.val;
                }
                // 删除了一个结点，需要重新判断下一个查找的结点位置
                if (cur.val<data){
                    lastNode = cur;
                    cur = cur.right;
                }else {
                    lastNode = cur;
                    cur = cur.left;
                }
            }else if (cur!=null && cur.val<data){
                lastNode = cur;
                cur = cur.right;
            }else if (cur!=null && cur.val>data){
                lastNode = cur;
                cur = cur.left;
            }
        }
    }


    public static void main(String[] args) {
//        insert(18);
//        List<TreeNode> treeNodes = find(25);
//        treeNodes.stream().forEach(treeNode -> {
//            System.out.println(treeNode.val);
//        });
        level(tree);
        System.out.println();
        delete(18);
        level(tree);
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
            System.out.print(t.val + "  ");
            if(t.left!=null) {
                queue.add(t.left);
            }
            if(t.right!=null) {
                queue.add(t.right);
            }
        }
    }
}
