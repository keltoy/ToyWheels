package com.toy.wheels;

import javax.xml.bind.ValidationEvent;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by toy on 7/28/16.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private BinaryTreeNode<Key, Value> root;

    public int size() {
        return size(root);
    }

    public int size(BinaryTreeNode root) {
        return root == null ? 0 : root.getN();
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(BinaryTreeNode<Key,Value> node, Key key) {
        if (null == node) return null;
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) return get(node.getLeft(), key);
        else if (cmp > 0) return get(node.getRight(), key);
        else return node.getValue();
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private BinaryTreeNode<Key, Value> put(BinaryTreeNode<Key, Value> node, Key key, Value value) {
        if (null == node) return new BinaryTreeNode<Key, Value>(key, value, 1);
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) node.setLeft(put(node.getLeft(), key, value));
        else if (cmp > 0) node.setRight(put(node.getRight(), key, value));
        else node.setValue(value);
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    public Key min() {
        return min(root).getKey();
    }

    private BinaryTreeNode<Key, Value> min(BinaryTreeNode node) {
        if (node.getLeft() == null) return node;
        return min(node.getLeft());
    }


    public Key max() {
        return max(root).getKey();
    }

    private BinaryTreeNode<Key, Value> max(BinaryTreeNode node) {
        if (node.getRight() == null) return node;
        return max(node.getRight());
    }

    public Key floor(Key key) {
        BinaryTreeNode<Key, Value> node = floor(root, key);
        if (node == null) return null;
        return node.getKey();
    }

    private BinaryTreeNode<Key, Value> floor(BinaryTreeNode<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.getKey());
        if (cmp == 0) return node;
        if (cmp < 0)  return floor(node.getLeft(), key);
        BinaryTreeNode<Key, Value> tmp = floor(node.getRight(), key);
        if (tmp != null) return tmp;
        else             return node;
    }

    public Key ceil(Key key) {
        BinaryTreeNode<Key, Value> node = ceil(root, key);
        if (node == null) return null;
        return node.getKey();
    }

    private BinaryTreeNode<Key, Value> ceil(BinaryTreeNode<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.getKey());
        if (cmp == 0) return node;
        if (cmp > 0)  return ceil(node.getRight(), key);
        BinaryTreeNode<Key, Value> tmp = ceil(node.getLeft(), key);
        if (tmp != null) return tmp;
        else             return node;
    }

    public Key select(int k) {
        return  select(root, k).getKey();
    }

    private BinaryTreeNode<Key, Value> select(BinaryTreeNode<Key, Value> node, int k) {
        if (node == null) return null;
        int lCount = size(node.getLeft());
        if (lCount > k) {
            return select(node.getLeft(), k);
        } else if (lCount < k) {
            return select(node.getRight(), k-lCount - 1);
        } else return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(BinaryTreeNode<Key, Value> node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) return rank(node.getLeft(), key);
        else if (cmp > 0) return rank(node.getRight(), key)+ size(node.getLeft()) + 1;
        else return size(node.getLeft());
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private BinaryTreeNode<Key, Value> deleteMin(BinaryTreeNode<Key, Value> node) {
        if (node.getLeft() == null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private BinaryTreeNode<Key, Value> deleteMax(BinaryTreeNode<Key, Value> node) {
        if (node.getRight() == null) return node.getLeft();
        node.setRight(deleteMax(node.getRight()));
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private BinaryTreeNode<Key, Value> delete(BinaryTreeNode<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) node.setLeft(delete(node.getLeft(), key));
        else if (cmp > 0) node.setRight(delete(node.getRight(), key));
        else {
            if (node.getRight() == null) return node.getLeft();
            if (node.getLeft() == null) return node.getRight();
            BinaryTreeNode<Key, Value> t = node;
            node = min(t.getRight());
            node.setRight(deleteMin(t.getRight()));
            node.setLeft(t.getLeft());
        }
        node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(BinaryTreeNode<Key, Value> node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null) return;
        int cmplo = lo.compareTo(node.getKey());
        int cmphi = hi.compareTo(node.getKey());
        if (cmplo < 0) keys(node.getLeft(), queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(node.getKey());
        if (cmphi > 0) keys(node.getRight(), queue, lo, hi);
    }

    public void print() {
        print(root);
    }

    private void print(BinaryTreeNode<Key, Value> node) {
        if (node == null) return;
        print(node.getLeft());
        System.out.println(node.getKey());
        print(node.getRight());
    }
}

