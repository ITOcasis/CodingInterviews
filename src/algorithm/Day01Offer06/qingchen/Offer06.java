package algorithm.Day01Offer06.qingchen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by ChenJiaQiang on 2021/2/19 16:10
 * <p>
 * 剑指 Offer 06. 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * <p>
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Offer06 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode init() {
        ListNode root = new ListNode(1);

        ListNode node1 = new ListNode(3);

        root.next = node1;

        ListNode node2 = new ListNode(2);

        node1.next = node2;

        return root;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reversePrint1(init())));
        System.out.println(Arrays.toString(reversePrint2(init())));
        System.out.println(Arrays.toString(reversePrint3(init())));
        System.out.println(Arrays.toString(reversePrint4(init())));
    }

    /**
     * 冒出的第一个解法：
     * 用栈这个结构来解决
     *
     * @param head
     * @return
     */
    public static int[] reversePrint1(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        Stack<Integer> stack = new Stack<>();
        // 遍历链表，用栈存储
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        // 新建数组，遍历栈
        int[] res = new int[stack.size()];
        int total = stack.size();
        for (int i = 0; i < total; i++) {
            Integer data = stack.pop();
            res[i] = data;
        }
        return res;
    }

    /**
     * 在解法1中，用到了栈增加了额外的存储
     * <p>
     * 网上的解法1：递归，先走到最后一个节点，然后回溯时，添加节点
     */
    public static List<Integer> list = new ArrayList<>();

    public static int[] reversePrint2(ListNode head) {
        revise2Function(init());
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public static void revise2Function(ListNode head) {
        if (head == null) {
            return;
        }
        revise2Function(head.next);
        list.add(head.val);
    }

    /**
     * 上面的递归中,额外用到了list,增加了存储
     * 然后还需要遍历list,接下来把list优化掉
     */

    public static int[] res;
    // 数组的下标
    public static int resIndex = 0;
    // 遍历到的链表下标
    public static int curIndex = 0;

    public static int[] reversePrint3(ListNode head) {
        revise3Function(init());
        return res;
    }


    public static void revise3Function(ListNode head) {
        if (head == null) {
            // 到这,说明链表遍历完了,可以初始化数组了,curIndex就是数组长度
            res = new int[curIndex];
            return;
        }
        curIndex++;
        revise3Function(head.next);
        res[resIndex] = head.val;
        resIndex++;
    }

    /**
     * 还有一种解法,先遍历链表一次,获取长度后,初始化数组
     * 然后再遍历链表一次,从数组末尾开始赋值
     */

    public static int[] reversePrint4(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
