package ���Ļ�����ϰ;

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

    // �������һ������
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

        // ��ʼ����
        queue.add(root);
        MultiwayNode<T> node = root;
        int depth = 0;
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            depth++;
            // ÿ��֮ǰ�Ŀո�
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
                // ÿ���м�Ŀո�
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
