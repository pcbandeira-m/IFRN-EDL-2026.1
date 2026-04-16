package fila.reversao;
import java.util.Arrays;

public class FilaInvertida implements InterfaceFila {
    private Object[] queue;
    private int capacity;
    private int size;
    private int growth;
    private int head;
    private int tail;
    private boolean isReversed;

    public FilaInvertida(int capacity, int growth) {
        this.capacity = capacity;
        this.growth = growth;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
        this.isReversed = false;
        queue = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void increaseCapacity() { // atenção ao array circular e à (re)organização dos elementos
        int newCapacity;

        if (growth == 0) {
            newCapacity = capacity * 2;
        } else {
          newCapacity = capacity + growth;
        }

        Object[] newQueue = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(head + i) % capacity];
        }

        capacity = newCapacity;
        queue = newQueue;
        head = 0;
        tail = size + 1;
    }

    public void decreaseCapacity() {
        int newCapacity = capacity/2;

        if (newCapacity < 1) {
            newCapacity = 1;
        }

        Object[] newQueue = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(head + i) % capacity];
        }

        queue = newQueue;
        capacity = newCapacity;
        head = 0;
        tail = size + 1;
    }

    public void enqueue(Object o) {
        if (size == capacity - 1) {
            increaseCapacity();
        }
        if (isReversed) {
            head = (head + 1 + capacity) % capacity;
            queue[head] = o;
        } else  {
            queue[tail] = o;
            tail = (tail + 1) % capacity;
        }

        size++;
    }

    public Object dequeue() throws EmptyQueueException {
        Object removed;

        if (isEmpty()) {
            throw new EmptyQueueException("Fila vazia!");
        }
        if (size == capacity/3) {
            decreaseCapacity();
        }
        if (isReversed) {
            tail = (tail + 1 + capacity) % capacity;
            removed = queue[tail];
            queue[tail] = null;
        } else { // operação normal
             removed = queue[head];
             queue[head] = null;
             head = (head + 1) % capacity;
        }

        size--;
        return removed;
    }

    public void reversed() {
        if (!isReversed) {
            isReversed = true;
        } else {
            isReversed = false;
        }
    }

    public Object first() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Fila vazia!");
        }
        if (isReversed){
            int circularTail = (tail - 1 + capacity) % capacity;
            return queue[circularTail];
        }

        return queue[head];
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

}
