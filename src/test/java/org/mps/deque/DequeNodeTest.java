package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DequeNode")
public class DequeNodeTest {

    /**
     * Esta clase contiene casos de prueba para DequeNode.java
     *
     * @author Diego López Reduello
     * @author Jaime Luis Mesa Víquez
     */

    /* Casos de prueba:
     *  1. Dado un item válido y dos referencias nulas cuando creemos el DequeNode, el programa creará una instancia de este objeto.
     *  2. Dado un item válido y dos instancias de DequeNode que sean el anterior y el siguiente, el programa creará una instancia de este objeto.
     *  3. Dado un nodo válido y un item válido, al establecer el valor del DequeNode con el método setItem(), el item de la instancia se actualizará.
     *  4. Dado un nodo principal, al establecer un nuevo nodo como el anterior de este, el nodo anterior se habrá actualizado correctamente.
     *  5. Dado un nodo principal, al establecer un nuevo nodo como el siguiente de este, el nodo siguiente se habrá actualizado correctamente.
     *  6. Dado un nodo que no tiene anterior, al comprobar si es el primer nodo, el método devolverá true. En caso contrario, devolverá false.
     *  7. Dado un nodo que no tiene siguiente, al comprobar si es el último nodo, el método devolverá true. En caso contrario, devolverá false.
     *  8. Dado un nodo que tiene anterior y siguiente, al comprobar si no es termianl, el método devolverá true. En caso contrario, devolverá false.
     *
     */
    DequeNode node;

    @Nested
    @DisplayName("Constructores")
    class TestParaConstructores {
        @BeforeEach
        void setup() {
            node = new DequeNode(null, null, null);
        }

        @AfterEach
        void shutdown() {
            node = null;
        }

        @Test
        @DisplayName("Constructor con referencias nulas")
        void constructorReferenciasNulas() {
            node = new DequeNode("test", null, null);
            assertEquals("test", node.getItem());
            assertNull(node.getPrevious());
            assertNull(node.getNext());

        }

        @Test
        @DisplayName("Constructor con nodos")
        void constructorReferenciasNoNulas() {
            DequeNode prev = new DequeNode("prev", null, null);
            DequeNode next = new DequeNode("next", null, null);

            node = new DequeNode("test", prev, next);
            assertEquals("test", node.getItem());
            assertEquals(prev, node.getPrevious());
            assertEquals(next, node.getNext());

        }
    }

    @Nested
    @DisplayName("Setters")
    class TestParaSetters {
        @BeforeEach
        void setup() {
            node = new DequeNode(null, null, null);
        }

        @AfterEach
        void shutdown() {
            node = null;
        }

        @DisplayName("Set item")
        @Test
        void testSetItem() {
            node.setItem(5);
            assertEquals(5, node.getItem());
        }

        @DisplayName("Set previous")
        @Test
        void testSetPrevious() {
            DequeNode prev = new DequeNode("prev", null, null);
            node.setPrevious(prev);

            assertEquals(prev, node.getPrevious());
        }

        @DisplayName("Set next")
        @Test
        void testSetNext() {
            DequeNode next = new DequeNode("next", null, null);
            node.setNext(next);

            assertEquals(next, node.getNext());
        }

    }

    @Nested
    @DisplayName("Funciones booleanas")
    class TestParaFuncionesBooleanas {
        @BeforeEach
        void setup() {
            node = new DequeNode(null, null, null);
        }

        @AfterEach
        void shutdown() {
            node = null;
        }

        @DisplayName("IsFirstNode")
        @Test
        void testIsFirstNode()
        {
            DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(2, node1, null);
            assertTrue(node1.isFirstNode());
            assertFalse(node2.isFirstNode());
        }

        @DisplayName("IsLastNode")
        @Test
        void testIsLastNode() {
            DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(2, null, node1);
            assertTrue(node1.isLastNode());
            assertFalse(node2.isLastNode());
        }

        @DisplayName("IsNotATerminalNode")
        @Test
        void testIsNotATerminalNode() {
            DequeNode<Integer> node1 = new DequeNode<>(2, null, node);
            DequeNode<Integer> node2 = new DequeNode<>(1, node, null);
            node.setNext(node2);
            node.setPrevious(node1);

            assertTrue(node.isNotATerminalNode());
            assertFalse(node1.isNotATerminalNode());
            assertFalse(node2.isNotATerminalNode());
        }
    }



}
