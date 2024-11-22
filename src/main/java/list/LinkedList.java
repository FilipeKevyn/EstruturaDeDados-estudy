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

    public Iterator<T> getIterator(){
        return new Iterator<>(first);
    }

    public void addEnd(T value){
        Node<T> element = new Node<T>(value);
        if (first == null && last == null){
            first = element;
            last = element;
        }
        else {
             last.setNext(element);
             element.setPrevious(last);
             last = element;
        }
        length++;

    }

    public void addBeginning(T value){
        Node<T> element = new Node<T>(value);
        if (first == null && last == null){
            first = element;
            last = element;
        }
        else {
            element.setNext(first);
            first.setPrevious(element);
            setFirst(element);
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
        Node<T> previous = next.getPrevious();

        if (position == 0){
            novo.setNext(get(position));
            setFirst(novo);
        } else if (position == length - 1) {
            last.setNext(novo);
            novo.setPrevious(last);
            setLast(novo);

        }else {
            novo.setNext(next);
            next.setPrevious(novo);
            previous.setNext(novo);
            novo.setPrevious(previous);
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


}
