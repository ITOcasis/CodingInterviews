package algorithm.Day06Offer52.qingchen;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Created by ChenJiaQiang on 2021/2/26 15:00
 * 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class Offer52 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode init() {
        ListNode root = new ListNode(4);

        ListNode node1 = new ListNode(1);

        root.next = node1;

        ListNode node2 = new ListNode(8);

        node1.next = node2;

        ListNode node3 = new ListNode(4);

        node2.next = node3;

        ListNode node4 = new ListNode(5);

        node3.next = node4;

        return root;
    }

    public static ListNode init2() {
        ListNode root0 = new ListNode(5);

        ListNode root = new ListNode(0);

        root0.next = root;

        ListNode node1 = new ListNode(2);

        root.next = node1;

        ListNode node2 = new ListNode(9);

        node1.next = node2;

        ListNode node3 = new ListNode(5);

        node2.next = node3;

        ListNode node4 = new ListNode(6);

        node3.next = node4;

        return root0;
    }

    public static void main(String[] args) {
        ListNode intersectionNode = getIntersectionNode2(init(), init2());
        System.out.println(intersectionNode);
    }

    /**
     * 一开始没有想到解题方法，只是模糊的感觉，要遍历，都用list
     * 然后看了下解析，可以用set来做，便知道如何解题了
     * 注意：是用Set保存整个ListNode节点，而不是单纯的值！！！
     *
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 继续尝试学习其他解法
     * 统计两个链表的长度，然后让长一点的链表，先遍历。
     * 直到两个链表长度一致，再同时遍历。
     * 这种不需要额外的存储，也不需要像上面一样
     * 判断是否存在set中，所以时间复杂度好很多。
     *
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = nodeLen(headA);
        int lenB = nodeLen(headB);
        while (lenA != lenB) {
            if (lenA > lenB) {
                headA = headA.next;
                lenA--;
            } else {
                headB = headB.next;
                lenB--;
            }
        }
        // 到这，长度一致了，然后同时遍历比较
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        // 到这，要么相等退出，要么走到null相等，退出
        return headA;
    }

    private static int nodeLen(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            len++;
            listNode = listNode.next;
        }
        return len;
    }

    /**
     * 最后一种是双指针法
     * 具体的分析见解析
     *
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
