package arvore.generica;

import java.util.ArrayList;
import java.util.Iterator;

public class Node {
    private Object element;
    private Node parent;
    private ArrayList<Node> children;

    public Node(Node parent, Object element) {
        this.parent = parent;
        this.element = element;
        this.children = new ArrayList<Node>();
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getParent() {
        return parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public Iterator<Node> getChildrenIterator() {
        return children.iterator();
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public void removeChild(Node node) {
        children.remove(node);
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return element.toString();
    }

}
