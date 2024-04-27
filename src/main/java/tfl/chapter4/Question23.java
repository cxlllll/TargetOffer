package tfl.chapter4;

public class Question23 {
    public static int countListLength(ListNode list) {
        if (list == null) {
            return 0;
        }
        ListNode indexNode = list;
        int count = 0;
        while (indexNode != null) {
            count++;
            indexNode = indexNode.next;
        }
        return count;
    }

    // 找出两个数组中第一个公共的节点
    public static ListNode getTwoListsFirstPublicNode(ListNode list1, ListNode list2) {
        // 得到链表1的长度与数组链表2的长度。
        int count1 = countListLength(list1);
        int count2 = countListLength(list2);
        if (count1 == 0 || count2 == 0) {
            return null;
        }
        // 先让短的节点先走 count长-count短个位置，因为 他们公共的部分是在两个链表的尾部，只需要将一个指针从长的先走（长度差）个，然后新加指针从头开始，两个指针同时同步向下走
        int dValue = count1 > count2 ? count1 - count2 : count2;
        ListNode before = count1 >= count2 ? list1 : list2; // 指针指向长的链表
        ListNode after = count1 > count2 ? list2 : list1;// 指针指向短的链表
        for (; dValue > 0; dValue--) {
            before = before.next;
        }
        while (before != null && after != null) {
            if (before == after) {
                return after;
            }
            before = before.next;
            after = after.next;
        }
        return null;

    }
}
