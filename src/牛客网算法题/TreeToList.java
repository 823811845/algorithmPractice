package ţ�����㷨��;

import java.util.LinkedList;

import ���Ļ�����ϰ.BinaryNode;
import ���Ļ�����ϰ.BinaryTree;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class TreeToList extends BinaryTree {

	public TreeToList(BinaryNode root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	public TreeToList(LinkedList<BinaryNode> nodes) {
		super(nodes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add() {

	}

	@Override
	public BinaryNode createTree() {
		return null;
	}

	public BinaryNode Convert(BinaryNode root) {
		if (root == null)
			return null;

		BinaryNode left = root;
		BinaryNode maxNode = null;
		BinaryNode minNode = null;

		if (root.left != null) {
			left = Convert(root.left);
			// p�ǵ�ǰ��������ֵ��
			maxNode = left.left;
			maxNode.right = root;
			root.left = maxNode;
		} else {
			// ���±ջ�����
			left.left = root;
		}

		if (root.right != null) {
			BinaryNode right = Convert(root.right);
			maxNode = null;
			maxNode = right.left;
			root.right = right;
			right.left = root;

			// ���±ջ�����
			left.left = maxNode;
			return left;
		} else {
			// ���±ջ�����
			left.left = root;
			return left;
		}
	}

	public static void main(String[] args) {
		LinkedList<BinaryNode> nodes = new LinkedList<BinaryNode>();
		nodes.add(new BinaryNode("10", 0));
		nodes.add(new BinaryNode("6", 0));
		nodes.add(new BinaryNode("14", 0));
		nodes.add(new BinaryNode("4", 0));
		nodes.add(new BinaryNode("8", 0));
		nodes.add(new BinaryNode("12", 0));
		nodes.add(new BinaryNode("16", 0));
		TreeToList test = new TreeToList(nodes);
		test.createWithMaterial();
		System.out.println(test.toString());
		BinaryNode result = test.Convert(test.root);
		while (result != null) {
			System.out.println(result);
			result = result.right;
		}
	}
	// public static void main(String[] args) {
	// LinkedList<BinaryNode> nodes = new LinkedList<BinaryNode>();
	// nodes.add(new BinaryNode("z", 1.0));
	// nodes.add(null);
	// nodes.add(new BinaryNode("A", 2.0));
	// nodes.add(new BinaryNode("B", 8.0));
	// nodes.add(new BinaryNode(null, 11.0));
	// nodes.add(new BinaryNode("D", 30.0));
	// nodes.add(new BinaryNode("E", 35.0));
	// nodes.add(new BinaryNode("F", 40.0));
	// Test test=new Test(nodes);
	// test.createWithMaterial();
	// System.out.println(test.toString());
	// }
}
