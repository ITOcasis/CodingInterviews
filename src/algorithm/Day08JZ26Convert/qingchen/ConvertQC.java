package algorithm.Day08JZ26Convert.qingchen;

import algorithm.Day08JZ26Convert.TreeNode;

import java.util.Stack;

/**
 * @author Created by ChenJiaQiang on 2020/6/19 10:14
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertQC {
    /**
     * 我的思路：“不能创建任何新的结点”。采用中序遍历，弄几个变量，分别指向当前节点的上一个结点，在遍历的时候，就调整位置.
     * 非递归的方式看着挺复杂，其实就是递归的模板。下面再写下递归版。
     * @param root
     * @return
     */
    public static TreeNode Convert(TreeNode root) {
        if (root==null)return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (last!=null) {
                // 上一个结点指向当前结点
                last.right = cur;
                // 当前结点指向上一个结点
                cur.left = last;
            }
            last = cur;
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
        // 返回第一个结点
        cur = root;
        while (cur.left!=null){
            cur = cur.left;
        }
        return cur;
    }

    public static TreeNode lastNode = null;

    public static TreeNode Convert2(TreeNode root) {
        inOrderConvert(root);
        // 返回第一个结点
        while (root!=null && root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static void inOrderConvert(TreeNode node){
        if (node==null)return;
        inOrderConvert(node.left);
        // 当前结点的上一个结点
        node.left = lastNode;
        if (lastNode!=null){
            // 上一个结点的下一个结点
            lastNode.right = node;
        }
        // 更新 lastNode
        lastNode = node;
        inOrderConvert(node.right);
    }
}
