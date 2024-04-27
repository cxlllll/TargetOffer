package tfl.chapter4;

public class Question28 {
    public static ListNodeWithSubList expandList(ListNodeWithSubList list) {
        getTail(list);
        return list;
    }

    private static ListNodeWithSubList getTail(ListNodeWithSubList list) {
        ListNodeWithSubList head = list;
        ListNodeWithSubList tail = null;
        while (head != null) {
            ListNodeWithSubList next = head.next;// 因为如果有子链表 将会该改变链接 所以next节点需要提前保存 不然就找不到了
            if (head.subList != null) {
                ListNodeWithSubList subHead = head.subList;
                ListNodeWithSubList childTail = getTail(head.subList);
                head.subList = null;// 切断联系
                head.next = subHead;
                subHead.before = head;
                childTail.next = next;
                if (next != null) {
                    next.before = childTail;
                }
                tail = childTail;
            } else {
                tail = head;
            }
            head = next;
        }
        return tail;
    }

    private static ListNodeWithSubList getTailMySelf(ListNodeWithSubList head) {
        // 首先保留 外层循环需要用的
        ListNodeWithSubList list = head;
        ListNodeWithSubList tail = null;
        ListNodeWithSubList nextNode = null;
        while (list != null) {
            nextNode = head.next;
            //有子链表 就递归
            if (list.subList != null) {
                // 子链head
                ListNodeWithSubList subHead = list.subList;
                ListNodeWithSubList childTail = getTailMySelf(list.subList);
                // 有子链 当前的head就需要与子链的head链接
                list.subList = null;
                head.next = subHead;
                subHead.before = list;
                childTail.next = nextNode;
                if (nextNode != null) {
                    nextNode.before = childTail;
                }
                tail = childTail;
            } else {
                tail = list;
            }
            list = nextNode;
        }
        return tail;
    }
}
