package algorithm.Day03JZ60Print.qingchen;

import algorithm.Day03JZ60Print.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * @author Created by ChenJiaQiang on 2020/6/14
 * Day03 2020/6/14  牛客网，剑指offer，JZ39，把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288
 */
public class PrintQC {
    /**
     * 我的思路：二叉树的层次遍历，需要用到队列。普通的List，通过remove(index)的方式不行，因为i会变化，而不是一直指向最前面一个元素。
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null)return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (queue.size()>0){
            ArrayList<Integer> tmp = new ArrayList<>();
            // 某一层的节点个数
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode remove = queue.remove();
                tmp.add(remove.val);
                if (remove.left!=null)queue.add(remove.left);
                if (remove.right!=null)queue.add(remove.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
