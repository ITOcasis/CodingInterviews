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
     * 遇到的问题：① 每一层的各个节点，如何关联上对应的父节点？
     */
    public void Mirror(TreeNode root) {
        if (root==null)return;
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        while (temp.size()>0){
            for (int i=0;i<temp.size();i++){
                TreeNode removeNode = temp.remove(i);
                if (removeNode==null)continue;
                temp.add(removeNode.left);
                temp.add(removeNode.right);
            }
            // 到这，temp中都是同一级的节点

        }
    }
}
