package tfl.chapter4;


public class ListNode<T> {
     T value;
     ListNode next;

    public ListNode(T value){
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        if(value!=null){
stringBuffer.append(value).append(":");
        }
        ListNode nextNode = next;
        while(nextNode !=null){
            stringBuffer.append(nextNode.getValue()).append(":");
            nextNode = nextNode.next;
        }
        return  stringBuffer.toString();
    }
}
