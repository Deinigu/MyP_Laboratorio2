package org.mps.deque;

import java.util.Deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if (size() == 0) {
            first = new DequeNode<>(value, null, last);
            last = first;
            size = 1;
        } else {
            DequeNode<T> aux = new DequeNode<>(value, null, first);
            first = aux;
            size++;
        }
    }

    @Override
    public void append(T value) {
        if (size() == 0) {
            last = new DequeNode<>(value, first, null);
            first = last;
            size = 1;
        } else {
            DequeNode<T> aux = new DequeNode<>(value, last, null);
            last = aux;
            size++;
        }
    }

    @Override
    public void deleteFirst() {
        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede borrar elementos en una lista vacía");
        } else if (size == 1) {
            first = null;
            last = null;
            size--;
        } else {
            DequeNode<T> temp = first;
            first = first.getNext();
            temp = null;
            size--;
        }
    }

    @Override
    public void deleteLast() {

        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede borrar elementos en una lista vacía");
        } else if (size == 1) {
            first = null;
            last = null;
            size--;
        } else {
            DequeNode<T> temp = last;
            last = last.getPrevious();
            temp = null;
            size--;
        }
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
