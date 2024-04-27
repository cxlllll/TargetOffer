package tfl.chapter4;

public class Question24 {
    // 反转链表 借助三个指针
    public static  ListNode reverseList(ListNode list){
        if(list==null || list.next==null){
            return list;
        }
        ListNode firstPointer = list;
        ListNode secondPointer = list.next;
        firstPointer.next = null;
        ListNode thirdPointer = secondPointer.next;
        while(secondPointer !=null ){
            secondPointer.next = firstPointer;
            firstPointer = secondPointer;
            secondPointer = thirdPointer;
            if(thirdPointer != null){
                thirdPointer = thirdPointer.next;
            }
        }
        return firstPointer;
    }

    // 官方写法
    public static ListNode standardReverseList(ListNode list){
        ListNode prev= null;// 记录前一节点，最开始是null
        ListNode cur =list;// 记录要反转的当前节点
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur=next;
        }
        return  prev;
    }

    public static void main(String[] args) {
        ListNode<Integer> head=new ListNode<>(1);
        ListNode<Integer> head1=new ListNode<>(2);
//        ListNode<Integer> head2=new ListNode<>(3);
//        ListNode<Integer> head3=new ListNode<>(4);
//        ListNode<Integer> head4=new ListNode<>(5);
//        ListNode<Integer> head5=new ListNode<>(6);
//        ListNode<Integer> head6=new ListNode<>(7);
        head.setNext(head1);
//        head1.setNext(head2);
//        head2.setNext(head3);
//        head3.setNext(head4);
//        head4.setNext(head5);
//        head5.setNext(head6);
        ListNode listNode = reverseList(head);
        System.out.println(listNode);

    }
}
