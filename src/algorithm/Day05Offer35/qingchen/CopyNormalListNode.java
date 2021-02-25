package algorithm.Day05Offer35.qingchen;

/**
 * @author Created by ChenJiaQiang on 2021/2/25 15:10
 * 补充一个基础：复制一个链表
 */
public class CopyNormalListNode {

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

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        printListNode(copyListNode1(init()));
    }

    private static ListNode copyListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode(head.val);
        }
        ListNode pre = new ListNode(head.val);
        ListNode keepPre = pre;
        head = head.next;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            pre.next = node;
            pre = node;
            head = head.next;
        }
        return keepPre;
    }


    private static ListNode copyListNode1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new ListNode(head.val);
        }
        ListNode pre = new ListNode(0);
        ListNode keepPre = pre;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            pre.next = node;
            pre = node;
            head = head.next;
        }
        return keepPre.next;
    }
}
