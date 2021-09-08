package com.study.test;

public class RemoveNode {


    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode listNode = removeKNode(5, 3, listNode1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeKNode(int length,int k,ListNode head){
        ListNode fast = head;
        for(int i = 1;i < k-1;i++){
            fast = fast.next;
        }
        fast.next = fast.next.next;
        return head;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
