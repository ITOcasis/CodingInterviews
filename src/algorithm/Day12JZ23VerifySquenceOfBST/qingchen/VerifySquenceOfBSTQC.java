package algorithm.Day12JZ23VerifySquenceOfBST.qingchen;

/**
 * @author Created by ChenJiaQiang on 2020/6/23 14:41
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBSTQC {
    /**
     * 我的思路：1）应该是有某种规律，只给个后序遍历，也不会重建一棵二叉搜索树。
     *          2）二叉搜索树是由规律的，如果只给个后序遍历，也能够重建一棵二叉搜索树。
     *          3）解题思路:
     *                  1）找到数组最后一个元素，即为根结点
     *                  2）遍历数组，如果比根结点小，就是根结点的左子树，直到找出左右子树的边界
     *                  3）找到边界之后，继续遍历，如果发现还有比根结点小的，直接返回false
     *                  4）边界清晰后，递归，重复上述过程
     * 按照设想的思路，写代码解题，发现有点问题，递归调用左右子树的时候，边界的值，会随着上一次的递归而改变。
     * 尝试了一下之后，看了下标准的思路，我想的还是没问题的，大体上一致，采用分治递归。
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySequenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return verify(sequence,0,sequence.length-1);
    }

    static boolean verify(int [] sequence,int left,int right){
        if (left>=right){
            return true;
        }
        // 根结点
        int root = sequence[right];
        // 找到左右子树的分界
        int i=0;
        for (i=left;i<right;i++){
            if (sequence[i]>root){
                break;
            }
        }
        // 在右子树中继续判断是否右小于根结点的值，如果有，直接返回false
        for (int j=i;j<right;j++){
            if (sequence[j]<root){
                return false;
            }
        }
        return verify(sequence,left,i-1) && verify(sequence,i,right-1);
    }
}
