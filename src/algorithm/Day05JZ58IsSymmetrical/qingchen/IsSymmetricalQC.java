package algorithm.Day05JZ58IsSymmetrical.qingchen;

import algorithm.Day05JZ58IsSymmetrical.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Created by ChenJiaQiang on 2020/6/16 14:45
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetricalQC {
    /**
     * 我的思路：
     *      1、最开始想到的是死办法：先求一棵树的镜像，然后再遍历这两棵树，看看是不是一样的顺序。
     *      2、使用层次遍历，看看每一层是不是对称的结构？
     *
     *      特殊：false
     *            1
     *           / \
     *          2   2
     *           \   \
     *           3    3
     *      所以，需要把每一层填满。
     *
     *      下面的解答中，如果左右子树有null的，就用-1去填，牛客能通过，力扣不能，如果是节点中有-1的，就会出问题了。
     * @param root
     * @return
     */
    public static boolean isSymmetrical(TreeNode root) {
        int placeholder = -1;
        if (root==null)return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.val != placeholder){
                    if(t.left!=null) {
                        queue.add(t.left);
                    }else {
                        queue.add(new TreeNode(placeholder));
                    }
                    if(t.right!=null) {
                        queue.add(t.right);
                    }else {
                        queue.add(new TreeNode(placeholder));
                    }
                }
            }
            if (tmp.size()!=1 && tmp.size()%2!=0)return false;
            // 对每一层，判断是否是镜像的
            for (int i=0;i<tmp.size()/2;i++){
                if (!tmp.get(i).equals(tmp.get(tmp.size()-i-1))){
                    return false;
                }
            }
        }
        return true;
    }

    // 参考(分析很清晰)：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
    public static boolean isSymmetrical2(TreeNode root) {
        if (root==null)return true;
        return judge(root.left,root.right);
    }

    public static boolean judge(TreeNode left,TreeNode right){
        if (left==null&&right==null)return true;
        if (left==null||right==null)return false;
        if (left.val!=right.val)return false;
        return judge(left.left,right.right) && judge(left.right,right.left);
    }
}
