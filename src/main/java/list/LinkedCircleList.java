package list;

public class LinkedCircleList<T> {
    private Node<T> first;
    private Node<T> last;
    private Node<T> top = first;
    private int length;

    public LinkedCircleList(Node<T> first, Node<T> last, int length) {
        this.first = first;
        this.last = last;
        this.length = length;
    }

    public LinkedCircleList(){}

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

    public void addEnd(T element){
        Node<T> node = new Node<>(element);
        for (int i = 1; i < length; i++) {

        }
    }


}
