package cs.matemaster.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/25 20:45
 */
public class Stack<E> implements Iterable<E> {
    private Node top = null;
    private int n = 0;

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public void push(E e) {
        Node old = top;
        top = new Node(e, old);
        n++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Node temp = top;
        top = top.next;
        n--;
        return (E) temp.element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (E) top.element;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator var2 = this.iterator();

        while (var2.hasNext()) {
            E item = (E) var2.next();
            s.append(item);
            s.append(' ');
        }

        return s.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(top);
    }

    private static class ListIterator<E> implements Iterator<E> {
        private Node current;

        public ListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = (E) current.element;
            current = current.next;
            return element;
        }
    }

    private static class Node<E> {
        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
