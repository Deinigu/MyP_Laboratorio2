package org.mps.deque;

import java.util.Comparator;
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
        DequeNode<T> temp = new DequeNode<T>(value, null, first);
        if (first != null) {
            first.setPrevious(temp);
        }
        first = temp;
        if (last == null) {
            last = temp;
        }
        size++;
    }

    @Override
    public void append(T value) {
        // Añade un elemento al final de la lista
        DequeNode<T> temp = new DequeNode<T>(value, last, null);
        if (last != null) {
            last.setNext(temp);
        }
        last = temp;
        if (first == null) {
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
        last = first.getPrevious();
        last.setNext(null);
        size--;
    }

    @Override
    public T first() {
        // Devuelve el primer elemento de la lista
        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede obtener el item de un nodo nulo");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        // Devuelve el último elemento de la lista
        if (size <= 0) {
            throw new DoubleEndedQueueException("No se puede obtener el item de un nodo nulo");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        // Devuelve el tamaño de la lista
        return this.size;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new DoubleEndedQueueException("Indice negativo");
        }
        if (size() == 0) {
            throw new DoubleEndedQueueException("No hay índices en la lista");
        }
        if (index > size()) {
            throw new DoubleEndedQueueException("Índice incorrecto, por encima del tamaño");
        }
        boolean encontrado = false;
        DequeNode<T> aux = this.first;
        if (index == 0) {
            return this.first();
        }
        for (int i = 1; i < size() && !encontrado; i++) {
            aux = aux.getNext();
            if (i == index) {
                encontrado = true;
            }
        }

        return aux.getItem();
    }

    @Override
    public boolean contains(T value) {
        DequeNode<T> aux = this.first;

        if (first().equals(value)) {
            return true;
        }
        for (int i = 1; i < size(); i++) {
            aux = aux.getNext();
            if (aux.getItem().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(T value) {
        DequeNode<T> aux = this.first;

        if(first().equals(value))
        {
            deleteNode(aux);
        }
        for (int i = 1; i < size(); i++) {
            aux = aux.getNext();
            if (aux.getItem().equals(value)) {
                deleteNode(aux);
            }
        }

    }

    private void deleteNode(DequeNode eraseThis)
    {

        if(!eraseThis.isFirstNode())
            eraseThis.getPrevious().setNext(eraseThis.getNext());
        else
            this.first = eraseThis.getNext();
        if(!eraseThis.isLastNode())
            eraseThis.getNext().setPrevious(eraseThis.getPrevious());
        else
            this.last = eraseThis.getPrevious();
        eraseThis = null;
        size--;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {


    }

    private void swap(){

    }
}
