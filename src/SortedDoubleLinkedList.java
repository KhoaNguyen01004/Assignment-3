import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    protected Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public SortedDoubleLinkedList<T> add(T data) {
        Node<T> node = new Node<>(data);

        if (size == 0) {
            head = tail = node;
        } else if (comparator.compare(data, head.data) < 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (comparator.compare(data, tail.data) > 0) {
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            Node<T> currNode = head.next;
            while (currNode.next != null && comparator.compare(data, currNode.data) > 0) {
                currNode = currNode.next;
            }
            node.next = currNode;
            node.prev = currNode.prev;
            node.prev.next = currNode.prev = node;
        }

        size++;
        return this;
    }

    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public ListIterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
    }
}
