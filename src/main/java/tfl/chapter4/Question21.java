package tfl.chapter4;


public class Question21 {
    public static  ListNode<Integer> removeSpecialNode(ListNode<Integer> list,int n){
        // 先加上哨兵节点
        ListNode head = new ListNode(0);
        head.setNext(list);
        ListNode before= head;
        ListNode back= head;
        // 因为这里加了哨兵节点 所以 移动的步数从n-1变成n
        for(int a=0;a<n;a++){
            before = before.getNext();
        }
        // 此时 before与back同时移动相同距离，他们的距离保持不变，
        while(before.getNext()!=null){
            back=back.getNext();
            before= before.getNext();
        }
        // 当before走到头的时候 back走到了 总数-n，也就是倒数n+1个位置。
        back.setNext(back.getNext().getNext()) ;
        return head.getNext();
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
        ListNode<Integer> integerListNode = removeSpecialNode(head, 3

        );
        System.out.println(integerListNode);
    }
}
