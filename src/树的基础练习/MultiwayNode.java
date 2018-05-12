package 树的基础练习;

import java.util.TreeSet;

public class MultiwayNode<T extends Comparable<T>> {
    public T val = null;
    public double weight = 1;
    public TreeSet<MultiwayNode<T>> sonNodes = new TreeSet<>();

    public MultiwayNode(T val) {
        this.val = val;
    }

    public MultiwayNode(T val, double weight) {
        this.weight = weight;
        this.val = val;
    }

    public String toString() {
        if (val == null) {
            return "%";
        }
        return val.toString();
    }

    // 横向遍历一棵树：
    public String treeToString() {
        MyQueue<MultiwayNode<T>> queue = new MyQueue();
        MyQueue<MultiwayNode<T>> queue2 = new MyQueue();
        boolean flag, flag2;
        int maxDepth = 6;
        String str = "";
        MultiwayNode root = this;
        if (root == null) {
            return "null";
        }

        // 开始遍历
        queue.add(root);
        MultiwayNode<T> node = root;
        int depth = 0;
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            depth++;
            // 每行之前的空格
            for (int i = 0; i < (Math.pow(2, maxDepth - depth)) * node.sonNodes.size() / 2; i++) {
                str += " ";
            }
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node == null) {
                    queue2.add(null);
                    queue2.add(null);
                    str += "#";
                } else {
                    for (MultiwayNode tempNode : node.sonNodes) {
                        queue2.add(tempNode);
                    }
                    str += node.toString();
                }
                // 每行中间的空格
                for (int i = 0; i < (Math.pow(2, maxDepth - depth + 1) - 1) * node.sonNodes.size() / 2; i++) {
                    str += " ";
                }
            }
            str += "\n";
            MyQueue<MultiwayNode<T>> tempQueue = queue;
            queue = queue2;
            queue2 = tempQueue;
        }
        return str;
    }

    public void addSonNode(MultiwayNode node) {
        this.sonNodes.add(node);
    }
}
