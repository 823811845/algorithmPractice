package 树的基础练习;

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
	 * 借助nodes中的素材建立一棵树；
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
				// 找到上层数中的每一个节点（包括null）：
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
			// 对换两个queue,开始下一层循环;
			MyQueue<BinaryNode> tempQueue = queue;
			queue = queue2;
			queue2 = tempQueue;
		}

		return null;
	}

	/**
	 * 中序遍历一个二叉树
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

	// 遍历横向遍历一棵树：
	public String toString() {
		// 遍历中，把每一层的所有节点放入队列中，当遍历下一层的时候，就把节点按顺序取出来；
		MyQueue<BinaryNode> queue = new MyQueue();
		MyQueue<BinaryNode> queue2 = new MyQueue();
		int maxDepth = 6;
		String str = "";
		if (root == null) {
			return "null";
		}

		// 开始遍历
		queue.add(root);
		BinaryNode node = null;
		int depth = 0;
		while (!queue.isEmpty() || !queue2.isEmpty()) {
			depth++;
			// 每行之前的空格
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
				// 每行中间的空格
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
