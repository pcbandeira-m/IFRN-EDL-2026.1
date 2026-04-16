package fila.reversao;

public interface InterfaceFila {
    int size();
    boolean isEmpty();
    Object first() throws EmptyQueueException;
    void enqueue(Object o);
    Object dequeue() throws EmptyQueueException;
    void reversed();
}
