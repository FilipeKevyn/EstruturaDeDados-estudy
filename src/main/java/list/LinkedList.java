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
            if (current.getValue() == value){
                if (length == 1){
                    first = null;
                    last = null;
                }
                else if (current.getValue() == first.getValue()){
                    first = current.getNext();
                    current.setNext(null);
                } else if (current.getValue() == last.getValue()) {
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

    public void add(int position, T value){
        Node<T> novo = new Node<>(value);
        Node<T> next = get(position);
        Node<T> anterior = get(position - 1);

        if (position == 0){
            novo.setNext(get(position));
            setFirst(novo);
        } else if (position == length - 1) {
            last.setNext(novo);
            setLast(novo);
        }else {
            novo.setNext(next);
            anterior.setNext(novo);
        }


        length++;
    }

    public void remove(int position){
        remove(get(position).getValue());

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

    private class Node<T> {
        private T value;
        private Node<T> next;

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
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Tamanho: " + list.getLength());
        System.out.println("Primeiro: " + list.getFirst().getValue());
        System.out.println("Último: " + list.getLast().getValue());
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }
        // remover

        list.remove(0);
        System.out.println("Removeu");
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }
    }

}
