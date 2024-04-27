package tfl.chapter4;

public class Question26 {
    // 反转链表
    public static   ListNode reverseList(ListNode list){
        if(list==null || list.next==null){
            return list;

        }
        ListNode prev =null;
        ListNode cur = list;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur= nextNode;
        }
        return prev;
    }

    // 这么写空间复杂度太高了
    public static  ListNode reorderList(ListNode<Integer> head){
        ListNode newHead = new ListNode();
        ListNode start = head;
        // 复制一个链表
        ListNode start2 = newHead;
        while(start !=null){
            start2.next=new ListNode<>(start.value);
            start2 = start2.next;
            start = start.next;
        }
        ListNode<Integer> reverseList = reverseList(newHead);// 得到反转链表
        int n = countListLength(head);
        int count = 0;
        ListNode result= new ListNode();
        ListNode newList= result;
        //



        while(count < n){
            int value = (count%2==0?head.value:reverseList.value);
            newList.next = new ListNode(value);
            if(count%2==0){
                head =head.next;
            }else{
                reverseList= reverseList.next;
            }
            newList= newList.next;
            count++;
        }
        return result;
    }

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

    public static void main(String[] args) {
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
        System.out.println(reorderList(head11));
    }
}
