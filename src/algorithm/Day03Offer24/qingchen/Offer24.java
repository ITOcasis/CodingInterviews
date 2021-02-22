package algorithm.Day03Offer24.qingchen;

/**
 * @author Created by ChenJiaQiang on 2021/2/22 17:10
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer24 {
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode init() {
        ListNode root = new ListNode(1);

        ListNode node1 = new ListNode(2);

        root.next = node1;

        ListNode node2 = new ListNode(3);

        node1.next = node2;

        ListNode node3 = new ListNode(4);

        node2.next = node3;

        ListNode node4 = new ListNode(5);

        node3.next = node4;

        return root;
    }

    public static void main(String[] args) {
        ListNode listNode = reverseList2(init());
        System.out.println(listNode);
    }

    public static ListNode node;
    public static ListNode resNode;

    /**
     * 首先想到了递归的解法，找到最后一个节点，在回溯时，依次反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        reverseList1Function(head);
        return resNode;
    }

    public static void reverseList1Function(ListNode head) {
        if (head == null) {
            return;
        }
        reverseList1Function(head.next);
        if (node == null) {
            node = new ListNode(head.val);
            resNode = node;
        } else {
            node.next = new ListNode(head.val);
            node = node.next;
        }
    }


    /**
     * 在上面的方法中，用到了两个ListNode。
     * 尝试用双指针法解题。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        // 第一个节点的前置节点为null
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 暂存当前节点的下一个节点（以及后续节点的引用关系）
            ListNode temp = cur.next;
            // 改变当前节点的指向（改为向前）
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
