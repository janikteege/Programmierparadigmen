// Zusammenarbeit: Janik Teege, Nele Hüsemann

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTree<T> {
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        return node;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }

    public Iterator<T> iterate(Iterable<T> iter) {
        return iter.iterator();
    }
}

class BinTreeTraversal {
    public static void main(String[] args) {
        /*
            Following is an usage example, creating a binary tree and printing out all values in the order of the given iterator
         */

        BinaryTree<Integer> root = new BinaryTree<Integer>(1);

        root.setLeft(new BinaryTree<Integer>(2));
        root.setRight(new BinaryTree<Integer>(3));

        // Your implementation should be able to perform a for each with the given syntax
        for (int item : new PreorderIterable<Integer>(root)) {
            System.out.println(item);
        }
    }
}

// Solution Inorder and Preorder

class InorderIterator<T> implements Iterator<T> {
    private Queue<T> queue = new LinkedList<>();
    private BinaryTree<T> root;

    public InorderIterator(BinaryTree<T> root) {
        this.root = root;
        inorder(root);
    }

    private void inorder(BinaryTree<T> node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        queue.add(node.getValue());
        inorder(node.getRight());
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        return queue.poll();
    }
}

class InorderIterable<T> implements Iterable<T> {
    private BinaryTree<T> root;

    public InorderIterable(BinaryTree<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new InorderIterator<>(root);
    }
}

class PreorderIterator<T> implements Iterator<T> {
    private Queue<T> queue = new LinkedList<>();
    private BinaryTree<T> root;

    public PreorderIterator(BinaryTree<T> root) {
        this.root = root;
        preorder(root);
    }

    private void preorder(BinaryTree<T> node) {
        if (node == null) {
            return;
        }

        queue.add(node.getValue());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        return queue.poll();
    }
}

class PreorderIterable<T> implements Iterable<T> {
    private BinaryTree<T> root;

    public PreorderIterable(BinaryTree<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new PreorderIterator<>(root);
    }
}

