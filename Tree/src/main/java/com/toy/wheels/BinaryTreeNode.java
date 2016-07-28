package com.toy.wheels;

/**
 * Created by toy on 7/28/16.
 */
public class BinaryTreeNode<Key, Value> {
    private Key key;
    private Value value;
    private BinaryTreeNode<Key, Value> left, right;
    private int n; // the count of the node  as this is the root

    public BinaryTreeNode(Key key, Value value, int n) {
        this.key = key;
        this.value = value;
        this.n = n;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public BinaryTreeNode<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<Key, Value> left) {
        this.left = left;
    }

    public BinaryTreeNode<Key, Value> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<Key, Value> right) {
        this.right = right;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
