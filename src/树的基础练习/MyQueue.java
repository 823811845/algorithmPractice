package 树的基础练习;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import 牛客网算法题.FindTreeNode.TreeNode;

public class MyQueue<T> {
	LinkedList<T> list = new LinkedList<>();
	Queue<T> nodes = list;
	// 如果内部有元素，则flag为true
	boolean isEmpty = true;

	void add(T node) {
		if (node != null) {
			isEmpty = false;
		}
		nodes.add(node);
	}

	T poll() {
		T tempNode = nodes.poll();
		if (nodes.isEmpty()) {
			isEmpty = true;
		}
		return tempNode;
	}

	boolean isEmpty() {
		return isEmpty;
	}
}
