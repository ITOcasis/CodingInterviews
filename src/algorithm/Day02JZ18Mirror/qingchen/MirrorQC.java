package algorithm.Day02JZ18Mirror.qingchen;

import algorithm.Day02JZ18Mirror.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Created by ChenJiaQiang on 2020/6/13
 */
public class MirrorQC {
    /**
     * 我的思路：使用二叉树的层次遍历，对每一层的节点进行镜像的操作
     * 遇到的问题：① 每一层的各个节点，如何关联上对应的父节点？(直接交换，节点之间的引用，不会断)
     * 正解思路：递归，交换左右子树。我一直想着，如果交换左右子树的话，剩下的下面的节点，会不会丢失关联。
     */
    public static void Mirror(TreeNode root) {
        if (root==null)return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 在我的思路基础上，继续想想，写出非递归的代码
     */
    public static void MirrorNoRe(TreeNode root){
        if (root==null)return;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size()>0){
            for (int i=0;i<list.size();i++){
                TreeNode remove = list.remove(i);
                if (remove==null)continue;
                TreeNode temp = remove.left;
                remove.left = remove.right;
                remove.right = temp;
                list.add(remove.left);
                list.add(remove.right);
            }
        }
    }
}
