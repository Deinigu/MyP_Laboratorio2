package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<Integer> doubleLinkedList;

    /**
     * Esta clase contiene casos de prueba para DoublyLinkedListDeque.java
     *
     * @author Diego López Reduello
     * @author Jaime Luis Mesa Víquez
     */

    /*  Casos de prueba:
     *  1. Dado un conjunto vacío de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método first() o last(),
     *  entonces debe lanzarse una excepción DoubleEndedQueueException.
     *  2. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método append() o prepend(),
     *  entonces el elemento debe agregarse correctamente a la lista doblemente enlazada.
     *  3. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método deleteFirst() o deleteLast(),
     *  entonces el primer o último elemento debe eliminarse correctamente de la lista doblemente enlazada y el tamaño de la lista debe disminuir en uno.
     *  4. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método first() o last(),
     *  entonces el primer o último elemento debe devolverse correctamente.
     *  5. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se agregan varios elementos usando append()
     *  o prepend(), entonces el tamaño de la lista doblemente enlazada debe reflejar correctamente el número de elementos agregados.
     *  6. Dado un conjunto de datos en una instancia de DoublyLinkedListDeque, cuando se llama al método deleteFirst()
     *  o deleteLast() en una lista vacía, entonces debe lanzarse una excepción DoubleEndedQueueException.
     *  7. Dada una DoublyLinkedListDeque con elementos válidos, cuando se llama al método get(int index) con el parámetro correcto,
     *  devolverá el elemento que esté en la posición indicada por el parámetro (contando desde 0).
     *  8. Dada una DoublyLinkedListDeque con elementos válidos, cuando se llama al método get(int index) con parámetros incorrectos, lanzará una excepción.
     *  9. Dada una DoublyLinkedListDeque sin elementos, cuando se llama al método get(int index), lanzará una excepción.
     *  10. Dada una DoublyLinkedListDeque con elementos válidos, con uno de sus nodos con un elemento x, al usar el método contains() usando como paramétro
     *  ese objeto x, la función devolverá true. En caso contrario, devolverá false.
     *  11. Dada una DoublyLinkedListDeque con elementos válidos, con uno de sus nodos con un elemento x, al usar el método remove() usando como paramétro
     *  ese objeto x, la función eliminará todas las instancias de la lista con ese objeto.
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
        void testConstructor() {
            doubleLinkedList = new DoublyLinkedListDeque<Integer>();
            assertEquals(0, doubleLinkedList.size());
        }
    }

    @Nested
    @DisplayName("Funciones de clase")
    class testParaFuncionesDeClase {
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
        void testAppend() {
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
        void testPreppend() {
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
        void testDeleteFirst() {
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
        void testDeleteLast() {
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
        void testLast() {
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

    @Nested
    @DisplayName("Operaciones complejas")
    class TestOperaciones {

        @BeforeEach
        void setUp() {
            doubleLinkedList = new DoublyLinkedListDeque<Integer>();
        }

        @AfterEach
        void shutdown() {
            doubleLinkedList = null;
        }

        @Test
        @DisplayName("get()")
        void testGet() {
            doubleLinkedList.append(0);
            doubleLinkedList.append(1);
            doubleLinkedList.append(2);
            doubleLinkedList.append(3);
            doubleLinkedList.append(4);

            int expected = 3;
            int actual = doubleLinkedList.get(3);

            assertEquals(expected, actual);

            expected = 0;
            actual = doubleLinkedList.get(0);

            assertEquals(expected, actual);

            expected = 4;
            actual = doubleLinkedList.get(4);
            assertEquals(expected, actual);

        }

        @DisplayName("get() excepciones")
        @Test
        void testGetConExcepciones() {
            // Caso doubleLinkedList vacía
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.get(3));

            // Caso índice por encima del tamaño
            doubleLinkedList.append(0);
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.get(3));

            // Caso índice negativo
            assertThrows(DoubleEndedQueueException.class, () -> doubleLinkedList.get(-3));

        }

        @DisplayName("contains()")
        @Test
        void testContains() {
            doubleLinkedList.append(1);
            doubleLinkedList.append(0);
            doubleLinkedList.append(22);
            doubleLinkedList.append(13);

            boolean actual = doubleLinkedList.contains(0);
            assertTrue(actual);

            actual = doubleLinkedList.contains(1);
            assertTrue(actual);

            actual = doubleLinkedList.contains(13);
            assertTrue(actual);

            actual = doubleLinkedList.contains(22);
            assertTrue(actual);

            actual = doubleLinkedList.contains(420);
            assertFalse(actual);

        }

        @DisplayName("remove()")
        @Test
        void testRemove()
        {
            doubleLinkedList.append(1);
            doubleLinkedList.append(0);
            doubleLinkedList.append(22);
            doubleLinkedList.append(13);
            doubleLinkedList.append(22);
            doubleLinkedList.append(37);

            // Caso eliminar el primero
            doubleLinkedList.remove(1);
            assertFalse(doubleLinkedList.contains(1));
            assertTrue(doubleLinkedList.contains(0));

            // Caso eliminar solo un elemento
            doubleLinkedList.prepend(1);
            doubleLinkedList.remove(13);
            assertFalse(doubleLinkedList.contains(13));
            assertTrue(doubleLinkedList.contains(22));

            // Caso eliminar dos elementos
            doubleLinkedList.append(13);
            doubleLinkedList.remove(22);
            assertFalse(doubleLinkedList.contains(22));
            assertTrue(doubleLinkedList.contains(13));

            // Caso eliminar último elemento
            doubleLinkedList.remove(13);
            assertFalse(doubleLinkedList.contains(13));
            assertFalse(doubleLinkedList.contains(22));
            assertTrue(doubleLinkedList.contains(1));

        }


    }
}
