package algorithm.Day06JZ22PrintFromTopToBottom.qingchen;

import algorithm.Day06JZ22PrintFromTopToBottom.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Created by ChenJiaQiang on 2020/6/17 11:50
 */
public class PrintFromTopToBottomQC {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null)return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            list.add(temp.val);
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }
        return list;
    }
}
