package tfl.chapter4;

public class Question22 {
    // 判断是否有环 并且返回快慢指针相遇节点
    private static ListNode getNodeInLoop(ListNode list){
        if(list==null || list.next==null || list.value==null){
            return null;
        }
        // 先加一个哨兵节点
        ListNode head = new ListNode(0);
        head.next = list;

        // 使用两个指针一快一慢来解决
        ListNode slow =head.next;
        ListNode fast = slow.next;
        while(slow!=null && fast!=null){
           if(slow== fast){
               return slow;
           }
           slow = slow.next;
           fast = fast.next;
           if(fast.next!=null){
               fast = fast.next;
           }
            }
        return null;
        }

        // 返回环的首节点
        public  static  ListNode findLoop(ListNode head){
        if(head == null){return null;}
            ListNode listNode = getNodeInLoop(head);// 找到环中相遇节点
        ListNode flag = listNode.next;
        int count = 0;
        while(flag.next!=listNode){
            count++;
            flag=flag.next;
        }
        count++;// 环中节点的数量
        ListNode before = listNode;
        ListNode  back= listNode;
        // 前指针先走 N步，两指针之间差n-1个节点
        for(int a=0;a<count;a++){
            before = before.next;
        }
        // 因为本来差n-1个节点 当back走到环开始节点时，before本来应该走到的是环尾节点的下一个节点，但是有环，所以回到第一个环节点
        while(before!=back){
            before = before.next;
            back = back.next;
        }
        return  back;
        }

        // 第二种解法
        public static  ListNode detectCircle(ListNode head){
            ListNode listNode = getNodeInLoop(head);
            if(listNode ==null){
                return null;
            }
            //before在head节点 back在相遇节点 他们差了 n个节点，并且这个n是环的倍数，整圈数，before与back共同移动 当before走到环首节点时，back也在了首环节点，因为n是整圈
            ListNode before = head;
            ListNode back = listNode;
            while(before != back){
                before = before.next;
                back  = back.next;
            }
            return back;
        }

}
