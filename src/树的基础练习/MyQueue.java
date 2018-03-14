package ���Ļ�����ϰ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ţ�����㷨��.FindTreeNode.TreeNode;

public class MyQueue<T> {
	LinkedList<T> list = new LinkedList<>();
	Queue<T> nodes = list;
	// ����ڲ���Ԫ�أ���flagΪtrue
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
