package com.toy.wheels;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by toy on 7/26/16.
 */
public class StackUsingQueue<T> {
    private Queue<T> queue1 = new LinkedList<T>();
    private Queue<T> queue2 = new LinkedList<T>();
    int size = 0;

    public StackUsingQueue() {
    }

    public void push(T item) {
        ++size;
        queue1.add(item);
    }

    private Queue<T> neatQueue() {
        if (size == 0) {
            return null;
        }
        Queue<T> result = null;
        if (queue1.size() == 0) {
            for (int j = 0; j < queue2.size()-1; ++j) {
                queue1.add(queue2.peek());
                queue2.remove();
            }
            result = queue2;
            return result;
        }
        for (int i = 0; i < queue1.size()-1; ++i) {
            queue2.add(queue1.peek());
            queue1.remove();
        }
        result = queue1;
        return result;

    }

    public T peek() {
        T result = null;
        Queue<T> queue = neatQueue();
        if (queue != null) {
            result = queue.peek();
        }
        return result;
    }
    public T pop() {
        T result = null;
        Queue<T> queue = neatQueue();
        if (queue != null) {
            --size;
            result = queue.peek();
            queue.remove();
        }
        return result;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
