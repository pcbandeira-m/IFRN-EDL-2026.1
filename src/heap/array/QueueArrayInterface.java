
package heap.array;

public interface QueueArrayInterface {
    int size();
    boolean isEmpty();
    int min() throws ArrayException;
    void insert(int value) throws ArrayException;
    int removeMin() throws ArrayException;
}
