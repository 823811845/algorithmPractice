package 生成哈夫曼树;

import java.util.LinkedList;

import 树的基础练习.BinaryNode;

public class HuffmanTree extends 树的基础练习.BinaryTree {
	public HuffmanTree(LinkedList<BinaryNode> nodes) {
		super(nodes);
	}
	public HuffmanTree(BinaryNode root) {
		super(root);
	}

	@Override
	public BinaryNode createTree() {
		if (super.nodes == null || super.nodes.size() == 0) {
			return null;
		}
		// 按从小到大的顺序排列
		// quickSort(nodes);
		BinaryNode tempNode = null;
		BinaryNode leftNode, rightNode;
		while (true) {
			if (nodes.size() == 0) {
				super.root = tempNode;
				return tempNode;
			}
			if (tempNode == null) {
				leftNode = pop();
				rightNode = pop();
				tempNode = new BinaryNode<String>(null, leftNode.weight + rightNode.weight);
				tempNode.left = leftNode;
				tempNode.right = rightNode;
				continue;
			}
			// 如果小于列表中的第二个节点，那么就，让这个节点与第一个节点点组成新的树。
			if (nodes.size() == 1 || tempNode.weight <= nodes.get(1).weight) {
				leftNode = pop();
				rightNode = tempNode;
			} else {
				// 否则把这个节点放入队列中
				nodes.add(2, tempNode);
				leftNode = pop();
				rightNode = pop();
			}
			tempNode = new BinaryNode<String>(null, leftNode.weight + rightNode.weight);
			tempNode.left = leftNode;
			tempNode.right = rightNode;
		}
	}

	// 从链表中弹出一个node
	public BinaryNode pop() {
		BinaryNode node = nodes.get(0);
		nodes.remove(0);
		return node;
	}

	@Override
	public void add() {

	}
	
	public static void main(String[] args) {
		LinkedList<BinaryNode> nodes = new LinkedList<BinaryNode>();
		nodes.add(new BinaryNode("z", 1.0));
		nodes.add(new BinaryNode("A", 2.0));
		nodes.add(new BinaryNode("B", 8.0));
		nodes.add(new BinaryNode("C", 11.0));
		nodes.add(new BinaryNode("D", 30.0));
		nodes.add(new BinaryNode("E", 35.0));
		nodes.add(new BinaryNode("F", 40.0));
		HuffmanTree huffman = new HuffmanTree(nodes);
		huffman.createTree();
		System.out.println("哈夫曼树的横向遍历ss\n" + huffman.toString());
		System.out.println(huffman.root);
		System.out.println(huffman.ergodicTree(huffman.root));
	}
}
