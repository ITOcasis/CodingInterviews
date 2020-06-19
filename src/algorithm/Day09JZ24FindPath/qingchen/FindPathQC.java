package algorithm.Day09JZ24FindPath.qingchen;

import algorithm.Day09JZ24FindPath.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Created by ChenJiaQiang on 2020/6/19 17:27
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathQC {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static Stack<TreeNode> path = new Stack<>();

    /**
     * 我的思路：没有思路......列举出从根结点到叶子结点的每一种路径？如何实现每条路径都计算了？
     *
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
        path.push(node);
        tar = tar - node.val;
        if (node.left==null && node.right==null && tar == 0){
            ArrayList<Integer> curPath = new ArrayList<>(path.size());
            Stack<TreeNode> temp = path;
            while (!temp.isEmpty()){
                curPath.add(temp.pop().val);
            }
            res.add(curPath);
        }else if (node.left==null && node.right==null && tar!=0){
            TreeNode pop = path.pop();
            tar += pop.val;
        }
        preOrder(node.left,tar);
        preOrder(node.right,tar);
    }
}
