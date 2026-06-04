package lista.listaDuplaLigada;

import lista.listaDuplaLigada.iteratorclasses.ElementIterator;
import lista.listaDuplaLigada.iteratorclasses.NodeIterator;

import java.util.Iterator;

public class doublyLinkedList implements list {
    private node first, last;
    private int size;

    public doublyLinkedList() {
        this.size = 0;
        first = last = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFirst(node n) {
        if (n == null) throw new IllegalArgumentException("Nó inválido. Tente outro nó.");
        return this.first == n;
    }

    @Override
    public boolean isLast(node n) {
        if (n == null) throw new IllegalArgumentException("Nó inválido. Tente outro nó.");
        return this.last == n;
    }

    @Override
    public node first() {
        return this.first;
    }

    @Override
    public node last() {
        return this.last;
    }

    @Override
    public node before(node n) throws IllegalArgumentException {
        if (n == null) throw new IllegalArgumentException("Nó inválido");
        if (this.first == n) throw new IllegalArgumentException("Nó n é o primeiro nó e não existe um anterior.");

        return n.getPrev();
    }

    @Override
    public node after(node n) throws IllegalArgumentException {
        if (n == null) throw new IllegalArgumentException("Nó inválido");
        if (this.last == n) throw new IllegalArgumentException("Nó n é o último nó e não existe um posterior.");

        return n.getNext();
    }

    @Override
    public Object replaceElement(node n, Object o) throws IllegalArgumentException {
        if (n == null) throw new IllegalArgumentException("Nó inválido");

        n.setElement(o);
        return n.getElement();
    }

    @Override
    public void swapElements(node n, node q) throws IllegalArgumentException {
        if (n == null || q == null) throw new IllegalArgumentException("Um ou ambos nós inválidos.");

        Object assistant = n.getElement();
        n.setElement(q.getElement());
        q.setElement(assistant);
    }

    @Override
    public void insertBefore(node n, Object o)  throws IllegalArgumentException {

        node newNode = new node();
        newNode.setElement(o);

        if (n == null) {
            this.first = this.last = newNode;
        } else if (isFirst(n)){
            n.setPrev(newNode);
            newNode.setPrev(null);
            newNode.setNext(n);
        } else {
            n.getPrev().setNext(newNode);
            newNode.setPrev(n.getPrev());
            n.setPrev(newNode);
            newNode.setNext(n);
        }

        size++;
    }

    @Override
    public void insertAfter(node n, Object o) throws IllegalArgumentException {

        node newNode = new node();
        newNode.setElement(o);

        if (n == null) {
            this.first = this.last = newNode;
        } else if (isLast(n)) {
            newNode.setNext(null);
            newNode.setPrev(n);
            n.setNext(newNode);
        } else {
            newNode.setNext(n.getNext());
            n.getNext().setPrev(newNode);
            newNode.setPrev(n);
            n.setNext(newNode);
        }

        size++;
    }

    @Override
    public void insertFirst(Object o)  throws IllegalArgumentException {

        node newNode = new node();
        newNode.setElement(o);
        if (size() == 0) this.first = this.last = newNode;
        else {
            newNode.setPrev(null);
            newNode.setNext(this.first);
            this.first.setPrev(newNode);
            this.first = newNode;
        }

        size++;

    }

    @Override
    public void insertLast(Object o) throws IllegalArgumentException {

        node newNode = new node();
        newNode.setElement(o);
        if (size() == 0) this.first = this.last = newNode;
        else {
            newNode.setPrev(this.last);
            newNode.setNext(null);
            this.last.setNext(newNode);
            this.last = newNode;
        }

        size++;

    }

    @Override
    public void remove(node n)  throws IllegalArgumentException, emptyList {

        if (size() == 0) throw new IllegalArgumentException("Nó inválido");
        if (isEmpty()) throw new emptyList("Lista vazia. Nenhum nó para remover.");

        if (size() == 1) {
            this.first = this.last = null;
        } else if (isFirst(n)){
            n.getNext().setPrev(null);
            this.first = n.getNext();
            n.setNext(null);
        } else if (isLast(n)) {
            n.getPrev().setNext(null);
            this.last = n.getPrev();
            n.setPrev(null);
        } else {
            n.getPrev().setNext(n.getNext());
            n.getNext().setPrev(n.getPrev());
            n.setPrev(null);
            n.setNext(null);
        }

        size--;

    }

    @Override
    public Iterator<Object> iterator() {
        return new ElementIterator(this);
    }

    @Override
    public Iterable<node> nodes() {
        return new NodeIterator(this);
    }


}