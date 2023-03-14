package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> doubleLinkedList;

    /* Casos de prueba:
     * 1. Dado un conjunto vacío de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método first() o last(), entonces debe lanzarse una excepción DoubleEndedQueueException.
     * 2. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método append() o prepend(), entonces el elemento debe agregarse correctamente a la lista doblemente enlazada.
     * 3. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método deleteFirst() o deleteLast(), entonces el primer o último elemento debe eliminarse correctamente de la
     * lista doblemente enlazada y el tamaño de la lista debe disminuir en uno.
     *
     * 4. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método first() o last(), entonces el primer o último elemento debe devolverse correctamente.
     * 5. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se agregan varios elementos usando append() o prepend(), entonces el tamaño de la lista doblemente enlazada debe reflejar
     *  correctamente el número de elementos agregados.
     *
     * 5. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método deleteFirst() o deleteLast() en una lista vacía, entonces debe lanzarse una excepción
     *  DoubleEndedQueueException.
     */

    @Nested
    @DisplayName("Constructores")
    class TestParaConstructores {
        @BeforeEach
        void setUp() {
            doubleLinkedList = new DoublyLinkedListDeque<Integer>();
        }

        @AfterEach
        void shutdown() {
            doubleLinkedList = null;
        }
        @Test
        @DisplayName("La lista tendra un tamanyo igual a 0")
        void TestConstructor() {
            doubleLinkedList = new DoublyLinkedListDeque<Integer>();
            assertEquals(0, doubleLinkedList.size());
        }
    }

    @Nested
    @DisplayName("Funciones de clase")
    class TestParaFuncionesDeClase {
        @BeforeEach
        void setUp() {
            doubleLinkedList = new DoublyLinkedListDeque<Integer>();
        }

        @AfterEach
        void shutdown() {
            doubleLinkedList = null;
        }

        @Test
        @DisplayName("Append")
        void TestAppend() {
            doubleLinkedList.prepend(1);
            doubleLinkedList.prepend(2);
            doubleLinkedList.prepend(3);

            assertEquals(3, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
            assertEquals(3, doubleLinkedList.size());

            doubleLinkedList.prepend(4);

            assertEquals(4, doubleLinkedList.first());
            assertEquals(1, doubleLinkedList.last());
            assertEquals(4, doubleLinkedList.size());
        }

        @Test
        @DisplayName("Preppend")
        void TestPreppend() {
            doubleLinkedList.append(1);
            doubleLinkedList.append(2);
            doubleLinkedList.append(3);

            assertEquals(1, doubleLinkedList.first());
            assertEquals(3, doubleLinkedList.last());
            assertEquals(3, doubleLinkedList.size());

            doubleLinkedList.append(4);

            assertEquals(1, doubleLinkedList.first());
            assertEquals(4, doubleLinkedList.last());
            assertEquals(4, doubleLinkedList.size());
        }

        @Test
        @DisplayName("DeleteFirst")
        void TestDeleteFirst() {
            doubleLinkedList.append(1);
            doubleLinkedList.append(2);
            doubleLinkedList.append(3);

            doubleLinkedList.deleteFirst();

            assertEquals(2, doubleLinkedList.first());
            assertEquals(3, doubleLinkedList.last());
            assertEquals(2, doubleLinkedList.size());

            doubleLinkedList.deleteFirst();

            //assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.deleteFirst());
        }

        @Test
        @DisplayName("DeleteLast")
        void TestDeleteLast() {
            doubleLinkedList.append(1);
            doubleLinkedList.append(2);
            doubleLinkedList.append(3);

            doubleLinkedList.deleteLast();

            assertEquals(1, doubleLinkedList.first());
            assertEquals(2, doubleLinkedList.last());
            assertEquals(2, doubleLinkedList.size());

            doubleLinkedList.deleteLast();

            //assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.deleteLast());
        }

        @Test
        @DisplayName("Last")
        void TestLast() {
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.last());

            doubleLinkedList.append(1);
            doubleLinkedList.append(2);

            assertEquals(2, doubleLinkedList.last());

            doubleLinkedList.deleteLast();

            assertEquals(1, doubleLinkedList.last());
        }

        @Test
        @DisplayName("Size")
        void testSize() {
            assertEquals(0, doubleLinkedList.size());

            doubleLinkedList.append(1);
            doubleLinkedList.append(2);
            doubleLinkedList.prepend(3);

            assertEquals(3, doubleLinkedList.size());

            doubleLinkedList.deleteFirst();
            doubleLinkedList.deleteLast();

            assertEquals(1, doubleLinkedList.size());
        }

        @Test
        @DisplayName("Double Linked List Exception")
        void testEmptyDequeException() {
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.first());
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.last());
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.deleteFirst());
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.deleteLast());
        }
    }
}
