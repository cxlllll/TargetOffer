package tfl.chapter4;

import java.util.List;

public class Question25 {
    // 反转链表
    private static  ListNode reverseList(ListNode head){
        if(head ==null ||  head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode listNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = listNode;
        }
        return  prev;
    }

    // 将两个链表的数字相加
    public  static ListNode addNumberInListNode(ListNode<Integer> list1,ListNode<Integer> list2){
        // 1.先反转链表 因为从末位相加 需要进位
        ListNode<Integer> revList1= reverseList(list1);
        ListNode<Integer> revList2= reverseList(list2);
        // 2.对应的相同位置的两个链表的节点value相加得到当前的位的值
        ListNode newList = new ListNode();
        ListNode reverseResult = newList;
        int addbit = 0;// 进位
        while(revList1!=null || revList2 !=null){
            int curValueSum =(revList1==null?0:revList1.getValue())+ (revList2==null?0:revList2.value)+addbit;
            int curValue = curValueSum>=10? curValueSum-10:curValueSum;
            addbit = curValueSum>=10?1:0;
            reverseResult.setNext(new ListNode(curValue));
            revList1= revList1==null?null:revList1.next;
            revList2= revList2==null?null:revList2.next;
            reverseResult = reverseResult.next;
        }
        if(addbit>0){
            reverseResult.setNext(new ListNode<>(addbit));
        }
        return reverseList(newList);
    }

    public static void main(String[] args) {
        ListNode<Integer> head=new ListNode<>(1);
        ListNode<Integer> head1=new ListNode<>(2);
        ListNode<Integer> head2=new ListNode<>(3);
        ListNode<Integer> head3=new ListNode<>(4);
        ListNode<Integer> head4=new ListNode<>(5);
        ListNode<Integer> head5=new ListNode<>(6);
        ListNode<Integer> head6=new ListNode<>(7);
        head.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head4);
        head4.setNext(head5);
        head5.setNext(head6);

        ListNode<Integer> head11=new ListNode<>(1);
        ListNode<Integer> head12=new ListNode<>(2);
        ListNode<Integer> head22=new ListNode<>(3);
        ListNode<Integer> head32=new ListNode<>(4);
        ListNode<Integer> head42=new ListNode<>(5);
        ListNode<Integer> head52=new ListNode<>(6);
        ListNode<Integer> head62=new ListNode<>(7);
        head11.setNext(head12);
        head12.setNext(head22);
        head22.setNext(head32);
        head32.setNext(head42);
        head42.setNext(head52);
        head52.setNext(head62);

        ListNode listNode = addNumberInListNode(head, head11);
        System.out.println(listNode);
    }
}
