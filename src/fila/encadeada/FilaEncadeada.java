package fila.encadeada;

public class FilaEncadeada implements Fila {
    private Node head;
    private Node tail;
    private int size;

    public FilaEncadeada() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object first() throws EmptyLineException {
        return null;
    }

    @Override
    public void enqueue(Object o) {

    }

    @Override
    public Object dequeue() throws EmptyLineException {
        return null;
    }
}
