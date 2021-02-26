package algorithm.Day04Offer18.qingchen;

/**
 * @author Created by ChenJiaQiang on 2021/2/24 14:19
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer18 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode init() {
        ListNode root = new ListNode(4);

        ListNode node1 = new ListNode(5);

        root.next = node1;

        ListNode node2 = new ListNode(1);

        node1.next = node2;

        ListNode node3 = new ListNode(9);

        node2.next = node3;

        /*ListNode node4 = new ListNode(5);

        node3.next = node4;*/

        return root;
    }

    public static void main(String[] args) {
        ListNode listNode = deleteNodeRe(init(), 1);
        System.out.println(listNode);
    }

    public static ListNode deleteNodeRe(ListNode head, int val) {

        return null;
    }


    /**
     * 一开始的想法是
     * 弄一个新链表，保存要删除节点之前的节点
     * 当遍历到要删除的节点时
     * 要删除之前的节点链表.next = 当前遍历的节点.next
     * 但是，遇到的问题是，新链表的指向总是出问题
     * 下面是错误的解题
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode res = new ListNode(head.val);
        while (head != null) {
            if (head.val == val) {
                res.next = head.next;
            }
            res.next = head;
            res = res.next;
            head = head.next;
        }
        return res;
    }

    /**
     * 在上面的基础上，又增加一个链表
     * 用来维护res的指向关系
     * 但我对这种方法不满意
     * 结果还是错的，实在不会了
     * 准备学习下网上的解答
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode1(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode res = new ListNode(head.val);
        ListNode keepRes = null;
        head = head.next;
        while (head != null) {
            if (head.val == val) {
                res.next = head.next;
                break;
            }
            res.next = new ListNode(head.val);
            if (keepRes == null) {
                keepRes = res;
            } else {
                keepRes.next = res;
            }
            res = res.next;
            head = head.next;
        }
        return keepRes;
    }

    /**
     * 下面是网上的解法，思路跟我想的都是一样的
     * 没想到的是，竟然返回head
     * 说明我对java的引用这块还不理解
     * 去补补
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode2(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }


}
