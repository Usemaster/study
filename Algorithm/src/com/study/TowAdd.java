package com.study;
/*
* 给你两个非空 的链表，表示两个非负的整数。
* 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
* 请你将两个数相加，并以相同形式返回一个表示和的链表。
* 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
* */
public class TowAdd {


    public static void main(String[] args) {

        // 链表 1
        ListNode list1Node1 = new ListNode(2);
        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node3 = new ListNode(3);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        // 链表 2
        ListNode list2Node1 = new ListNode(5);
        ListNode list2Node2 = new ListNode(6);
        ListNode list2Node3 = new ListNode(4);
        ListNode list2Node4 = new ListNode(7);
        ListNode list2Node5 = new ListNode(8);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;
        list2Node3.next = list2Node4;
        list2Node4.next = list2Node5;

        ListNode resListNode = addTwoNumbers(list1Node1, list2Node1);

        listNodePrint(resListNode);

    }

    /**
     * 注意逆序
     * 注意引用类型
     *
     * @param listNode1 链表 1
     * @param listNode2 链表 2
     * @return listNode
     */
    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {

        // 这里一方面是为了提高可读性，一方面是为了保留原来的 listNode1（引用类型，修改 p 也会修改 l1 的值）
        // 保留 listNode1 是为了最后的返回，因为 p 会走到 listNode1 最后的结点，要返回的是头结点
        ListNode p = listNode1;
        ListNode q = listNode2;

        // addNum 表示十位的数，即表示进位
        int addNum = 0;

        // 直到 q.next == null
        while (q != null) {

            // 因为链表长度不一定相等，如果有一个到头，另一个不到头，则将到头链表的空的位置补 0
            if (p.next == null && q.next != null) {
                p.next = new ListNode(0);
            }
            if (p.next != null && q.next == null) {
                q.next = new ListNode(0);
            }

            // 真正的和
            int sumAll = addNum + p.val + q.val;
            p.val = sumAll % 10;

            // 下一次进位
            addNum = sumAll / 10;

            // 如果两个链表都到头了，且还有未处理的进位，则将进位挂在后面（即最后一个，即最高位）
            if (p.next == null && q.next == null && addNum != 0) {
                p.next = new ListNode(addNum);
            }

            p = p.next;
            q = q.next;
        }
        return listNode1;
    }

    /**
     * 递归打印
     *
     * @param listNode 需打印的链表
     */
    public static void listNodePrint(ListNode listNode) {

        if (listNode == null) {
            return;
        }

        if (listNode.next == null) {
            System.out.println(listNode.val);
            return;
        }

        System.out.println(listNode.val);
        listNodePrint(listNode.next);
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


