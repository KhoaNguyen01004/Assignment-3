import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected int size = 0;

    @Override
    public ListIterator<T> iterator() {
        return new ListIterator<T>() {

            Node<T> currNode = head;
            Node<T> last = null;

            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T data = currNode.data;
                last = currNode;
                currNode = currNode.next;

                return data;
            }

            @Override
            public boolean hasPrevious() {
                return last != null;
            }

            @Override
            public T previous() throws NoSuchElementException {

                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }

                T prevData = last.data;
                currNode = last;
                last = last.prev;
                return prevData;
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException();
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T e) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(T e) {
                throw new UnsupportedOperationException();
            }

        };
    }

    protected class Node<C> {
        protected C data;
        protected Node<C> prev;
        protected Node<C> next;

        protected Node(C data) {
            this.data = data;
        }
    }

    public int getSize() {
        return size;
    }

    public BasicDoubleLinkedList<T> addToEnd(T data) {
        Node<T> node = new Node<>(data);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size++;

        return this;
    }

    public BasicDoubleLinkedList<T> addToFront(T data) {
        Node<T> node = new Node<>(data);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        size++;

        return this;
    }

    public T getFirst() {
        if (size == 0)
            return null;
        return head.data;
    }

    public T getLast() {
        if (size == 0) {
            return null;
        }
        return tail.data;
    }

    public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
        Node<T> currNode = head;
        while (currNode != null) {
            if (comparator.compare(targetData, currNode.data) == 0) {
                if (currNode == head) {
                    head = head.next;
                    size--;
                    break;
                } else if (currNode == tail) {
                    tail = tail.prev;
                    tail.next = null;
                    size--;
                    break;
                } else {
                    currNode.prev.next = currNode.next;
                    currNode.next.prev = currNode.prev;
                    size--;
                    break;
                }
            } else
                currNode = currNode.next;
        }
        return this;
    }

    public T retrieveFirstElement() {
        if (size == 0)
            return null;
        T firstElement = head.data;
        head = head.next;
        head.prev = null;
        size--;

        return firstElement;
    }

    public T retrieveLastElement() {
        if (size == 0)
            return null;
        T lastElement = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;

        return lastElement;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        Node<T> currNode = head;

        while (currNode != null) {
            arrayList.add(currNode.data);
            currNode = currNode.next;
        }

        return arrayList;
    }
}