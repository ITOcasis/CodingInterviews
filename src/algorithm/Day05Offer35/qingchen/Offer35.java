package algorithm.Day05Offer35.qingchen;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by ChenJiaQiang on 2021/2/25 14:18
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer35 {
    public static class Node {

        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node init() {
        Node root = new Node(4);

        Node node1 = new Node(5);

        root.next = node1;

        Node node2 = new Node(1);

        node1.next = node2;

        Node node3 = new Node(9);

        node2.next = node3;

        /*ListNode node4 = new ListNode(5);

        node3.next = node4;*/

        return root;
    }

    public static void main(String[] args) {

    }

    private static Node copyRandomListRe(Node head) {

        return null;
    }


    /**
     * 题目都看不懂...
     * 链表的复制？
     * 直接看解答了...
     * <p>
     * 看了下解析，以及把普通的链表复制写了一下
     * 其实就是链表的复制
     *
     * @param head
     * @return
     */
    private static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> dic = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            dic.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            dic.get(cur).next = dic.get(cur.next);
            dic.get(cur).random = dic.get(cur.random);
            cur = cur.next;
        }
        return dic.get(head);
    }
}
