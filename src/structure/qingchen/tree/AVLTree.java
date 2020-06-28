package structure.qingchen.tree;

/**
 * @author Created by ChenJiaQiang on 2020/6/23 17:27
 * 平衡二叉树
 */
public class AVLTree {
    /**
     * 定义树结点的结构
     * @param <T>
     */
    public static class TreeNode<T> {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        int height;//当前结点的高度

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 获取当前结点的高度
     * @param node
     * @return
     */
    private static int height(TreeNode node){
        return node==null?-1:node.height;
    }

    /**
     * 获取当前结点的平衡因子
     * @param node
     * @return
     */
    private static int getBalance(TreeNode node){
        return node==null?0:height(node.left) - height(node.right);
    }

    /**
     * 更新结点高度
     * @param node
     */
    private static void updateHeight(TreeNode node){
        node.height = Math.max(height(node.left),height(node.right))+1;
    }

    /**
     * 初始化一棵树
     *                    11
     *           4                 13
     *     2         9          12     14
     *   1   3     7   10                15
     * @return
     */
    public static TreeNode init(){
        TreeNode root = new TreeNode(11);
        root.height = 0;
        TreeNode n1 = new  TreeNode(4);
        n1.height = 0;
        TreeNode n2 = new TreeNode(13);
        n2.height = -1;
        root.left = n1;
        root.right = n2;
        TreeNode n3 = new TreeNode(2);
        n3.height = 0;
        TreeNode n4 = new TreeNode(9);
        n4.height = 0;
        n1.left = n3;
        n1.right = n4;
        TreeNode n5 = new TreeNode(14);
        n5.height = -1;
        TreeNode n11 = new TreeNode(12);
        n11.height = 0;
        n2.right = n5;
        n2.left = n11;
        TreeNode n6 = new TreeNode(1);
        n6.height = 0;
        TreeNode n7 = new TreeNode(3);
        n7.height = 0;
        n3.left = n6;
        n3.right = n7;
        TreeNode n8 = new TreeNode(7);
        n8.height = 0;
        TreeNode n9 = new TreeNode(10);
        n9.height = 0;
        n4.left = n8;
        n4.right = n9;
        TreeNode n10 = new TreeNode(15);
        n10.height = 0;
        n5.right = n10;
        return root;
    }

    private static TreeNode tree;

    static {
        tree = init();
    }

    /**
     * 插入
     * @param data
     */
    private static TreeNode insert(TreeNode root , int data){
        // 一、如果节点为空，当前插入的是根节点
        if (root==null){
            root = new TreeNode(data);
        }
        // 二、插入，判断是插入根结点的左子树还是右子树
        if (data<root.val){  // 插入到左子树
            // 递归调用
            root.left = insert(root.left,data);
        }
        if (data>root.val){  // 插入到右子树
            // 递归调用
            root.right = insert(root.right,data);
        }
        // 三、更新当前节点的高度
        updateHeight(root);
        // 四、获取父节点的平衡因子
        int balance = getBalance(root);
        // 五、判断是否需要旋转操作，有四种情况
        // 1.左左局面，右旋 (只有当插入的结点，是当前结点的左子树时，才有可能造成左左局面)
        if (balance>1 && data<root.left.val){
            return rightRotate(root);
        }
        // 2.右右局面，左旋
        if (balance<-1 && data>root.left.val){
            return leftRotate(root);
        }
        // 3.左右局面，左旋，变成左左局面，再右旋
        if (balance>1 && data>root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // 4.右左局面，右旋，变成右右局面，再左旋
        if (balance<-1 && data<root.left.val){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    /**
     * 右旋
     * @param node
     * @return
     */
    private static TreeNode rightRotate(TreeNode node){
        // 一、旋转操作
        // 1.获取新的根结点
        TreeNode newRoot = node.left;
        // 2.获取新的根结点的右结点，拼接到原来根结点的左结点
        TreeNode newRootRight = newRoot.right;
        // 3.旋转
        newRoot.right = node;
        node.left = newRootRight;
        // 更新结点高度
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    /**
     * 左旋
     * @param node
     * @return
     */
    private static TreeNode leftRotate(TreeNode node){
        // 一、旋转操作
        // 1.获取新的根结点
        TreeNode newRoot = node.right;
        // 2.获取新的根结点的左结点，拼接到原来根结点的右结点
        TreeNode newRootRight = newRoot.left;
        // 3.旋转
        newRoot.left = node;
        node.right = newRootRight;
        // 更新结点高度
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    /**
     * 前序遍历（递归）
     * @param root
     */
    private static void preOrder(TreeNode root){
        if (root==null)return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 删除
     * 涉及到两个关键点：
     *                  1）被删除节点的空缺应该如何填补
     *                  2）删除后如何使树恢复平衡
     * @param root
     * @param data
     * @return
     */
    private static TreeNode delete(TreeNode root,int data){
        // 一、如果节点为空，直接返回null
        if (root==null)return null;
        // 二、删除，判断要删除的结点是根结点的左子树还是右子树
        if (data<root.val){  // 从左子树查找并删除
            root.left = delete(root.left,data);
        }
        if (data>root.val){  // 从右子树查找并删除
            root.right = delete(root.right,data);
        }
        if (data == root.val){  // 找到了要删除的结点
            // 删除节点有两个孩子
            if (root.left != null && root.right != null) {
                // 找到右子树中最小的结点，替换
                root.val = findMin(root.right);
                // 删除已经成功替换的结点
                root.right = delete(root.right, root.val);
            } else {
                // 删除节点只有一个孩子或者没有孩子
                root = (root.left != null) ? root.left : root.right;
            }
        }
        // 同插入一样，维持平衡性
        if (root==null)return null;
        // 三、更新当前节点的高度
        updateHeight(root);
        // 四、获取父节点的平衡因子
        int balance = getBalance(root);
        // 五、判断是否需要旋转操作，有四种情况
        // 1.左左局面，右旋 (只有当插入的结点，是当前结点的左子树时，才有可能造成左左局面)
        if (balance>1 && data<root.left.val){
            return rightRotate(root);
        }
        // 2.右右局面，左旋
        if (balance<-1 && data>root.left.val){
            return leftRotate(root);
        }
        // 3.左右局面，左旋，变成左左局面，再右旋
        if (balance>1 && data>root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // 4.右左局面，右旋，变成右右局面，再左旋
        if (balance<-1 && data<root.left.val){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    /**
     * 获取结点及其子树中最小的值
     * @param node
     * @return
     */
    private static int findMin(TreeNode node){
        if (node.left == null){
            return node.val;
        }else {
            return findMin(node.left);
        }
    }

    public static void main(String[] args) {
        delete(tree,12);
        preOrder(tree);
    }

}
