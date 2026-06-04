package lista.listaDuplaLigada;

import java.util.Iterator;

public interface list extends Iterable<Object> {
    int size();
    boolean isEmpty();
    boolean isFirst(node n);
    boolean isLast(node n);
    node first();
    node last();
    node before(node n) throws IllegalArgumentException;
    node after(node n) throws IllegalArgumentException;
    Object replaceElement(node n, Object o) throws IllegalArgumentException;
    void swapElements(node n, node q) throws IllegalArgumentException;
    void insertBefore(node n, Object o)  throws IllegalArgumentException;
    void insertAfter(node n, Object o)   throws IllegalArgumentException;
    void insertFirst(Object o) throws IllegalArgumentException;
    void insertLast(Object o)  throws IllegalArgumentException;
    void remove(node n) throws IllegalArgumentException, emptyList;

    Iterator<Object> iterator();
    Iterable<node> nodes();
}
