package cs.matemaster.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description: 基于链表实现队列
 * @Author: matemaster9
 * @Date: 2022/1/26 20:16
 */
public class Queue<E> implements Iterable<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int n = 0;

    public Queue() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(E e) {
        Node<E> old = tail;
        tail = new Node<>(e, null);
        if (isEmpty()) {
            head = tail;
        } else {
            old.next = tail;
        }
        n++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        E item = head.element;
        head = head.next;
        n--;
        if (isEmpty()) {
            tail = null;
        }
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return head.element;
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
        return new ListIterator<>(head);
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
