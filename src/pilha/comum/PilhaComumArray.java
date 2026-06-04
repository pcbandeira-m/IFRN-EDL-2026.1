package pilha.comum;

import java.util.Arrays;

public class PilhaComumArray implements Pilha {
    private Object[] data;
    private int capacity;
    private int increment;
    private int index;

    public PilhaComumArray(int capacity, int increment) {
        this.capacity = capacity;
        this.index = -1;
        this.increment = 0;
        if (increment > 0){
            this.increment = increment;
        }
        this.data = new Object[capacity];
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public Object top() throws EmptyStackException {
        if (isEmpty()){
            throw new EmptyStackException("Pilha vazia!");
        };
        return data[index];
    }

    @Override
    public void push(Object o) {
        if (index == capacity - 1){
            increaseCapacity();
        }
        data[++index] = o;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException("Pilha vazia!");
        }
        return data[index--];
    }

    public int wayToIncrease() {
        if (increment == 0){
            return capacity * 2;
        } else  {
            return increment *= 2;
        }
    }

    public void increaseCapacity(){
        capacity = wayToIncrease();
        Object[] new_data = new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            new_data[i] = data[i];
        }
        data = new_data;
    }
}

