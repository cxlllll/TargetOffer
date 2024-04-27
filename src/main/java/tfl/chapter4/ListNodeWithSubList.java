package tfl.chapter4;

public class ListNodeWithSubList<T> {
    T value;
    ListNodeWithSubList next;
    ListNodeWithSubList before;
    ListNodeWithSubList subList;

    public ListNodeWithSubList getSubList() {
        return subList;
    }

    public ListNodeWithSubList getBefore() {
        return before;
    }

    public void setBefore(ListNodeWithSubList before) {
        this.before = before;
    }

    public void setSubList(ListNodeWithSubList subList) {
        this.subList = subList;
    }

    public ListNodeWithSubList(){

    }
    public ListNodeWithSubList(T value){
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(ListNodeWithSubList next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public ListNodeWithSubList getNext() {
        return next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        if(value!=null){
            stringBuffer.append(value).append(":");
        }
        ListNodeWithSubList nextNode = next;
        while(nextNode !=null && nextNode.value!=null){
            stringBuffer.append(nextNode.getValue()).append(":");
            nextNode = nextNode.next;
        }
        return  stringBuffer.toString();
    }
}
