package algorithm.Day07JZ57GetNext.qingchen;

import algorithm.Day07JZ57GetNext.TreeLinkNode;

import java.util.Stack;

/**
 * @author Created by ChenJiaQiang on 2020/6/18 10:04
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextQC {

    /**
     * 题目入参给的是这棵树中的某个结点，找出这个结点，在中序遍历顺序的下一个结点
     * 我的思路：找到根结点，再中序遍历。
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        boolean isNext = false;
        TreeLinkNode root = pNode;
        while (root.next!=null){
            root = root.next;
        }
        // 到这，root为根结点
        Stack<TreeLinkNode> stack = new Stack<>();
        TreeLinkNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeLinkNode temp = stack.pop();
            if (isNext){
                return temp;
            }
            if (temp.val == pNode.val){
                // 找到了当前结点，返回其下一个结点即可
                isNext = true;
            }
            cur = temp.right;
        }
        return null;
    }

}
