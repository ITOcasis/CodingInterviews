package algorithm.Day09JZ24FindPath.qingchen;

import algorithm.Day09JZ24FindPath.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Created by ChenJiaQiang on 2020/6/19 17:27
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathQC {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 我的思路：没有思路......列举出从根结点到叶子结点的每一种路径？如何实现每条路径都计算了？
     * 参考：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        preOrder(root,target);
        return res;
    }

    public static void preOrder(TreeNode node,int tar){
        if (node==null)return;
        path.add(node.val);
        tar = tar - node.val;
        if (node.left==null && node.right==null && tar == 0){
            res.add(new ArrayList<>(path));
        }
        preOrder(node.left,tar);
        preOrder(node.right,tar);
        path.removeLast();
    }
}
