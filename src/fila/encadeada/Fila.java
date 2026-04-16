package fila.encadeada;

public interface Fila {
    int size();
    boolean isEmpty();
    Object first() throws EmptyLineException;
    void enqueue(Object o);
    Object dequeue() throws EmptyLineException;
}
