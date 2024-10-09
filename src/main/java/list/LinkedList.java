package list;

public class LinkedList {
    private Node first;
    private Node last;
    private int length;

    public LinkedList(){
        this.length = 0;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void add(String value){
        Node element = new Node(value);
        if (first == null && last == null){
            first = element;
            last = element;
        }
        else {
             last.setNext(element);
             last = element;
        }
        length++;

    }

    public void remove(String value){
        Node previous = null;
        Node current = first;
        for (int i = 0; i < getLength(); i++) {
            if (current.getValue().equalsIgnoreCase(value)){
                if (length == 1){
                    first = null;
                    last = null;
                }
                else if (current == first){
                    first = current.getNext();
                    current.setNext(null);
                } else if (current == last) {
                    last = previous;
                    previous.setNext(null);
                }
                else {
                    previous.setNext(current.getNext());
                    current = null;
                }
                length--;
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public Node get(int position){
        Node current = first;
        for (int i = 0; i < position; i++) {
            if (current.getNext() != null){
                current = current.getNext();
            }
        }
        return current;
    }


}
