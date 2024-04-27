package tfl.chapter4;

import java.util.List;

public class Question29 {
    public static ListNode insert(ListNode node, int value) {
        // 特殊情况是 链表中原来只有0个节点或者1个节点
        ListNode listNode = new ListNode(value);
        if (node == null) {
            node = listNode;
        } else if (node.next == null) {
            node.next = listNode;
            listNode.next = node;
        } else {
            insertNode(node, listNode);
        }

        return node;
    }

    private static void insertNode(ListNode<Integer> node, ListNode<Integer> listNode) {
        ListNode<Integer> before = node;
        ListNode<Integer> after = node.next;
        ListNode<Integer> biggest = listNode;// 记录最大值指针
        while (!(before.value <= listNode.value && after.value > listNode.value) && after != listNode) {
            before = before.next;
            after = after.next;
            if (after.value >= biggest.value) {
                biggest = after;
            }
        }
        if (before.value <= listNode.value && after.value > listNode.value) {
            before.next = listNode;
            listNode.next = after;
        } else {
            biggest.next = listNode;
            listNode.next = after;
        }
    }
}
