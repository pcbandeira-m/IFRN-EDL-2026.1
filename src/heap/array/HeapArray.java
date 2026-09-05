
package heap.array;

public class HeapArray implements QueueArrayInterface {
    private int[] heap;
    private int size;

    public HeapArray(int capacity) {
        // Como o índice 0 fica vazio, precisamos de 1 espaço a mais no array
        heap = new int[capacity + 1];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int min() throws ArrayException {
        if (isEmpty()) { throw new ArrayException("Heap is empty."); }

        return heap[1];
    }

    public void insert(int value) throws ArrayException {
        if (size == heap.length - 1) { throw new ArrayException("Heap is full."); }

        size++;
        heap[size] = value;
        upHeap(size);
    }

    public int removeMin() throws ArrayException {
        if (isEmpty()) { throw new ArrayException("Heap is empty."); }

        int min = heap[1];

        heap[1] = heap[size];
        size--;
        downHeap(1);

        return min;
    }

    private void upHeap(int index) {
        int parent = index / 2;

        while (index > 1 && heap[index] < heap[parent]) {
            swapKeys(index, parent);
            index = parent;
            parent = index / 2;
        }
    }

    private void downHeap(int index) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;

        int smallerElem = index;
        if (leftChild <= size && heap[leftChild] < heap[smallerElem]) {
            smallerElem = leftChild;
        }
        if (rightChild <= size && heap[rightChild] < heap[smallerElem]) {
            smallerElem = rightChild;
        }
        if (smallerElem != index) {
            swapKeys(index, smallerElem);
            downHeap(smallerElem);
        }
    }

    private void swapKeys(int i, int j) {
        int aux = heap[i];

        heap[i] = heap[j];
        heap[j] = aux;
    }

    public void showArray() {
        System.out.print("Heap Array (índice 0 oculto): [");

        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i]);
            if (i < size) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
