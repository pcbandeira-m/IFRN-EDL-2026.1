package arvore.generica;

import java.util.Iterator;
import java.util.ArrayList;

public class GenericTree implements InterfaceGenericTree {

    private Node root;
    private int size;

    public GenericTree(Object element) {
        root = new Node(null, element);
        size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height(Node node) {
        if (node == null) return 0;
        if (isExternal(node)) {
            return 0;
        } else {
            int h = 0;
            ArrayList<Node> children = node.getChildren();
            for (Node child : children) {
                h = Math.max(h, height(child));
            }
            return ++h;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Object> elements() {
        ArrayList<Object> elements = new ArrayList<Object>();
        if (root != null) {
            preOrder(root, elements);
        }

        return elements.iterator();
    }

    @Override
    public Iterator<Node> nodes() {
        ArrayList<Node> nodes = new ArrayList<Node>();
        if (root != null) {
            preOrderNode(root, nodes);
        }

        return nodes.iterator();
    }

    @Override
    public Node root() {
        return root;
    }

    @Override
    public Node parent(Node node) {
        return isRoot(node) ? null : node.getParent();
    }

    @Override
    public Iterator<Node> children(Node node) {
        return node.getChildrenIterator();
    }

    @Override
    public void preOrder(Node node, ArrayList<Object> list) {
        if (node == null){
            return;
        }
        list.add(node.getElement());

        Iterator<Node> childrenIterators = node.getChildrenIterator();

        while (childrenIterators.hasNext()){
            Node nextNode = childrenIterators.next();
            preOrder(nextNode, list);
        }
    }

    @Override
    public void preOrderNode(Node node, ArrayList<Node> list) {
        if (node == null){
            return;
        }
        list.add(node);

        Iterator<Node> childrenIterators = node.getChildrenIterator();

        while (childrenIterators.hasNext()){
            Node nextNode = childrenIterators.next();
            preOrderNode(nextNode, list);
        }
    }

    @Override
    public boolean isInternal(Node node) {
        ArrayList<Node> children = node.getChildren();
        int childrenQuantity = children.size();

        return childrenQuantity != 0;
    }

    @Override
    public boolean isExternal(Node node) {
        ArrayList<Node> children = node.getChildren();
        int childrenQuantity = children.size();

        return childrenQuantity == 0;
    }

    @Override
    public boolean isRoot(Node node) {
        return node.getParent() == null;
    }

    @Override
    public Integer depth(Node node) {
        return (isRoot(node)) ? 0 : (1 + depth(node.getParent()));
    }

    @Override
    public Object replace(Node node, Object value) {
        Object replacedValue = node.getElement();
        node.setElement(value);

        return replacedValue;
    }

    @Override
    public void addChildren(Node node, Object value) {
        Node newNode = new Node(node, value);
        node.addChild(newNode);
        size++;
    }

    @Override
    public void remove(Node node) {
        if (!isExternal(node)) {
            throw new IllegalArgumentException("This node isn't able to be removed.");
        }
        if (isRoot(node)) {
            root = null;
        } else {
            Node nodeParent = node.getParent();
            nodeParent.removeChild(node);
            node.setParent(null);
        }
        size--;
    }

}
