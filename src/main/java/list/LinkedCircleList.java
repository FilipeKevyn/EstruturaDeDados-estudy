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
        Node<T> newNode = new Node<>(element);
        if (first == null && last == null){
            first = newNode;
            last = newNode;
        }
        else {
            newNode.setNext(top); // -> E -> D
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
            first.setPrevious(last);
            last.setNext(first);
        }
        length++;
    }

    public void addBeginning(T element){
        Node<T> newNode = new Node<>(element);
        if (first == null && last == null){
            first = newNode;
            last = newNode;
        }
        else {
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
            first.setPrevious(last);
            last.setNext(first);
        }
        length++;
    }

    public void add(T element, int position){
        if (position == 0){
            addBeginning(element);
        } else if (position + 1 == length) {
            addEnd(element);
        } else {
            Node<T> node = get(position);
            Node<T> newNode = new Node<>(element);

            newNode.setNext(node);
            newNode.setPrevious(node.getPrevious());
            node.setPrevious(newNode);
        }
    }
    // concertar
    public Node<T> get(int position){
        Node<T> current = first;
        for (int i = 0; i < position; i++) {
            if (current.getNext() != null) {
                current = current.getNext();
            } else {
                return null;
            }
        }
        return current;
    }

    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }

}