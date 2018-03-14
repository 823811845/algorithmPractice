package 牛客网算法题;

import java.util.LinkedList;

import 树的基础练习.BinaryNode;
import 树的基础练习.BinaryTree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
			// p是当前链表的最大值；
			maxNode = left.left;
			maxNode.right = root;
			root.left = maxNode;
		} else {
			// 重新闭环处理
			left.left = root;
		}

		if (root.right != null) {
			BinaryNode right = Convert(root.right);
			maxNode = null;
			maxNode = right.left;
			root.right = right;
			right.left = root;

			// 重新闭环处理
			left.left = maxNode;
			return left;
		} else {
			// 重新闭环处理
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
