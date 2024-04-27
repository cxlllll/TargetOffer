package tfl.chapter4;

public class Question27 {
    public static  ListNode reverseList(ListNode listNode){
     ListNode prev = null;
     ListNode cur = listNode;
     while(cur != null){
         ListNode next = cur.next;
         cur.next = prev;
         prev = cur;
         cur = next;
     }
     return prev;
    }

    // 判断是否是回文串
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next==null){
            return true;
        }
        ListNode slow =head;
        ListNode fast =slow.next;
        // 在最后的情况去判断 这个条件怎么写 因为每次走两步 最后只可能是只有一个或者到了最后 所以 条件是
        // 退出循环以后 slow节点就是中间节点
        // 可以通过fast来判断是否节点数是基数还是偶数 因为 fast每次走2步 走到最后生一个节点那么就是奇数否则是偶数
        while( fast.next !=null && fast.next.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode halfList = slow.next;
        if(fast.next!=null){
            halfList = slow.next.next;
        }
        slow.next = null;// 切断两个链表
        ListNode reverseList = reverseList(halfList);// 反转后的下半部分列表
        boolean result = true;
        while(head!=null && reverseList!=null){
            if(head.value != reverseList.value){
                return  false;
            }
            head = head.next;
            reverseList = reverseList.next;
        }
        return  result;
    }
}
