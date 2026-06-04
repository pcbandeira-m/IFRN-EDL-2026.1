package lista.listaDuplaLigada;

import java.util.Iterator;

public class testList2 {
    static void main() {
        doublyLinkedList lista = new doublyLinkedList();
        for (int i = 0; i < 10; i++) {
            lista.insertLast(i);
        }
//        for (int i = 0; i < 10; i++) {
        for (Iterator<Object> iterator = lista.iterator(); iterator.hasNext();) {
            System.out.print(iterator.next() + " ");
        }
//        for (Object o : lista) {
//            System.out.print(o + " ");
//        }
        for (Iterator<node> iterator = lista.nodes().iterator(); iterator.hasNext();) {
            System.out.print(iterator.next().getElement() + " ");
        }
//        for (node node : lista.nodes()) {
//            System.out.print(node.getElement() + " ");
//        }
    }
}
