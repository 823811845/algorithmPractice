package ���ɹ�������;

import java.util.LinkedList;

import ���Ļ�����ϰ.BinaryNode;

public class HuffmanTree extends ���Ļ�����ϰ.BinaryTree {
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
		// ����С�����˳������
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
			// ���С���б��еĵڶ����ڵ㣬��ô�ͣ�������ڵ����һ���ڵ������µ�����
			if (nodes.size() == 1 || tempNode.weight <= nodes.get(1).weight) {
				leftNode = pop();
				rightNode = tempNode;
			} else {
				// ���������ڵ���������
				nodes.add(2, tempNode);
				leftNode = pop();
				rightNode = pop();
			}
			tempNode = new BinaryNode<String>(null, leftNode.weight + rightNode.weight);
			tempNode.left = leftNode;
			tempNode.right = rightNode;
		}
	}

	// �������е���һ��node
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
		System.out.println("���������ĺ������ss\n" + huffman.toString());
		System.out.println(huffman.root);
		System.out.println(huffman.ergodicTree(huffman.root));
	}
}
