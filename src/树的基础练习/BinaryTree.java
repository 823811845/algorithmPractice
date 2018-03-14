package ���Ļ�����ϰ;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class BinaryTree {
	protected LinkedList<BinaryNode> nodes;
	protected BinaryNode root = null;

	public BinaryTree(LinkedList<BinaryNode> nodes) {
		super();
		this.nodes = nodes;
	}

	public BinaryTree(BinaryNode root) {
		super();
		this.root = root;
	}

	public abstract void add();

	public abstract BinaryNode createTree();

	/**
	 * ����nodes�е��زĽ���һ������
	 * 
	 * @return
	 */
	public BinaryNode createWithMaterial() {
		if (nodes == null || nodes.size() == 0) {
			return null;
		}
		MyQueue<BinaryNode> queue = new MyQueue();
		MyQueue<BinaryNode> queue2 = new MyQueue();
		root = nodes.get(0);
		queue.add(nodes.get(0));
		for (int i = 1; i < nodes.size();) {
			while (!queue.isEmpty() && i < nodes.size()) {
				// �ҵ��ϲ����е�ÿһ���ڵ㣨����null����
				BinaryNode node = queue.poll();
				if (node == null) {

				} else {
					node.left = nodes.get(i++);
					queue2.add(node.left);
					if (nodes.size() > i) {
						node.right = nodes.get(i++);
						queue2.add(node.right);
					}
				}
			}
			// �Ի�����queue,��ʼ��һ��ѭ��;
			MyQueue<BinaryNode> tempQueue = queue;
			queue = queue2;
			queue2 = tempQueue;
		}

		return null;
	}

	/**
	 * �������һ��������
	 * 
	 * @return
	 */
	ArrayList<BinaryNode> nodes2 = new ArrayList();

	public ArrayList<BinaryNode> ergodicTree(BinaryNode root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			ergodicTree(root.left);
		}
		nodes2.add(root);
		if (root.right != null) {
			ergodicTree(root.right);
		}
		return nodes2;
	}

	boolean flag, flag2;

	// �����������һ������
	public String toString() {
		// �����У���ÿһ������нڵ��������У���������һ���ʱ�򣬾Ͱѽڵ㰴˳��ȡ������
		MyQueue<BinaryNode> queue = new MyQueue();
		MyQueue<BinaryNode> queue2 = new MyQueue();
		int maxDepth = 6;
		String str = "";
		if (root == null) {
			return "null";
		}

		// ��ʼ����
		queue.add(root);
		BinaryNode node = null;
		int depth = 0;
		while (!queue.isEmpty() || !queue2.isEmpty()) {
			depth++;
			// ÿ��֮ǰ�Ŀո�
			for (int i = 0; i < Math.pow(2, maxDepth - depth); i++) {
				str += " ";
			}
			while (!queue.isEmpty()) {
				node = queue.poll();
				if (node == null) {
					queue2.add(null);
					queue2.add(null);
					str += "#";
				} else {
					queue2.add(node.left);
					queue2.add(node.right);
					str += node.toString();
				}
				// ÿ���м�Ŀո�
				for (int i = 0; i < Math.pow(2, maxDepth - depth + 1) - 1; i++) {
					str += " ";
				}
			}
			str += "\n";
			MyQueue<BinaryNode> tempQueue = queue;
			queue = queue2;
			queue2 = tempQueue;
		}
		return str;
	}
}
