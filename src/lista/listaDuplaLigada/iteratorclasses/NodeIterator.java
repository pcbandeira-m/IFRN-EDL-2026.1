package lista.listaDuplaLigada.iteratorclasses;

import lista.listaDuplaLigada.doublyLinkedList;
import lista.listaDuplaLigada.node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator implements Iterable<node> {
    private doublyLinkedList list;
    private node cursor;

    public NodeIterator(doublyLinkedList list) {
        this.list = list;
//        if (list.isEmpty()) {
//            this.cursor = null;
//        } else {
//            this.cursor = list.first();
//        }
        this.cursor = list.isEmpty() ? null : list.first();
    }

    @Override
    public Iterator<node> iterator() {
        return new implementacaoIterador();
    }

    class implementacaoIterador implements Iterator<node> {
        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public node next() {
            if (cursor == null) {
                throw new NoSuchElementException();
            }
            node returnedElement = cursor;
            cursor = (cursor == list.last()) ? null : list.after(cursor);
            return returnedElement;
        }
    }
}
