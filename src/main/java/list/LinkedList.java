package list;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;

    public LinkedList(){
        this.length = 0;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void add(T value){
        Node<T> element = new Node<T>(value);
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

    public void remove(T value){
        Node<T> previous = null;
        Node<T> current = first;
        for (int i = 0; i < getLength(); i++) {
            if (current == value){
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

    public Node<T> get(int position){
        Node<T> current = first;
        for (int i = 0; i < position; i++) {
            if (current.getNext() != null){
                current = current.getNext();
            }
        }
        return current;
    }


}
