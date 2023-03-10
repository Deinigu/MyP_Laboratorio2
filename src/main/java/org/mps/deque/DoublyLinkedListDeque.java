package org.mps.deque;

import java.util.Deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {
    /**
     * Implementación de una doble lista enlazada
     *
     * @author Diego López Reduello
     * @author Jaime Luis Mesa Víquez
     */

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
        // Añade un elemento al principio de la lista
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
        // Añade un elemento al final de la lista
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
        // Borra el primer elemento de la lista
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
        // Borra el último elemento de la lista
        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede borrar elementos en una lista vacía");
        }
        DequeNode<T> temp = last;
        last = last.getPrevious();
        last.setNext(null);
        size--;
    }

    @Override
    public T first() {
        // Devuelve el primer elemento de la lista
        if(size <= 0)
        {
            throw new DoubleEndedQueueException("No se puede obtener el item de un nodo nulo");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        // Devuelve el último elemento de la lista
        if(size <= 0)
        {
            throw new DoubleEndedQueueException("No se puede obtener el item de un nodo nulo");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        // Devuelve el tamaño de la lista
        return this.size;
    }
}
