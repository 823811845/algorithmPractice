package 树的基础练习;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue<T> nodes = new LinkedList<>();
    // 如果内部有元素，则flag为true
    boolean isEmpty = true;

    public void add(T node) {
        if (node != null) {
            isEmpty = false;
        }
        nodes.add(node);
    }

    public T poll() {
        T tempNode = nodes.poll();
        if (nodes.isEmpty()) {
            isEmpty = true;
        }
        return tempNode;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
