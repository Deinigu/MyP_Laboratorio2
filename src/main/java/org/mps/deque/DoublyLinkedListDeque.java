package org.mps.deque;

import java.util.Deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode<T> temp = new DequeNode<T>(value,null,first);
        if (first != null) {
            first.setPrevious(temp);
        }
        first = temp;
        if(last == null) {
            last = temp;
        }
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> temp = new DequeNode<T>(value,last,null);
        if (last != null) {
            last.setNext(temp);
        }
        last = temp;
        if(first == null) {
            first = temp;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede borrar elementos en una lista vacía");
        }
        DequeNode<T> temp = first;
        first = first.getNext();
        first.setPrevious(null);
        size--;

    }

    @Override
    public void deleteLast() {

        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede borrar elementos en una lista vacía");
        }
        DequeNode<T> temp = last;
        last = first.getPrevious();
        last.setNext(null);
        size--;
    }

    @Override
    public T first() {
        if(size <= 0)
        {
            throw new DoubleEndedQueueException("No se puede obtener el item de un nodo nulo");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        if(size <= 0)
        {
            throw new DoubleEndedQueueException("No se puede obtener el item de un nodo nulo");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }
}
