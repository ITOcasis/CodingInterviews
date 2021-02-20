package algorithm.Day02Offer22.qingchen;

/**
 * @author Created by ChenJiaQiang on 2021/2/20 10:51
 * <p>
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 */
public class Offer22 {

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
        ListNode kthFromEnd1 = getKthFromEnd1(init(), 2);
        System.out.println(kthFromEnd1);
        ListNode kthFromEnd2 = getKthFromEnd2(init(), 2);
        System.out.println(kthFromEnd2);
        ListNode kthFromEnd3 = getKthFromEnd3(init(), 2);
        System.out.println(kthFromEnd3);
    }


    /**
     * 最开始想到的常规解法:
     * <p>
     * 先获取链表的长度,然后就可以从头到尾遍历到所需位置
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int j = size - k;
        for (int i = 1; i <= j; i++) {
            head = head.next;
        }
        return head;
    }


    /**
     * 还可以使用双指针法(快慢指针)
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode getKthFromEnd2(ListNode head, int k) {
        int fast = 0;
        ListNode fastNode = head;
        while (fastNode != null && fast != k) {
            fast++;
            fastNode = fastNode.next;
        }
        // 到这慢指针也应该开始走了
        while (fastNode != null) {
            fastNode = fastNode.next;
            head = head.next;
        }
        return head;
    }

    /**
     * 优化一下双指针法,没必要两次while
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode fastNode = head;
        int index = 0;
        while (fastNode != null) {
            if (index >= k) {
                head = head.next;
            }
            index++;
            fastNode = fastNode.next;
        }
        return head;
    }

}
